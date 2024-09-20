package org.example.service;

import org.example.dao.schemas.Cat;
import org.example.dao.CatDao;

import java.util.List;

public class CatService {
    private static final CatDao catDao = new CatDao();

    public CatService() {}

    public void persist(Cat cat) {
        catDao.persist(cat);
    }

    public void update(Cat cat) {
        catDao.update(cat);
    }

    public Cat findById(int id) {
        return catDao.findById(id);
    }

    public void delete(int id) {
        catDao.delete(id);
    }

    public List<Cat> findAll() {
        return catDao.findAll();
    }

    public void clear() {
        catDao.clear();
    }
}
