package com.vianneydiris.petclinic.bootstrap;

import com.vianneydiris.petclinic.model.Owner;
import com.vianneydiris.petclinic.model.Pet;
import com.vianneydiris.petclinic.model.PetType;
import com.vianneydiris.petclinic.model.Vet;
import com.vianneydiris.petclinic.services.OwnerService;
import com.vianneydiris.petclinic.services.PetService;
import com.vianneydiris.petclinic.services.PetTypeService;
import com.vianneydiris.petclinic.services.VetService;
import com.vianneydiris.petclinic.services.map.OwnerServiceMap;
import com.vianneydiris.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Vianney");
        owner1.setLastName("Diris");
        owner1.setAddress("28 rue storez");
        owner1.setCity("Douai");
        owner1.setTelephone("0328658564");

        Pet mike = new Pet();
        mike.setPetType(savedDogType);
        mike.setName("mike");
        mike.setOwner(owner1);
        mike.setBirthDate(LocalDate.now());

        owner1.getPets().add(mike);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dominique");
        owner2.setLastName("Brelet");
        owner2.setAddress("32 rue storez");
        owner2.setCity("Lille");
        owner2.setTelephone("13456678984");

        Pet sacha = new Pet();
        sacha.setPetType(savedCatType);
        sacha.setName("sacha");
        sacha.setOwner(owner2);
        sacha.setBirthDate(LocalDate.now());

        owner2.getPets().add(sacha);

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
