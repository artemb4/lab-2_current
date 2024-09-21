package org.example.service.interfaces;

import org.example.service.dto.CatFriendsDTO;
import org.example.dto.schemas.Cat;
import org.example.dto.schemas.Color;
import org.example.dto.schemas.Owner;
import org.example.service.dto.CatDTO;

import java.util.List;

public interface CatService {
    Cat create(Cat cat);
    CatDTO readById(Long key);
    Cat update(Cat entity);
    void delete(Long key);
    CatFriendsDTO addFriend(Cat cat, Long id);
    List<Cat> GetCatsByColor(Color color);
    List<Cat> GetCatsByBreed(String breed);
    List<Cat> GetCatsByOwner(Owner owner);
}
