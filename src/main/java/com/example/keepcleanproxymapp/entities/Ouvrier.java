package com.example.keepcleanproxymapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 */
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
    private Long tel;
    private String age;


    @OneToMany(mappedBy = "ouvrier", fetch = FetchType.LAZY, orphanRemoval = true)
   private List<CleaningSchedule> cleaningSchedules;

    public Ouvrier (String name,String prenom,String adresse,String email, String genre, Long tel, String age) {
        this.name = name;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.genre = genre;
        this.tel = tel;
        this.age = age;
    }

}

