package com.brunillo.trainings.leagueofstatistics.service;

import com.brunillo.trainings.leagueofstatistics.client.RiotClient;
import com.brunillo.trainings.leagueofstatistics.client.response.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {

    @Autowired
    private RiotClient riotClient;

    public ResponseEntity<SummonerDTO> getSummonerInfo(String name){
        return riotClient.findSummoner(name);
    }
}
