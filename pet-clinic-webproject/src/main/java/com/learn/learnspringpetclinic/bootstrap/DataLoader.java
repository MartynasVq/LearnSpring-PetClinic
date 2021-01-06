package com.learn.learnspringpetclinic.bootstrap;

import com.learn.learnspringpetclinic.model.Owner;
import com.learn.learnspringpetclinic.model.Pet;
import com.learn.learnspringpetclinic.model.PetType;
import com.learn.learnspringpetclinic.model.Vet;
import com.learn.learnspringpetclinic.services.OwnerService;
import com.learn.learnspringpetclinic.services.PetTypeService;
import com.learn.learnspringpetclinic.services.VetService;
import com.learn.learnspringpetclinic.services.map.OwnerServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }




    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setName("Mike");
        owner1.setLastName("Jacob");
        owner1.setAddress("1 king street");
        owner1.setCity("London");
        owner1.setPhone("447447806123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Yoyo");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("Mikelangelo");
        owner2.setLastName("Jacob");
        owner2.setAddress("2 Queen st.");
        owner2.setCity("London");
        owner2.setPhone("447447546235");

        Pet angelosPet = new Pet();
        angelosPet.setPetType(savedCatPetType);
        angelosPet.setOwner(owner2);
        angelosPet.setBirthday(LocalDate.now());
        angelosPet.setName("Zulu");
        owner1.getPets().add(angelosPet);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setName("Vetto");
        vet1.setLastName("Vettorinar");

        Vet vet2 = new Vet();
        vet2.setName("Jacob");
        vet2.setLastName("Vettorinar");

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Data loaded..");


    }
}
