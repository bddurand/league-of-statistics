package com.brunillo.trainings.leagueofstatistics.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionData {

    private String id;
    private String name;
    private String title;
    private Info info;
    private List<String> tags;
}

