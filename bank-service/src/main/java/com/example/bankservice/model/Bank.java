package com.example.bankservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("banks")
public class Bank {
    @Id
    private Long id;
    private String name;
    private String address;

    public Bank() {
    }

    public Bank(Long id, String name){ //, String address) {
        this.id = id;
        this.name = name;
//        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
