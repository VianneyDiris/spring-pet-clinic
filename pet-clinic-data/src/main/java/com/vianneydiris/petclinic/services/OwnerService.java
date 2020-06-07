package com.vianneydiris.petclinic.services;

import com.vianneydiris.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
