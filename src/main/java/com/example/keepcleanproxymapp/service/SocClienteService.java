package com.example.keepcleanproxymapp.service;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.entities.SocieteCliente;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import com.example.keepcleanproxymapp.repository.SocieteClienteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocClienteService implements IServiceSocieteCliente {

    @Autowired
    SocieteClienteRepo societeClienteRepo;


    @Override
    public List<SocieteCliente> getAllSocieteClientes() {
        return societeClienteRepo.findAll();
    }

    @Override
    public SocieteCliente addSocieteCliente(SocieteCliente sc) {
        if (societeClienteRepo.existsByEmail(sc.getEmail())) {
            throw new RuntimeException("email déja existe");
        }
        if (societeClienteRepo.existsByName(sc.getName())) {
            throw new RuntimeException("nom déja existe");
        }
        return societeClienteRepo.save(sc);
    }

    @Override
    public void deleteSocieteCliente(Long id) {
        societeClienteRepo.deleteById(id);

    }

    @Override
    public SocieteCliente findById(Long id) {
        return societeClienteRepo.findById(id).get();
    }

    @Override
    public SocieteCliente UpdateSocieteCliente(SocieteCliente sc) {
        SocieteCliente existingSocieteCliente = societeClienteRepo.findById((long) sc.getId()).orElse(null);
        if (!sc.getEmail().equals(existingSocieteCliente.getEmail()) && societeClienteRepo.existsByEmail(sc.getEmail())) {
            throw new RuntimeException("email déja existe");
        }
        if (!sc.getName().equals(existingSocieteCliente.getName()) && societeClienteRepo.existsByName(sc.getName())) {
            throw new RuntimeException("nom déja existe");
        }
        assert existingSocieteCliente != null;
        return societeClienteRepo.save(existingSocieteCliente);
    }

    @Override
    public Ouvrier getByName(String name) {
        return null;
    }


}
