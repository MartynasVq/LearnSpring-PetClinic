package com.learn.learnspringpetclinic.jpa;

import com.learn.learnspringpetclinic.model.Owner;
import com.learn.learnspringpetclinic.repositories.OwnerRepository;
import com.learn.learnspringpetclinic.repositories.PetRepository;
import com.learn.learnspringpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    @InjectMocks
    OwnerJPAService ownerJPAService;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    String smith1;
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        smith1 = "Smith";
        owner.setLastName(smith1);
        owner.setId(1L);
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner smith = ownerJPAService.findByLastName(smith1);

        assertEquals(smith1, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(2L);
        Owner owner2 = new Owner();
        owner2.setId(3L);
        ownerSet.add(owner1);
        ownerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerJPAService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner temp = ownerJPAService.findById(1L);

        assertNotNull(temp);
    }

    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner temp = ownerJPAService.save(owner);

        assertNotNull(owner);
    }

    @Test
    void delete() {
        ownerJPAService.delete(owner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(1L);

        verify(ownerRepository).deleteById(any());
    }
}