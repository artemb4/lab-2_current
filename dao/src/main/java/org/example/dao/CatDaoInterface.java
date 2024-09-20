package org.example.dao;

import org.example.dao.schemas.Cat;

import java.util.List;

public interface CatDaoInterface {
    public void persist(Cat cat);
    public void update(Cat cat);
    public Cat findById(int id);
    public void delete(int id);
    public List<Cat> findAll();
    public void clear();
}
