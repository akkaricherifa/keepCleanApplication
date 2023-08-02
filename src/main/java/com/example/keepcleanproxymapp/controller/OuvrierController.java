package com.example.keepcleanproxymapp.controller;

import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import com.example.keepcleanproxymapp.service.OuvrierService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ouvriers")

@CrossOrigin(origins = "htpp://localhost:4200")
public class OuvrierController {
    @Autowired
    private OuvrierService ouvrierService;
    @Autowired
    private OuvrierRepo ouvrierRepo;
    @Autowired
    ServletContext context;

    //////////////////////// tous les ouvriers/////////////////////////
    @GetMapping("/all")
    public List<Ouvrier> getAllOuvriers() {
        return ouvrierRepo.findAll();
    }

    ////////////// ouvrier par id///////////////////
    @GetMapping("/ouvrier/{id}")
    public ResponseEntity<Ouvrier> findById(@PathVariable("id") Long id) {
        Optional<Ouvrier> ouv = ouvrierService.findById(id);
        if (ouv.isPresent())
            return new ResponseEntity<Ouvrier>(ouv.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Ouvrier>(HttpStatus.NO_CONTENT);

    }
    //////////////////creeer new Ouvrier //////////////////////////
    @PostMapping("/create")
    public ResponseEntity<Ouvrier> create(@RequestBody Ouvrier ouvrier) {
        try {
            ouvrierService.saveOuvrier(ouvrier);
            return new ResponseEntity<Ouvrier>(ouvrier, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<Ouvrier>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
