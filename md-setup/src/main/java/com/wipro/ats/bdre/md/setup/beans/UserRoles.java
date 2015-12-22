package com.wipro.ats.bdre.md.setup.beans;
// Generated Dec 21, 2015 11:26:14 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserRoles generated by hbm2java
 */
@Entity
@Table(name="USER_ROLES"
    ,schema="BDRE"
    ,catalog="BDRE"
)
public class UserRoles  implements java.io.Serializable {


     private Integer userRoleId;
     private String username;
     private String role;

    public UserRoles() {
    }

    public UserRoles(String username, String role) {
       this.username = username;
       this.role = role;
    }
   
     @Id 
    
    @Column(name="USER_ROLE_ID", unique=true, nullable=false)
    public Integer getUserRoleId() {
        return this.userRoleId;
    }
    
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }
    
    @Column(name="USERNAME", nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="ROLE", nullable=false, length=45)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }




}


