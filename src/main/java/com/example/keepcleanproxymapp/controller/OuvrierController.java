package com.example.keepcleanproxymapp.controller;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import com.example.keepcleanproxymapp.service.IServiceOuvrier;
import com.example.keepcleanproxymapp.service.OuvrierService;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/ouvriers")


public class OuvrierController {
    private final IServiceOuvrier iso;


    @PostMapping("/add")
    public  Ouvrier ajouterOuvrier(@RequestBody Ouvrier ouvrier) {
        return iso.addOuvrier(ouvrier);

    }

    @GetMapping("/all")
    public List<Ouvrier> getAllOuvrier() {
        return iso.getAllOuvrier();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Ouvrier> getOuvrierByName(@PathVariable String name) {
        Ouvrier ouvrier = iso.getByName(name);
        if (ouvrier != null) {
            return ResponseEntity.ok(ouvrier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ouvrier> updateOuvrier(@PathVariable("id") long id, @RequestBody Ouvrier ouvrier) {
        ouvrier.setId((Long) id);
        Ouvrier updatedOuvrier = iso.UpdateOuvrier(ouvrier);
        return new ResponseEntity<>(updatedOuvrier, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOuvrier(@PathVariable("id") long id) {
        iso.deleteOuvrier(id);

    }







}

