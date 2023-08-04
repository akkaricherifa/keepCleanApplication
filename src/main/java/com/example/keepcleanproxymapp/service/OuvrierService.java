package com.example.keepcleanproxymapp.service;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OuvrierService implements IServiceOuvrier {

    @Autowired
    OuvrierRepo ouvrierRepo;


    public Ouvrier getOuvrierByName(String name){
        return ouvrierRepo.findByName(name);
    }


    @Override
    public List<Ouvrier> getAllOuvrier() {
        return ouvrierRepo.findAll();
    }

    @Override
    public Ouvrier addOuvrier(Ouvrier ov) {
        if (ouvrierRepo.existsByEmail(ov.getEmail())) {
            throw new RuntimeException("email déja existe");
        }
        if (ouvrierRepo.existsByName(ov.getName())) {
            throw new RuntimeException("nom déja existe");
        }
        if (ouvrierRepo.existsByTel(ov.getTel())) {
            throw new RuntimeException("numero de télephone déja existe");
        }
        return ouvrierRepo.save(ov);
    }

    @Override
    public void deleteOuvrier(Long id) {
        ouvrierRepo.deleteById(id);

    }

    @Override
    public Ouvrier findById(Long id) {
        return ouvrierRepo.findById(id).get();
    }

    @Override
    public Ouvrier UpdateOuvrier(Ouvrier ov) {
        Ouvrier existingOuvrier = ouvrierRepo.findById((long) ov.getId()).orElse(null);
        if (!ov.getEmail().equals(existingOuvrier.getEmail()) && ouvrierRepo.existsByEmail(ov.getEmail())) {
            throw new RuntimeException("email déja existe");
        }
        if (!ov.getName().equals(existingOuvrier.getName()) && ouvrierRepo.existsByName(ov.getName())) {
            throw new RuntimeException("nom déja existe");
        }
        if (ov.getTel() != existingOuvrier.getTel() && ouvrierRepo.existsByTel(ov.getTel())) {
            throw new RuntimeException("numero de télephone déja existe");
        }

        assert existingOuvrier != null;
        return ouvrierRepo.save(existingOuvrier);
    }



    @Override
    public Ouvrier getByName(String name) {
        return ouvrierRepo.findByName(name);
    }
}
