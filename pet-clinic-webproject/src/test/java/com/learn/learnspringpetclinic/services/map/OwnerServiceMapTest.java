package com.learn.learnspringpetclinic.services.map;

import com.learn.learnspringpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Smith");
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1L));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        Owner owner2 = new Owner();
        owner2.setId(2L);

        assertEquals(2L, owner2.getId());
    }

    @Test
    void saveNoID() {
        Owner owner2 = new Owner();


        assertNotNull(ownerServiceMap.save(owner2).getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);

        assertEquals(1L, owner.getId());
    }

    @Test
    void findByLastName() {

        assertEquals(1L, ownerServiceMap.findByLastName("Smith").getId());
    }
}