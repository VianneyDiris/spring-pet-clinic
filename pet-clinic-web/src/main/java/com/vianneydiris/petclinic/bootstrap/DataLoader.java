package com.vianneydiris.petclinic.bootstrap;

import com.vianneydiris.petclinic.model.Owner;
import com.vianneydiris.petclinic.model.Vet;
import com.vianneydiris.petclinic.services.OwnerService;
import com.vianneydiris.petclinic.services.VetService;
import com.vianneydiris.petclinic.services.map.OwnerServiceMap;
import com.vianneydiris.petclinic.services.map.VetServiceMap;
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
        owner1.setFirstName("Vianney");
        owner1.setLastName("Diris");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dominique");
        owner2.setLastName("Brelet");

        ownerService.save(owner2);
        System.out.println("load owners with constructors");

        Vet vet1 = new Vet();
        vet1.setFirstName("Alexis");
        vet1.setLastName("Danterre");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mathéo");
        vet2.setLastName("Diris");

        vetService.save(vet2);

        System.out.println("load vets with constructor");
    }
}
