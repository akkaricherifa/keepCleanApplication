package com.example.keepcleanproxymapp.entities;
import com.example.keepcleanproxymapp.entities.Ouvrier;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class OuvrierPlanning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private @DateTimeFormat(pattern = "yyyy-'W'ww") Date week;
    private Ouvrier ouvrier;
    private String LUNDI;
    private String MARDI;
    private String MERCREDI;
    private String JEUDI;
    private String VENDREDI;
    private String SAMEDI;
    private String DIMANCHE;

}
