package com.example.keepcleanproxymapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private @DateTimeFormat(pattern = "yyyy-'W'ww") Date week;

    private String LUNDI;
    private String MARDI;
    private String MERCREDI;
    private String JEUDI;
    private String VENDREDI;
    private String SAMEDI;
    private String DIMANCHE;
    @OneToOne
    private Ouvrier ouvrier;
}
