package org.example.footballmanagerdn.controllers;

import org.example.footballmanagerdn.models.Position;
import org.example.footballmanagerdn.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/positions")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @RequestMapping("")
    public ResponseEntity<Iterable<Position>> list() {
        Iterable<Position> positions = positionService.findAllPosition();
        return new ResponseEntity<>(positions, org.springframework.http.HttpStatus.OK);
    }
}
