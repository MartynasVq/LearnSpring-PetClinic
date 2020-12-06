package com.learn.learnspringpetclinic.services;

import com.learn.learnspringpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Set<Vet> findAll();

    Vet findById(Long id);

    Vet save(Vet vet);
}
