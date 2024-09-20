package org.example.dao;

import org.example.dao.schemas.Cat;
import org.example.dao.schemas.CatFriends;
import org.example.dao.schemas.CatFriendsId;

import java.util.List;

public interface CatFriendsInterface {
    public void persist(CatFriends catFriends);
    public void update(CatFriends catFriends);
    public List<Cat> findById(int catId);
    public void delete(CatFriendsId catFriendsId);
    public void clear();
}
