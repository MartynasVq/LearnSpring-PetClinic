package com.learn.learnspringpetclinic.services.map;

import com.learn.learnspringpetclinic.model.Pet;
import com.learn.learnspringpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {


    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getOwner().getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
