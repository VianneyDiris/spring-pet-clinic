package com.vianneydiris.petclinic.repositories;

import com.vianneydiris.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
