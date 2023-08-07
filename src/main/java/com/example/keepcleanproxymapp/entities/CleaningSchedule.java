package com.example.keepcleanproxymapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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
    @DateTimeFormat(pattern = "yyyy-'W'ww")
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToMany
    private List <Ouvrier> ouvrier;
}
