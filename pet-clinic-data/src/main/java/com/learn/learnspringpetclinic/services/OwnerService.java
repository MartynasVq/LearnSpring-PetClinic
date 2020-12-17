package com.learn.learnspringpetclinic.services;

import com.learn.learnspringpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
