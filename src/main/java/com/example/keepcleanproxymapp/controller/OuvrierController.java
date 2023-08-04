package com.example.keepcleanproxymapp.controller;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import com.example.keepcleanproxymapp.service.OuvrierService;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.keepcleanproxymapp.service.OuvrierService.save;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ouvriers")


public class OuvrierController {


    @PostMapping("/add")
    public  ResponseEntity<Ouvrier> addOuvrier(@RequestBody Ouvrier ouvrier) {
        Ouvrier newOuvrier = save(ouvrier);
        return new ResponseEntity<>(newOuvrier, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ouvrier>> getAllOuvriers() {
        return new ResponseEntity<>(OuvrierService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Ouvrier> getOuvrierById(@PathVariable("name") String name) {
        Ouvrier ouvrier = OuvrierService.getByName(name);
        return new ResponseEntity<>(ouvrier, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Ouvrier> updateOuvrier(@PathVariable("id") long id, @RequestBody Ouvrier ouvrier) {
        ouvrier.setId((int) id);
        Ouvrier updatedOuvrier = OuvrierService.update(ouvrier);
        return new ResponseEntity<>(updatedOuvrier, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOuvrier(@PathVariable("id") long id) {
        OuvrierService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

