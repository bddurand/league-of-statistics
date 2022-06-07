package com.brunillo.trainings.leagueofstatistics.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampDataWrapper {

    private String type;
    private String format;
    private String version;
    private Map<String, ChampionData> data;
}
