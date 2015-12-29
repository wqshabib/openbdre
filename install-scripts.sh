#!/usr/bin/env bash

if [ $# -ne 1 ]
  then
    echo "usage $0 <local|remote>"
    exit 1
fi

BDRE_HOME=~/bdre
BDRE_APPS_HOME=~/bdre_apps

rm -f -r $BDRE_HOME
mkdir -p $BDRE_HOME/bdre-scripts
mkdir -p $BDRE_HOME/lib
mkdir -p $BDRE_APPS_HOME
mkdir $BDRE_HOME-wfd

cp -f -r bdre-scripts/$1/* $BDRE_HOME/bdre-scripts

cp -r -f target/lib/* $BDRE_HOME/lib
java -cp "target/lib/genconf-dump/*" com.wipro.ats.bdre.md.util.DumpConfigMain -cg scripts_config -f $BDRE_HOME/bdre-scripts/env.properties
. $BDRE_HOME/bdre-scripts/env.properties

#Adding sudo because its a non user dir
sudo mkdir -p $flumeLibDir/plugins.d/bdre-hdfs/lib
sudo cp target/lib/flume-hdfs-sink/* $flumeLibDir/plugins.d/bdre-hdfs/lib

chmod +x $BDRE_HOME/bdre-scripts/deployment/*
chmod +x $BDRE_HOME/bdre-scripts/execution/*

#Install crontab for deployment daemon * * * * * - every min

(crontab -l ; echo "* * * * * $BDRE_HOME/bdre-scripts/deployment/process-deploy.sh") 2>&1 | grep -v "no crontab" | sort | uniq | crontab -

#Create log dir
sudo mkdir /var/log/BDRE
sudo chown cloudera:cloudera /var/log/BDRE

cd $BDRE_HOME
rm -r -f cdh-twitter-example
git clone https://github.com/cloudera/cdh-twitter-example.git
cd cdh-twitter-example/flume-sources
mvn package
sudo mkdir -p $flumeLibDir/plugins.d/twitter/lib
sudo cp target/flume-sources-1.0-SNAPSHOT.jar $flumeLibDir/plugins.d/twitter/lib
sudo cp target/flume-sources-1.0-SNAPSHOT.jar $BDRE_HOME/lib
cd ../hive-serdes
mvn package
sudo cp target/hive-serdes-1.0-SNAPSHOT.jar $BDRE_HOME/lib
echo "add jar $BDRE_HOME/lib/hive-serdes-1.0-SNAPSHOT.jar" > ~/.hiverc
cd $BDRE_HOME
rm -r -f cdh-twitter-example







