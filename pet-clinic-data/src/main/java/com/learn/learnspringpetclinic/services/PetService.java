package com.learn.learnspringpetclinic.services;

import com.learn.learnspringpetclinic.model.Owner;
import com.learn.learnspringpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Owner owner);

    Set<Pet> findAll();
}
