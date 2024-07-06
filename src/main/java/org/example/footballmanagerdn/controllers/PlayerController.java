package org.example.footballmanagerdn.controllers;

import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.DTO.PlayerFormCreateDto;
import org.example.footballmanagerdn.models.DTO.PlayerFormUpdateDto;
import org.example.footballmanagerdn.models.Player;
import org.example.footballmanagerdn.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


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
            @RequestParam(required = false) Long positionId,
            @RequestParam(required = false) String status
    ) {
        Page<PlayerDto> documents = playerService.findAll(page, size, sort, name, salaryMin, salaryMax, positionId, status);
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(
            @Validated @ModelAttribute PlayerFormCreateDto playerFormCreateDto
    ) {
        playerService.createPlayer(playerFormCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Validated @ModelAttribute PlayerFormUpdateDto playerFormUpdateDto,
            @PathVariable("id") Long id
    ) {
        playerService.updatePlayer(id, playerFormUpdateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
