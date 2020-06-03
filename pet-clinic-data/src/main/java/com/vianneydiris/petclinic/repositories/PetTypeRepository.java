package com.vianneydiris.petclinic.repositories;

import com.vianneydiris.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
