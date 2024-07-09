package com.ismail.sports.repository;

import com.ismail.sports.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // You can define custom queries or methods here if needed
}
