package com.brunillo.trainings.leagueofstatistics.graphql.mutator;

import com.brunillo.trainings.leagueofstatistics.entity.Champion;
import com.brunillo.trainings.leagueofstatistics.graphql.exception.ChampionNotFoundException;
import com.brunillo.trainings.leagueofstatistics.repository.ChampionRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private ChampionRepository repository;

    public Mutation(ChampionRepository repository) {
        this.repository = repository;
    }

    public Champion newChampion(String name, String title,
                                      String primaryRol, String secondaryRol) {
        Champion c = new Champion();
        c.setName(name);
        c.setTitle(title);
        c.setPrimaryRol(primaryRol);
        c.setSecondaryRol(secondaryRol);
        repository.save(c);
        return c;
    }

    public Boolean deleteChampion(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Champion updateChampionName(String newName, Long id) {
        Optional<Champion> optionalApplication = repository.findById(id);

        if(optionalApplication.isPresent()) {
            Champion champion = optionalApplication.get();
            champion.setName(newName);
            repository.save(champion);
            return champion;
        } else {
            throw new ChampionNotFoundException("Application Not Found", id);
        }
    }
}
