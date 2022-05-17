package com.m2i.forum.controllers;

import com.m2i.forum.dto.SectionDto;
import com.m2i.forum.mappers.SectionMapper;
import com.m2i.forum.models.Section;
import com.m2i.forum.services.impl.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sections")
public class SectionController {

    @Autowired
    SectionServiceImpl sectionService;

    @Autowired
    SectionMapper sectionMapper;

    @GetMapping("")
    public ResponseEntity<List<SectionDto>> findSections() {
        try {
            List<SectionDto> sections = sectionService.findAll().stream().map(section -> sectionMapper.toDto(section)).collect(Collectors.toList());
            return ResponseEntity.ok(sections);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<SectionDto> findSection(@PathVariable Long id) {
        try {
            SectionDto sectionDto = sectionMapper.toDto(sectionService.findById(id));
            return ResponseEntity.ok(sectionDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<SectionDto> create(@RequestBody SectionDto sectionDto) {
        try {
            Section section = sectionMapper.toEntity(sectionDto);
            sectionService.save(section);
            return ResponseEntity.ok(sectionDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<SectionDto> update(@RequestBody SectionDto sectionDto, @PathVariable Long id) {
        try {
            Section section = sectionService.findById(id);
            section.setTitle(sectionDto.getTitle());
            section.setDetail(sectionDto.getDetail());
            sectionService.update(section);
            return ResponseEntity.ok(sectionDto);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SectionDto> deleteById(@PathVariable Long id) {
        try {
            sectionService.deleteById(id);
            return ResponseEntity.ok(null);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
