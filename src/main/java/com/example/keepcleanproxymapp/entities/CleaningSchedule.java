package com.example.keepcleanproxymapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class CleaningSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private LocalTime startTime;
    private LocalTime endTime;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDay;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDay;

    @ManyToOne
    private Ouvrier ouvrier;

}
