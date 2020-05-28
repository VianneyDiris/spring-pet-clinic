package com.vianneydiris.petclinic.services;

import com.vianneydiris.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
