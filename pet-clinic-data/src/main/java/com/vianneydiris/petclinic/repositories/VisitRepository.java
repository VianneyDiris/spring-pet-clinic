package com.vianneydiris.petclinic.repositories;

import com.vianneydiris.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
