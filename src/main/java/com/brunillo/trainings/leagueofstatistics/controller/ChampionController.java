package com.brunillo.trainings.leagueofstatistics.controller;

import com.brunillo.trainings.leagueofstatistics.entity.Champion;
import com.brunillo.trainings.leagueofstatistics.request.ChampionRequest;
import com.brunillo.trainings.leagueofstatistics.service.ChampionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/champion")
@Slf4j
public class ChampionController {

    @Autowired
    ChampionService service;

    @PostMapping(path = "/new")
    public ResponseEntity create(@RequestBody ChampionRequest championRequest) {
        log.info("Create new champion with data: " + championRequest.toString());
        service.createChampion(championRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Champion>> getAll(){
        log.info("Get all champions");
        List<Champion> list = service.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Champion>> findByName(@PathVariable String name){
        log.info("Find champions by name" + name);
        List<Champion> list = service.findByName(name.toUpperCase());
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
