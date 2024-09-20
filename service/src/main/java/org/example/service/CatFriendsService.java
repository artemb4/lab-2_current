package org.example.service;

import org.example.dao.CatFriendsDao;
import org.example.dao.schemas.Cat;
import org.example.dao.schemas.CatFriends;
import org.example.dao.schemas.CatFriendsId;

import java.util.List;

public class CatFriendsService {
    public static final CatFriendsDao catFriendsDao = new CatFriendsDao();

    public CatFriendsService() {}

    public void persist(CatFriends catFriends) {
        catFriendsDao.persist(catFriends);
    }

    public void update(CatFriends catFriends) {
        catFriendsDao.update(catFriends);
    }

    public List<Cat> findById(int id) {
        return catFriendsDao.findById(id);
    }

    public void delete(CatFriendsId catFriendsId) {
        catFriendsDao.delete(catFriendsId);
    }

    public void clear() {
        catFriendsDao.clear();
    }
}
