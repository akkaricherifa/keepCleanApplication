package com.example.keepcleanproxymapp.service;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OuvrierService {
    private final OuvrierRepo ouvrierRepo;

    public OuvrierService(OuvrierRepo ouvrierRepo){
        this.ouvrierRepo = ouvrierRepo;
    }

    public List<Ouvrier> getAllOuvriers() {
        return ouvrierRepo.findAll();
    }

    public Optional<Ouvrier> findById(Long id) {

        return ouvrierRepo.findById(id);

    }

    public boolean saveOuvrier(Ouvrier ouvrier) {

        if (ouvrierRepo.save(ouvrier) != null)
            return true;
        else
            return false;
    }

}
