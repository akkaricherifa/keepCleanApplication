package com.example.keepcleanproxymapp.service;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.entities.SocieteCliente;

import java.util.List;

public interface IServiceSocieteCliente {
    public List<SocieteCliente> getAllSocClientes();
    public SocieteCliente addSocieteCliente(SocieteCliente sc);
    public void deleteSocieteCliente(Long id);
    public SocieteCliente findById(Long id);
    public SocieteCliente UpdateSocieteCliente(Ouvrier ov);

    Ouvrier getByName(String name);
}
