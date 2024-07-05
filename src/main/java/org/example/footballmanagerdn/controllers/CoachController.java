package org.example.footballmanagerdn.controllers;

import org.example.footballmanagerdn.models.Coach;
import org.example.footballmanagerdn.models.DTO.CoachWithUserDTO;
import org.example.footballmanagerdn.services.iml.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
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
    public ResponseEntity<?> edit(@Validated @RequestBody Coach coach, @PathVariable("id") Long id ,BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        Coach coach1 = coachService.findById(id);
        if (coach1==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        coach.setId(coach1.getId());
        coachService.save(coach);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Validated @RequestBody CoachWithUserDTO coachWithUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        coachService.createCoach(coachWithUserDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping("/search")
//    public ResponseEntity<Page<CoachWithUserDTO>> search(
//            @RequestParam String search,
//            @RequestParam String
//    ) {
//        Iterable<Coach> coaches = coachService.findAllByNameContaining(search);
//        if (coaches == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(coaches, HttpStatus.OK);
//    }

}
