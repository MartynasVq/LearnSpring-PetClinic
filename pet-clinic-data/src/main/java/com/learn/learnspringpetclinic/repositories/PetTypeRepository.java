package com.learn.learnspringpetclinic.repositories;

import com.learn.learnspringpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
