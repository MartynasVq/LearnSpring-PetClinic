package com.learn.learnspringpetclinic.repositories;

import com.learn.learnspringpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
