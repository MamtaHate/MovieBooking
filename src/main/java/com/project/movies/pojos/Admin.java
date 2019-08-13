package com.project.movies.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mamta
 */

@Table(name="admin")
public class Admin {
    
    @Id   
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "adminId")
    private long id;
    
    @Column(name = "adminUsername")
    private String adminUsername;
    
    @Column(name = "adminPassword")
    private String adminPassword;
    
//    @OneToMany 
//    private Theater theater;
//    
//    @OneToMany
//    private Movie movie;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    
    
}

