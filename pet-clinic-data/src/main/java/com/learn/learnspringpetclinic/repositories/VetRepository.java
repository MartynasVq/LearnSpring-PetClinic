package com.learn.learnspringpetclinic.repositories;

import com.learn.learnspringpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
