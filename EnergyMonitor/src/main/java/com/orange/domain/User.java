package com.orange.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{

    @Column(name = "name")
    private String name ;
    
    @Column(name = "address")
    private String address ;
    
    @Id
    @Column(name = "apikey")
    private int apikey ;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the apikey
     */
    public int getApikey() {
        return apikey;
    }

    /**
     * @param apikey the apikey to set
     */
    public void setApikey(int apikey) {
        this.apikey = apikey;
    }

    public User(String name, String address, int apikey) {
        this.name = name;
        this.address = address;
        this.apikey = apikey;
    }

    public User() {
    }
    
    
    
}
