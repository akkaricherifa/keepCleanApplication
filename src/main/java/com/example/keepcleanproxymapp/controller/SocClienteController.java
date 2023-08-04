package com.example.keepcleanproxymapp.controller;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.entities.SocieteCliente;
import com.example.keepcleanproxymapp.service.IServiceSocieteCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/SocCliente")
public class SocClienteController {
    private IServiceSocieteCliente iServiceSocieteCliente;

    @GetMapping("/all")
    public List<SocieteCliente> getAllSocClientes() {
        return iServiceSocieteCliente.getAllSocClientes();
    }
}
