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
    public List<SocieteCliente> getAllSocClientes() {
        return null;
    }

    @Override
    public SocieteCliente addSocieteCliente(SocieteCliente sc) {
        return null;
    }

    @Override
    public void deleteSocieteCliente(Long id) {

    }

    @Override
    public SocieteCliente findById(Long id) {
        return null;
    }

    @Override
    public SocieteCliente UpdateSocieteCliente(Ouvrier ov) {
        return null;
    }

    @Override
    public Ouvrier getByName(String name) {
        return null;
    }
}
