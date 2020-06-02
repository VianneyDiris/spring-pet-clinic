package com.vianneydiris.petclinic.services.map;

import com.vianneydiris.petclinic.model.Owner;
import com.vianneydiris.petclinic.model.Pet;
import com.vianneydiris.petclinic.services.OwnerService;
import com.vianneydiris.petclinic.services.PetService;
import com.vianneydiris.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object!=null){
            if (object.getPets()!=null){
                object.getPets().forEach(pet -> {
                    if (pet.getPetType()!=null){
                        if (pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                    }else {
                        throw new RuntimeException("PetType is required");
                    }

                    if (pet.getId() ==null){
                        Pet petSaved = petService.save(pet);
                        pet.setId(petSaved.getId());
                    }

                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
