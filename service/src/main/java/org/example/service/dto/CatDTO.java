package org.example.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.schemas.Color;

import java.util.Date;

@Getter
@Setter
@Data
public class CatDTO {
    private int id;
    private String name;
    private Date date;
    private String breed;
    private Color color;
    private String owner;

    public CatDTO() {}

    public CatDTO(int id, String name, Date date, String breed, Color color, String owner) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
    }
}
