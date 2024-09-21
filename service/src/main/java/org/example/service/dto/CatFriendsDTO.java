package org.example.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.schemas.CatFriendsId;

@Getter
@Setter
@Data
public class CatFriendsDTO {
    private CatFriendsId id;

    public CatFriendsDTO() {}

    public CatFriendsDTO(CatFriendsId catFriendsId) {
        this.id = catFriendsId;
    }
}
