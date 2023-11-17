package com.mario.charactersapi.controller;

import com.mario.charactersapi.model.Enemies;
import com.mario.charactersapi.service.EnemiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enemy")
public class EnemiesController {

    private final EnemiesService enemiesService;

    @PostMapping
    public ResponseEntity<Enemies> addEnemy(@RequestBody EnemiesService.EnemiesRequest request)
    {
        return ResponseEntity.ok(enemiesService.createEnemy(request));
    }

    @GetMapping
    public ResponseEntity<List<Enemies>> getAllEnemies(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String name
    )
    {
        Page<Enemies> results =  enemiesService.getAllEnemiesByNameContains(pageNumber, pageSize, name);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("total-pages", String.valueOf(results.getTotalPages()));
        return new ResponseEntity<>(results.getContent(),responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enemies> getEnemiesById(@PathVariable Long id)
    {
        return new ResponseEntity<Enemies>(enemiesService.getEnemyById(id), HttpStatus.OK);
    }


}
