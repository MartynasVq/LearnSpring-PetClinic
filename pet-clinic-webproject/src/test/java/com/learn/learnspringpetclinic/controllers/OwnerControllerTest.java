package com.learn.learnspringpetclinic.controllers;

import com.learn.learnspringpetclinic.model.Owner;
import com.learn.learnspringpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    Set<Owner> ownerSet;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ownerSet = new HashSet<>();
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        Owner owner = new Owner();
        Owner owner1 = new Owner();
        ownerSet.add(owner);
        ownerSet.add(owner1);
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners")).andExpect(status().is(200)).andExpect(view()
                .name("owners/index")).andExpect(model().attribute("owners", hasSize(2)));
    }
    @Test
    void listOwnersByPath() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners/index")).andExpect(status().is(200)).andExpect(view()
                .name("owners/index")).andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find")).andExpect(view().name("notimplemented"));

        verifyZeroInteractions(ownerService);
    }
}