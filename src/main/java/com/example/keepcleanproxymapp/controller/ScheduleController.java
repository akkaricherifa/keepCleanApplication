package com.example.keepcleanproxymapp.controller;

import com.example.keepcleanproxymapp.entities.CleaningSchedule;
import com.example.keepcleanproxymapp.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @GetMapping("/getOuvrierPlanning/{id}")
    public ResponseEntity<List<CleaningSchedule>> getOuvrierPlanning(@PathVariable("week") String week, @PathVariable("id") long id){
      try {
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          Date weekDate = dateFormat.parse(week) ;
          List<CleaningSchedule> shiftRequirements = scheduleService.generateOuvrierPlanning(weekDate,id);
          return  ResponseEntity.ok(shiftRequirements);
      } catch (ParseException e) {
          e.printStackTrace();
          return ResponseEntity.badRequest().build();
      }
    }
}
