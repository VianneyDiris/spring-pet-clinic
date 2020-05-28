package com.vianneydiris.petclinic.services;

import com.vianneydiris.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save (Vet vet);
    Set<Vet> findAll();
}
