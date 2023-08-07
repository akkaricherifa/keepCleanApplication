package com.example.keepcleanproxymapp.service;

import com.example.keepcleanproxymapp.entities.CleaningSchedule;
import com.example.keepcleanproxymapp.entities.Ouvrier;
import com.example.keepcleanproxymapp.repository.AppUserRepository;
import com.example.keepcleanproxymapp.repository.OuvrierRepo;
import com.example.keepcleanproxymapp.repository.PlanningRepository;
import com.example.keepcleanproxymapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.ejb.Schedule;
import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private AppUserRepository appUserRepository;
    private final OuvrierRepo ouvrierRepo;
    private final PlanningRepository planningRepository;


    public List<CleaningSchedule> generateOuvrierPlanning(Date week, long user){
        Map<Ouvrier, List<CleaningSchedule>> CleaningScheduleByOuvrier = assignments.stream()
                .collect(Collectors.groupingBy(CleaningSchedule::getOuvrier));


        //////////////////////////////////// generate ouvrier planing for each ouvrier

        List<CleaningSchedule> cleaningSchedulesList = new ArrayList<>();
        for (Map.Entry<Ouvrier, List<CleaningSchedule>> entry : CleaningScheduleByOuvrier.entrySet()) {
            Ouvrier ouvrier = entry.getKey();
            List<CleaningSchedule> cleaningSchedules = entry.getValue();

            ////////////////////////////// create ouvrierplanning for this ouvrier

            CleaningSchedule cleaningSchedule = new CleaningSchedule();
            cleaningSchedule.setOuvrier(ouvrier);

            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                String shift = "repos";
                for (CleaningSchedule assignment : cleaningSchedules) {
                    if (assignment.getDayOfWeek() == dayOfWeek) {
                        shift = assignment.getShift().toString();
                        break;
                    }
                }
                switch (dayOfWeek) {
                    case MONDAY:
                        .setLUNDI(shift);
                        break;
                    case TUESDAY:
                        cleaningSchedules.setMARDI(shift);
                        break;
                    case WEDNESDAY:
                        cleaningSchedules.setMERCREDI(shift);
                        break;
                    case THURSDAY:
                        cleaningSchedules.setJEUDI(shift);
                        break;
                    case FRIDAY:
                        cleaningSchedules.setVENDREDI(shift);
                        break;
                    case SATURDAY:
                        cleaningSchedules.setSAMEDI(shift);
                        break;
                    case SUNDAY:
                        cleaningSchedules.setDIMANCHE(shift);
                        break;
                    default:
                        break;
                }
            }
        }
    }









}
