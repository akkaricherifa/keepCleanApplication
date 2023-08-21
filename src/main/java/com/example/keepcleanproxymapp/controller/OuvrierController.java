package com.example.keepcleanproxymapp.controller;
import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.AppUserRepository;
import com.example.keepcleanproxymapp.service.IServiceOuvrier;
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


    @Autowired
    private AppUserRepository appUserRepository;


    @PostMapping("/add")
    public Ouvrier ajouterOuvrier(@RequestBody Ouvrier ouvrier) {
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

//cette methode pour avoir le plan d'un ouvrier
//    @GetMapping("/ouvrierPlann/{week}/{id}")
//    public ResponseEntity<List<Ouvrier>> getOuvrierPlannForWeek(@PathVariable("week") String week,@PathVariable("id") long id) {
//
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-'W'ww");
//            Date weekDate = dateFormat.parse(week);
//            List<Ouvrier>  shiftRequirements = OuvrierService.getOuvrierPlannForWeek(weekDate,id);
//            return ResponseEntity.ok(shiftRequirements);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().build();
//        }


//    @PostMapping("/createPresence")
//    public Presence createPresence(@RequestBody ObjectNode presence, @RequestParam Long id) throws JsonProcessingException {
//        Presence pre = new Presence();
//        pre.setNbrheures(new ObjectMapper().treeToValue(presence.get("nbrheures"), Integer.class));
//        pre.setDay(LocalDate.parse(new ObjectMapper().treeToValue(presence.get("day"), String.class)));
//        Optional<AppUser> user = appUserRepository.findById(id);
//
//        return presenceRepo.save(pre);
//    }
}










