package org.example.service.interfaces;

import org.example.service.dto.OwnerDTO;
import org.example.dto.schemas.Owner;

import java.util.List;

public interface OwnerService {
    Owner create(Owner entity);
    OwnerDTO readById(Long key);
    Owner update(Owner entity);
    void delete(Long key);
    Owner addCat(Long owner, Long cat);
    List<Owner> getAll();
    Owner getOwnerByUsername(String name);
}
