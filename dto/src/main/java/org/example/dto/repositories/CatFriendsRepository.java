package org.example.dto.repositories;

import org.example.dto.schemas.CatFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatFriendsRepository extends JpaRepository<CatFriends, Long> {
}
