package com.learn.learnspringpetclinic.services.map;

import com.learn.learnspringpetclinic.model.Visit;
import com.learn.learnspringpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {

        if(object.getPet() == null || object.getPet().getId() == null || object.getPet().getOwner() == null ||
        object.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Visit data.");
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}