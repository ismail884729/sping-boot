package com.ismail.sports.controller;

import com.ismail.sports.model.Coach;
import com.ismail.sports.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {

    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachService.getAllCoaches();
        return ResponseEntity.ok().body(coaches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable("id") Long id) {
        Optional<Coach> coach = coachService.getCoachById(id);
        return coach.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach savedCoach = coachService.saveCoach(coach);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCoach);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable("id") Long id, @RequestBody Coach coach) {
        Optional<Coach> existingCoachOptional = coachService.getCoachById(id);
        if (existingCoachOptional.isPresent()) {
            Coach existingCoach = existingCoachOptional.get();
            existingCoach.setName(coach.getName());
            existingCoach.setSpecialization(coach.getSpecialization());
            Coach updatedCoach = coachService.saveCoach(existingCoach);
            return ResponseEntity.ok().body(updatedCoach);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable("id") Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.noContent().build();
    }
}
