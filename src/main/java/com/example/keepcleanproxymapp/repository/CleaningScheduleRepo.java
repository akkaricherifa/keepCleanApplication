package com.example.keepcleanproxymapp.repository;

import com.example.keepcleanproxymapp.entities.CleaningSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningScheduleRepo extends JpaRepository<CleaningSchedule, Long> {
}
