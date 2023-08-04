package com.example.keepcleanproxymapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Ouvrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String prenom;
    private String adresse;
    private String email;
    private String genre;
    private Long Tel;
    private String age;

    @JsonIgnoreProperties("ouvrier")
    @OneToMany(mappedBy = "ouvrier",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    List<CleaningSchedule> CleaningSchedule;

    public Ouvrier(String name,String prenom,String adresse,String email, String genre, Long Tel, String age) {
        this.name = name;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.genre = genre;
        this.Tel = Tel;
        this.age = age;
    }

}

