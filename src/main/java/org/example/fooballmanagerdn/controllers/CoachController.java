package org.example.fooballmanagerdn.controllers;

import org.example.fooballmanagerdn.models.Coach;
import org.example.fooballmanagerdn.services.iml.CoachService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("")
    public ResponseEntity<Iterable<Coach>> list() {
        Iterable<Coach> coaches = coachService.findAllCoach();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> findById(@PathVariable("id") Long id) {
        Coach coach = coachService.findById(id);
        if (coach == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Coach> delete(@PathVariable("id") Long id) {
        Coach coach = coachService.findById(id);
        if (coach == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coachService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> edit(@PathVariable("id") Long id, @RequestBody Coach coach) {
        Coach coach1 = coachService.findById(id);
        if (coach1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coach.setId(coach1.getId());
        System.out.println(coach);
        coachService.save(coach);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Validated @RequestBody Coach coach, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        }
        coachService.save(coach);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Coach>> search(@RequestParam String search) {
        Iterable<Coach> coaches = coachService.findAllByNameContaining(search);
        if (coaches == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

}
