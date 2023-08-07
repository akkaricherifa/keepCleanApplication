package com.example.keepcleanproxymapp.repository;

import com.example.keepcleanproxymapp.entities.Planning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanningRepository extends JpaRepository<Planning, Long> {
}
