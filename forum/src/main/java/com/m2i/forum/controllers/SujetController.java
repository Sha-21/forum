package com.m2i.forum.controllers;

import com.m2i.forum.dto.SujetDto;
import com.m2i.forum.mappers.SujetMapper;
import com.m2i.forum.models.Sujet;
import com.m2i.forum.services.impl.SujetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sujets")
public class SujetController {

    @Autowired
    SujetServiceImpl sujetService;

    @Autowired
    SujetMapper sujetMapper;

    @GetMapping("")
    public ResponseEntity<List<SujetDto>> findSujets() {
        try {
            List<SujetDto> sujets = sujetService.findAll().stream().map(sujet -> sujetMapper.toDto(sujet)).collect(Collectors.toList());
            return ResponseEntity.ok(sujets);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<SujetDto> findSujet(@PathVariable Long id) {
        try {
            SujetDto sujet = sujetMapper.toDto(sujetService.findById(id));
            return ResponseEntity.ok(sujet);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<SujetDto> create(@RequestBody SujetDto sujetDto) {
        try {
            Sujet sujet = sujetMapper.toEntity(sujetDto);
            sujetService.save(sujet);
            return ResponseEntity.ok(sujetDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("{id}/like")
    public void addLike(@PathVariable Long id){
        Sujet sujet = sujetService.findById(id);
        sujet.setLikes(sujet.getLikes()+1);
        sujetService.update(sujet);
    }

    @PutMapping("{id}/dislike")
    public void dislike(@PathVariable Long id){
        Sujet sujet = sujetService.findById(id);
        sujet.setLikes(sujet.getLikes()-1);
        sujetService.update(sujet);
    }

    @PutMapping("{id}")
    public ResponseEntity<SujetDto> update(@RequestBody SujetDto sujetDto, @PathVariable Long id) {
        try {
            Sujet sujet = sujetService.findById(id);
            sujet.setTitle(sujetDto.getTitle());
            sujet.setFirstMessage(sujetDto.getFirstMessage());
            sujetService.update(sujet);
            return ResponseEntity.ok(sujetDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SujetDto> deleteById(@PathVariable Long id) {
        try {
            sujetService.deleteById(id);
            return ResponseEntity.ok(null);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
