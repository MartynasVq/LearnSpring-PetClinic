package com.learn.learnspringpetclinic.repositories;

import com.learn.learnspringpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
