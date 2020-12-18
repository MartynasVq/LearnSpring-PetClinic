package com.learn.learnspringpetclinic.bootstrap;

import com.learn.learnspringpetclinic.model.Owner;
import com.learn.learnspringpetclinic.model.Vet;
import com.learn.learnspringpetclinic.services.OwnerService;
import com.learn.learnspringpetclinic.services.VetService;
import com.learn.learnspringpetclinic.services.map.OwnerServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setName("Mike");
        owner1.setLastName("Jacob");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("Mikelangelo");
        owner2.setLastName("Jacob");
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


        ownerService.findAll().forEach(System.out::println);

    }
}
