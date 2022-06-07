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
@RequestMapping("/champion")
@Slf4j
public class ChampionController {

    @Autowired
    ChampionService service;

    @PostMapping(path = "/new")
    public ResponseEntity create(@RequestBody ChampionRequest championRequest) {
        log.info("New champ");
        service.createChampion(championRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Champion>> getAll(){
        log.info("Get all champs");
        List<Champion> list = service.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
