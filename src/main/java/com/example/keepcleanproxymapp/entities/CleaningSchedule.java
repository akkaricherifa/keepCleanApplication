package com.example.keepcleanproxymapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CleaningSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Ouvrier ouvrier;
}
