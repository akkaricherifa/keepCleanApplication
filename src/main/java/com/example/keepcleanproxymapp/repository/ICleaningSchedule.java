package com.example.keepcleanproxymapp.repository;

import com.example.keepcleanproxymapp.entities.CleaningSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICleaningSchedule extends JpaRepository<CleaningSchedule, Long> {
}
