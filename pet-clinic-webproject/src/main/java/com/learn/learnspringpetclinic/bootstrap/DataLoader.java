package com.learn.learnspringpetclinic.bootstrap;

import com.learn.learnspringpetclinic.model.Owner;
import com.learn.learnspringpetclinic.model.Vet;
import com.learn.learnspringpetclinic.services.OwnerService;
import com.learn.learnspringpetclinic.services.VetService;
import com.learn.learnspringpetclinic.services.map.OwnerServiceMap;
import com.learn.learnspringpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setName("Mike");
        owner1.setLastName("Jacob");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setName("Mikelangelo");
        owner2.setLastName("Jacob");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setName("Vetto");
        vet1.setLastName("Vettorinar");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setName("Jacob");
        vet2.setLastName("Vettorinar");

        ownerService.save(owner1);
        ownerService.save(owner2);
        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Data loaded..");
    }
}
