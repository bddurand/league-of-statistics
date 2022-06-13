package com.brunillo.trainings.leagueofstatistics.service;

import com.brunillo.trainings.leagueofstatistics.entity.Champion;
import com.brunillo.trainings.leagueofstatistics.repository.ChampionRepository;
import com.brunillo.trainings.leagueofstatistics.request.ChampionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChampionService {

    @Autowired
    ChampionRepository repository;

    public void createChampion(ChampionRequest champ){

        //repository.save(new Champion(champ.getName(), champ.getPrima()));
    }

    public List<Champion> findAll() {
        return (List<Champion>) repository.findAll();
    }

    public List<Champion> findByName(String name) {
        List<Champion> champions = (List<Champion>) repository.findAll();
        return champions.stream()
                .filter(champion -> champion.getName().toUpperCase().contains(name))
                .collect(Collectors.toList());
    }
}
