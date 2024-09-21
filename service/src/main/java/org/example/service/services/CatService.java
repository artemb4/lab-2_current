package org.example.service.services;

import org.example.service.dto.CatDTO;
import org.example.service.dto.CatFriendsDTO;
import org.example.dto.repositories.CatFriendsRepository;
import org.example.dto.schemas.*;
import org.example.dto.repositories.CatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService implements org.example.service.interfaces.CatService {
    private final CatRepository repo;
    private final ModelMapper mapper;
    private final CatFriendsRepository catFriendsRepo;

    @Autowired
    public CatService(CatRepository repo, ModelMapper mapper, CatFriendsRepository catFriendsRepo) {
        this.repo = repo;
        this.mapper = mapper;
        this.catFriendsRepo = catFriendsRepo;
    }

    @Override
    public Cat create(Cat cat) {
        return repo.save(cat);
    }

    @Override
    public CatDTO readById(Long key) {
        Cat cat = repo.findById(key).orElse(null);
        return mapper.map(cat, CatDTO.class);
    }

    @Override
    public Cat update(Cat entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Long key) {
        CatDTO dto = readById(key);
        repo.delete(mapper.map(dto, Cat.class));
    }

    @Override
    public CatFriendsDTO addFriend(Cat cat, Long id) {
        CatFriendsDTO dto = new CatFriendsDTO(new CatFriendsId(cat.getId(), id));
        catFriendsRepo.save(mapper.map(dto, CatFriends.class));
        return dto;
    }

    @Override
    public List<Cat> GetCatsByColor(Color color) {
        return repo.getCatsByColor(color);
    }

    @Override
    public List<Cat> GetCatsByBreed(String breed) {
        return repo.getCatsByBreed(breed);
    }

    @Override
    public List<Cat> GetCatsByOwner(Owner owner) {
        return repo.getCatsByOwner(owner);
    }
}
