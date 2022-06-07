package com.brunillo.trainings.leagueofstatistics.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    private Integer attack;
    private Integer defense;
    private Integer magic;
    private Integer difficulty;

}
