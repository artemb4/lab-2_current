package org.example.service.services;

import org.example.service.dto.OwnerDTO;
import org.example.dto.repositories.CatRepository;
import org.example.dto.repositories.OwnerRepository;
import org.example.dto.schemas.Cat;
import org.example.dto.schemas.Owner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService implements org.example.service.interfaces.OwnerService {
    private final OwnerRepository repo;
    private final CatRepository catRepo;
    private final ModelMapper mapper;

    @Autowired
    public OwnerService(OwnerRepository repo, CatRepository catRepo, ModelMapper mapper) {
        this.repo = repo;
        this.catRepo = catRepo;
        this.mapper = mapper;
    }

    @Override
    public Owner create(Owner entity) {
        return repo.save(entity);
    }

    @Override
    public OwnerDTO readById(Long key) {
        Owner entity = repo.findById(key).orElse(null);
        if (entity != null) {
            return mapper.map(entity, OwnerDTO.class);
        }
        return null;
    }

    @Override
    public Owner update(Owner entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(Long key) {
        repo.deleteById(key);
    }

    @Override
    public Owner addCat(Long owner, Long cat) {
        Cat cat1 = catRepo.findById(cat).orElse(null);
        OwnerDTO ownerDto = readById(owner);
        Owner oowner = mapper.map(ownerDto, Owner.class);
        oowner.getCats().add(cat1);
        cat1.setOwner(oowner);
        catRepo.save(cat1);
        return repo.save(oowner);
    }

    @Override
    public List<Owner> getAll() {
        return repo.findAll();
    }

    @Override
    public Owner getOwnerByUsername(String name) {
        return repo.findOwnerByName(name);
    }
}
