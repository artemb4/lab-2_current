package org.example.service;

import org.example.dao.OwnerDao;
import org.example.dao.schemas.Cat;
import org.example.dao.schemas.Owner;

import java.util.List;

public class OwnerService {
    private static final OwnerDao ownerDao = new OwnerDao();

    public OwnerService() {}

    public void persist(Owner owner) {
        ownerDao.persist(owner);
    }

    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    public void delete(Owner owner) {
        ownerDao.delete(owner.getId());
    }

    public Owner findById(int id) {
        return ownerDao.findById(id);
    }

    public List<Cat> findCats(int id) {
        return ownerDao.findCats(id);
    }

    public void clear() {
        ownerDao.clear();
    }
}
