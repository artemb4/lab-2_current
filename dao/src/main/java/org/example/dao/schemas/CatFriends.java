package org.example.dao.schemas;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cat_friends")
public class CatFriends {
    @EmbeddedId
    private CatFriendsId id;

    // Конструкторы, геттеры, сеттеры

    public CatFriends() {}

    public CatFriends(CatFriendsId id) {
        this.id = id;
    }

    public CatFriendsId getId() {
        return id;
    }

    public void setId(CatFriendsId id) {
        this.id = id;
    }
}
