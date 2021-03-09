package com.example;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "user")   

public class User {

    @Id @GeneratedValue   
    @Column(name = "ID")

    private long ID;
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;


    public User() {
        
    }
    
    public User(long id, String name, String email, String password) {
            this.ID = id;
            this.name = name;
            this.email = email;
            this.password = password;
    }
    

    public long getID() {return this.ID; }
    public String getName() { return this.name;}
    public String getEmail() { return this.email;}
    public String getPassword() { return this.password;}
    
    public void setID(long id) { this.ID = id;}
    public void setName(String name) { this.name = name;}
    public void setEmail(String email) { this.email = email;}
    public void setPassword(String password) { this.password = password;}
}
