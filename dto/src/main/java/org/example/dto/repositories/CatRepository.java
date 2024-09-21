package org.example.dto.repositories;

import org.example.dto.schemas.Cat;
import org.example.dto.schemas.Color;
import org.example.dto.schemas.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    List<Cat> getCatsByColor(Color color);
    List<Cat> getCatsByBreed(String breed);
    List<Cat> getCatsByOwner(Owner owner);
}
