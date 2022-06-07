package com.brunillo.trainings.leagueofstatistics.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String title;
    @Column
    private String primaryRol;
    @Column
    private String secondaryRol;

}
