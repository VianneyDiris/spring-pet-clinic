package com.vianneydiris.petclinic.services.map;

import com.vianneydiris.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if (object!=null){
            if (object.getId()==null){
                object.setId(getNextId());
            }else{
                throw new  RuntimeException("object cannot be null");
            }
            map.put(object.getId(),object);
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long getNextId(){
        Long id;
        try {
            id = Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
            id = 1L;
        }
        return id;
    }
}
