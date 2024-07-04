package org.example.fooballmanagerdn.controllers;

import org.example.fooballmanagerdn.models.Coach;
import org.example.fooballmanagerdn.services.iml.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("")
    public ResponseEntity<Iterable<Coach>> list() {
        System.out.println("cc");
        Iterable<Coach> coaches = coachService.findAllCoach();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }
}
