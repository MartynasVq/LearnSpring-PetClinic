package com.learn.learnspringpetclinic.repositories;

import com.learn.learnspringpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
