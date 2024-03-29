package com.learn.learnspringpetclinic.services.map;

import com.learn.learnspringpetclinic.model.Owner;
import com.learn.learnspringpetclinic.model.Pet;
import com.learn.learnspringpetclinic.model.PetType;
import com.learn.learnspringpetclinic.services.CrudService;
import com.learn.learnspringpetclinic.services.OwnerService;
import com.learn.learnspringpetclinic.services.PetService;
import com.learn.learnspringpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petType) {
        this.petTypeService = petTypeService;
        this.petService = petType;
    }



    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        Owner savedOwner = null;
        if(object != null) {

            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else {
                        throw new RuntimeException("Pet type required.");
                    }

                    if(pet.getId() == null) {

                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);

        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(p ->
                p.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}
