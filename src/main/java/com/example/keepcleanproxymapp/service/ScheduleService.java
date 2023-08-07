package com.example.keepcleanproxymapp.service;

import com.example.keepcleanproxymapp.entities.CleaningSchedule;
import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.AppUserRepository;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import com.example.keepcleanproxymapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private AppUserRepository appUserRepository;
    private final OuvrierRepo ouvrierRepo;



//    public List<CleaningSchedule> generateOuvrierPlanning(Date week, long user) {
//        Map<Ouvrier, List<CleaningSchedule>> CleaningScheduleByOuvrier = CleaningScheduleByOuvrier.stream()
//                .collect(Collectors.groupingBy(CleaningSchedule::getOuvrier));
//
//
//        //////////////////////////////////// generate ouvrier planing for each ouvrier
//
//        List<CleaningSchedule> cleaningSchedulesList = new ArrayList<>();
//        for (Map.Entry<Ouvrier, List<CleaningSchedule>> entry : CleaningScheduleByOuvrier.entrySet()) {
//            Ouvrier ouvrier = entry.getKey();
//            List<CleaningSchedule> cleaningSchedules = entry.getValue();
//
//            ////////////////////////////// create ouvrierplanning for this ouvrier
//
//            CleaningSchedule cleaningSchedule = new CleaningSchedule();
//            cleaningSchedule.setOuvrier(ouvrier);
//
//
//        }
//    }
}











