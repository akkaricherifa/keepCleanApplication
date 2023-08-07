package com.example.keepcleanproxymapp.controller;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.entities.SocieteCliente;
import com.example.keepcleanproxymapp.service.IServiceSocieteCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/SocCliente")
public class SocClienteController {
    private final IServiceSocieteCliente isc;

    @PostMapping("/add")
    public  SocieteCliente ajouterSocCliente(SocieteCliente societeCliente) {
        return isc.addSocieteCliente(societeCliente);
    }
    @GetMapping("/all")
    public List<SocieteCliente> getAllSocieteClientes() {
        return isc.getAllSocieteClientes();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SocieteCliente> updateSocieteCliente(@PathVariable("id") long id, @RequestBody SocieteCliente sc) {
        sc.setId((Long) id);
        SocieteCliente updatedSocieteCliente = isc.UpdateSocieteCliente(sc);
        return new ResponseEntity<>(updatedSocieteCliente, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteSocieteCliente(@PathVariable("id") long id) {
        isc.deleteSocieteCliente(id);

    }
}
