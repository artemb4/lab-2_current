package org.example.dao;

import org.example.dao.schemas.Owner;
import org.example.dao.schemas.Cat;

import java.util.List;

public interface OwnerDaoInterface {
    public void persist(Owner owner);
    public void update(Owner owner);
    public Owner findById(int id);
    public void delete(int id);
    public List<Cat> findCats(int id);
    public void clear();
}
