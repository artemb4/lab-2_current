package org.example.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class OwnerDTO {
    private int id;
    private String name;
    private List<CatDTO> cats;

    public OwnerDTO() {}

    public OwnerDTO(int id, String name, List<CatDTO> cats) {
        this.id = id;
        this.name = name;
        this.cats = cats;
    }
}
