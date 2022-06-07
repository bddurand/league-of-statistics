package com.brunillo.trainings.leagueofstatistics.graphql.resolver;

import com.brunillo.trainings.leagueofstatistics.entity.Champion;
import com.brunillo.trainings.leagueofstatistics.repository.ChampionRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private ChampionRepository repository;

    public Query(ChampionRepository repository) {
        this.repository = repository;
    }

    public Iterable<Champion> findAllChampions() {
        return repository.findAll();
    }

    public long countChampions() {
        return repository.count();
    }
}
