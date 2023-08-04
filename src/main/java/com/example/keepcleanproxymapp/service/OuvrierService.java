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
public class OuvrierService {

    private final OuvrierRepo ouvrierRepo;


    ///////////////////////save ///////////////////////////////
    public  Ouvrier save(Ouvrier ouvrier) {
        if (ouvrierRepo.existsByEmail(ouvrier.getEmail())) {
            throw new RuntimeException("email déja existe");
        }
        if (ouvrierRepo.existsByName(ouvrier.getName())) {
            throw new RuntimeException("nom déja existe");
        }
        if (ouvrierRepo.existsByTel(ouvrier.getTel())) {
            throw new RuntimeException("numero de télephone déja existe");
        }


        return ouvrierRepo.save(ouvrier);
    }

    /////////////////liste all ouvrier/////////////////////
    public  List<Ouvrier> getAll() {
        return ouvrierRepo.findAll();
    }


    ///////////////////get by name//////////////
    public  Ouvrier getByName(String name) {
        return ouvrierRepo.findByName(name).orElse(null);
    }

    //////////////////supprimerrrr////////////////////////
    public  void delete(long id) {
        Ouvrier ouvrier = ouvrierRepo.findById(id).orElse(null);

        ouvrierRepo.deleteById(id);
    }

    public Ouvrier update(Ouvrier ouvrier) {
        Ouvrier existingOuvrier = ouvrierRepo.findById((long) ouvrier.getId()).orElse(null);
        if (!ouvrier.getEmail().equals(existingOuvrier.getEmail()) && ouvrierRepo.existsByEmail(ouvrier.getEmail())) {
            throw new RuntimeException("email déja existe");
        }
        if (!ouvrier.getName().equals(existingOuvrier.getName()) && ouvrierRepo.existsByName(ouvrier.getName())) {
            throw new RuntimeException("nom déja existe");
        }
        if (ouvrier.getTel() != existingOuvrier.getTel() && ouvrierRepo.existsByTel(ouvrier.getTel())) {
            throw new RuntimeException("numero de télephone déja existe");
        }

        assert existingOuvrier != null;
        return ouvrierRepo.save(existingOuvrier);
    }
}
