package com.example.keepcleanproxymapp.repository;

import com.example.keepcleanproxymapp.entities.CleaningSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<CleaningSchedule, Long> {
    Optional<CleaningSchedule> findByWeek(Date week);
}
