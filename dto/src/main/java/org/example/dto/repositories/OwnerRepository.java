package org.example.dto.repositories;

import org.example.dto.schemas.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findOwnerByName(String Username);
}
