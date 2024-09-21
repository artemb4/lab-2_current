package org.example.dto.schemas;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "cat_friends")
public class CatFriends {
    @EmbeddedId
    private CatFriendsId id;

    public CatFriends() {}
}
