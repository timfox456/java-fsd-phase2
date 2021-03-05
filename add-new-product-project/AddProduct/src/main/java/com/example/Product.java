package com.example;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "products")   

public class Product {
	

    @Id @GeneratedValue   
    @Column(name = "ID")

    private long ID;
    @Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "color")
    private String color;

    
    public Product() {
        
    }
    
    public Product(long id, String name, String color, BigDecimal price) {
            this.ID = id;
            this.name = name;
            this.price = price;
            this.color = color;
    }
    

    public long getID() {return this.ID; }
    public String getName() { return this.name;}
    public BigDecimal getPrice() { return this.price;}
    public String getColor() { return this.color;}
    
    public void setID(long id) { this.ID = id;}
    public void setName(String name) { this.name = name;}
    public void setPrice(BigDecimal price) { this.price = price;}
    public void setColor(String color) { this.color = color;}
}


    
    
