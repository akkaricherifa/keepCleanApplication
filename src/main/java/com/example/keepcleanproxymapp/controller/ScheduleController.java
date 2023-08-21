package com.example.keepcleanproxymapp.controller;

import com.example.keepcleanproxymapp.entities.CleaningSchedule;
import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.service.OuvrierService;
import com.example.keepcleanproxymapp.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.badRequest;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

//    @GetMapping("/getOuvrierPlanning/{id}")
//    public ResponseEntity<List<CleaningSchedule>> getOuvrierPlanning(@PathVariable("week") String week, @PathVariable("id") long id){
//      try {
//          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//          Date weekDate = dateFormat.parse(week) ;
//          List<CleaningSchedule> shiftRequirements = scheduleService.generateOuvrierPlanning(weekDate,id);
//          return  ResponseEntity.ok(shiftRequirements);
//      } catch (ParseException e) {
//          e.printStackTrace();
//          return ResponseEntity.badRequest().build();
//      }
//    }


//    @PostMapping("/addOuvrierPlanning/{id}")
//    public ResponseEntity<CleaningSchedule> addOuvrierPlanning(@PathVariable("week") String week, @RequestBody CleaningSchedule cleaningSchedule) throws ParseException {
//        Ouvrier ouvrier = OuvrierService.getOuvrierById("id");
//        if (ouvrier == null) {
//            return ResponseEntity.notFound().build();
//        }
//        if (cleaningSchedule == null) {
//            return ResponseEntity.ok().badRequest().body("Le planning est incomplet.");
//        }
//        ouvrier.setPlanning(cleaningSchedule);
//        OuvrierService.saveOuvrier(ouvrier);
//
//        return ResponseEntity.ok("Le planning a été ajouté avec succès.");
//    }
//    }
//



}
