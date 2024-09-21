package org.example.dto.schemas;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import java.util.Objects;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CatFriendsId implements Serializable {
    @Column(name = "cat_id")
    private Long catId;

    @Column(name = "friend_cat_id")
    private Long friendCatId;

    public CatFriendsId() {}

    public CatFriendsId(Long catId, Long friendCatId) {
        this.catId = catId;
        this.friendCatId = friendCatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatFriendsId that = (CatFriendsId) o;
        return Objects.equals(catId, that.catId) && Objects.equals(friendCatId, that.friendCatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, friendCatId);
    }
}
