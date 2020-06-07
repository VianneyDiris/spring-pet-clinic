package com.vianneydiris.petclinic.repositories;

import com.vianneydiris.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastname);

    List<Owner> findAllByLastNameLike(String lastName);
}
