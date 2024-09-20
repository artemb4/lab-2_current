package org.example.dao.schemas;

import javax.persistence.Column;
import java.util.Objects;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CatFriendsId implements Serializable {
    @Column(name = "cat_id")
    private int catId;

    @Column(name = "friend_cat_id")
    private int friendCatId;

    public CatFriendsId() {}

    public CatFriendsId(int catId, int friendCatId) {
        this.catId = catId;
        this.friendCatId = friendCatId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getFriendCatId() {
        return friendCatId;
    }

    public void setFriendCatId(int friendCatId) {
        this.friendCatId = friendCatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatFriendsId that = (CatFriendsId) o;
        return catId == that.catId && friendCatId == that.friendCatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, friendCatId);
    }
}
