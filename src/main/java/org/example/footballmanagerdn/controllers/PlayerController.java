package org.example.footballmanagerdn.controllers;

import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.DTO.PlayerUserDto;
import org.example.footballmanagerdn.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @RequestMapping("")
    public ResponseEntity<Page<PlayerDto>> index(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String sort,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double salaryMin,
            @RequestParam(required = false) Double salaryMax,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String status
    ) {
        Page<PlayerDto> documents = playerService.findAll(page, size, sort, name, salaryMin, salaryMax, position, status);
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(
            @Validated @RequestBody PlayerUserDto playerUserDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        playerService.createPlayer(playerUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
