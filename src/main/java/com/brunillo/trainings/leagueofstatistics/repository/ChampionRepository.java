package com.brunillo.trainings.leagueofstatistics.repository;

import com.brunillo.trainings.leagueofstatistics.entity.Champion;
import org.springframework.data.repository.CrudRepository;

public interface ChampionRepository extends CrudRepository <Champion, Long> {
}
