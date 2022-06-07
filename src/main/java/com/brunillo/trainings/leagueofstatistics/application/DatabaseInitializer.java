package com.brunillo.trainings.leagueofstatistics.application;

import com.brunillo.trainings.leagueofstatistics.application.model.ChampDataWrapper;
import com.brunillo.trainings.leagueofstatistics.entity.Champion;
import com.brunillo.trainings.leagueofstatistics.repository.ChampionRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatabaseInitializer {

    @Autowired
    private ChampionRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        System.out.println("Do something");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        try {
            ChampDataWrapper champData = mapper.readValue(Paths.get("files/Champions.json").toFile(), ChampDataWrapper.class);
            List<Champion> champions = champData
                    .getData()
                    .values()
                    .stream()
                    .map(
                            data -> {
                                System.out.println("Getting info of: " + data.toString());
                                Champion c = new Champion();
                                c.setName(data.getName());
                                c.setTitle(data.getTitle());

                                c.setPrimaryRol(getRoleByIndexIfPresent(data.getTags(), 0));
                                c.setSecondaryRol(getRoleByIndexIfPresent(data.getTags(), 1));
                                return c;
                            }
                    )
                    .collect(Collectors.toList());

            
            champions.forEach( c-> repository.save(c));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRoleByIndexIfPresent(List<String> tags, Integer index) {
        try {
            return tags.get(index);
        } catch (IndexOutOfBoundsException e) {
            return ""; //TODO: mejorar esto
        }
    }
}
