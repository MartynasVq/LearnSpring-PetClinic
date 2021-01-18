package com.learn.learnspringpetclinic.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "number")
    private String phone;



    public Set<Pet> getPets() {
        return this.pets;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
