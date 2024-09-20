package org.example.dao;

import org.example.dao.schemas.Cat;
import org.example.dao.schemas.Color;
import org.example.dao.schemas.Owner;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatDaoTest {

    @Test
    public void testAddCat() {
        OwnerDao ownerDao = new OwnerDao();
        ownerDao.clear();

        Owner owner = new Owner("artemka");
        ownerDao.persist(owner);

        CatDao catDao = new CatDao();
        catDao.clear();

        Calendar calendar = Calendar.getInstance();

        calendar.set(2024, Calendar.AUGUST, 31);

        catDao.persist(new Cat("artem", calendar.getTime(), "breed", Color.BLACK, owner));
        Cat cat = catDao.findById(1);

        assertEquals("artem", cat.getName());
    }
}
