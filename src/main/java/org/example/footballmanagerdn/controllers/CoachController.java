package org.example.footballmanagerdn.controllers;

import org.example.footballmanagerdn.models.Coach;
import org.example.footballmanagerdn.models.DTO.CoachDTO;
import org.example.footballmanagerdn.models.DTO.CoachWithUserDTO;
import org.example.footballmanagerdn.models.Salary;
import org.example.footballmanagerdn.services.iml.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("")
    public ResponseEntity<Page<Coach>> list(Pageable pageable) {
        Page<Coach> coaches = coachService.findAllCoach(pageable);
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @GetMapping("/list")
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
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Validated @RequestBody Coach coach, @PathVariable("id") Long id, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        Coach coach1 = coachService.findById(id);
        if (coach1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        coach.setId(coach1.getId());
        coach.setUser(coach1.getUser());
        coachService.save(coach);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<CoachDTO>> search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String homeTown
    ) {
        Page<CoachDTO> coaches = coachService.findAll(page, size, name, homeTown);
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @PostMapping("/money/{id}")
    public ResponseEntity<?> pay(
            @Validated @RequestBody Salary salary,
            @PathVariable("id") Long coachID
    ) {
        coachService.createSalary(coachID, salary);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/devide")
    public ResponseEntity<Page<Coach>> listBooks(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Coach> coaches = coachService.findAllCoach(pageable);
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

}
