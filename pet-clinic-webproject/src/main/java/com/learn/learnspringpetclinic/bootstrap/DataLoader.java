package com.learn.learnspringpetclinic.bootstrap;

import com.learn.learnspringpetclinic.model.*;
import com.learn.learnspringpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0)
            loadData();

    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

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
        owner2.getPets().add(angelosPet);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setName("Vetto");
        vet1.setLastName("Vettorinar");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedDentistry);
        Vet vet2 = new Vet();
        vet2.setName("Jacob");
        vet2.setLastName("Vettorinar");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);

        Visit visitCat = new Visit();
        visitCat.setPet(angelosPet);
        visitCat.setDate(LocalDate.now());
        visitCat.setDescription("Check out the legs");
        angelosPet.getVisitSet().add(visitCat);

        visitService.save(visitCat);

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Data loaded..");
    }
}
