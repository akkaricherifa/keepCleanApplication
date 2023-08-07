package com.example.keepcleanproxymapp.service;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IServiceOuvrier {
    void saveOuvrier(Ouvrier ouvrier);

    Ouvrier getOuvrierById(Long id);

    public List<Ouvrier> getAllOuvrier();
    public Ouvrier addOuvrier(Ouvrier ov);
    public void deleteOuvrier(Long id);
    public Ouvrier findById(Long id);
    public Ouvrier UpdateOuvrier(Ouvrier ov);

    Ouvrier getByName(String name);
}
