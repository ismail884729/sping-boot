package com.ismail.sports.repository;

import com.ismail.sports.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    // You can define custom queries or methods here if needed
}
