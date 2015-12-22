package com.wipro.ats.bdre.md.setup.beans;
// Generated Dec 21, 2015 11:26:14 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GeneralConfigId generated by hbm2java
 */
@Embeddable
public class GeneralConfigId  implements java.io.Serializable {


     private String configGroup;
     private String gcKey;

    public GeneralConfigId() {
    }

    public GeneralConfigId(String configGroup, String gcKey) {
       this.configGroup = configGroup;
       this.gcKey = gcKey;
    }
   

    @Column(name="CONFIG_GROUP", nullable=false, length=128)
    public String getConfigGroup() {
        return this.configGroup;
    }
    
    public void setConfigGroup(String configGroup) {
        this.configGroup = configGroup;
    }

    @Column(name="GC_KEY", nullable=false, length=128)
    public String getGcKey() {
        return this.gcKey;
    }
    
    public void setGcKey(String gcKey) {
        this.gcKey = gcKey;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GeneralConfigId) ) return false;
		 GeneralConfigId castOther = ( GeneralConfigId ) other; 
         
		 return ( (this.getConfigGroup()==castOther.getConfigGroup()) || ( this.getConfigGroup()!=null && castOther.getConfigGroup()!=null && this.getConfigGroup().equals(castOther.getConfigGroup()) ) )
 && ( (this.getGcKey()==castOther.getGcKey()) || ( this.getGcKey()!=null && castOther.getGcKey()!=null && this.getGcKey().equals(castOther.getGcKey()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getConfigGroup() == null ? 0 : this.getConfigGroup().hashCode() );
         result = 37 * result + ( getGcKey() == null ? 0 : this.getGcKey().hashCode() );
         return result;
   }   


}


