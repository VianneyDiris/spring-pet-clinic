package com.vianneydiris.petclinic.repositories;

import com.vianneydiris.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
