package com.ismail.sports.repository;

import com.ismail.sports.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // You can define custom queries or methods here if needed
}
