package com.vianneydiris.petclinic.bootstrap;

import com.vianneydiris.petclinic.model.*;
import com.vianneydiris.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petService.findAll().size();
        if (count==0) {
            localData();
        }
    }

    private void localData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");

        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(sacha);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cough kitten");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Alexis");
        vet1.setLastName("Danterre");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mathéo");
        vet2.setLastName("Diris");
        vet2.getSpecialities().add(savedDentistry);
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("load vets with constructor");

    }
}
