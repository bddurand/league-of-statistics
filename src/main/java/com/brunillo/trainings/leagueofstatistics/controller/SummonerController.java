package com.brunillo.trainings.leagueofstatistics.controller;

import com.brunillo.trainings.leagueofstatistics.client.response.SummonerDTO;
import com.brunillo.trainings.leagueofstatistics.service.SummonerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/summoner")
@Slf4j
public class SummonerController {
    @Autowired
    private SummonerService service;

    @GetMapping("/{name}/info")
    public ResponseEntity<SummonerDTO> getSummonerInfo(@PathVariable String name){
        log.info("Requesting summoner info for: " + name);
        return service.getSummonerInfo(name);
    }

}
