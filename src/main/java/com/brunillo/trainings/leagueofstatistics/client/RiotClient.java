package com.brunillo.trainings.leagueofstatistics.client;

import com.brunillo.trainings.leagueofstatistics.client.response.SummonerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RiotClient {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${riot.api.url}")
    private String baseUrl;

    public ResponseEntity<SummonerDTO> findSummoner(String summonerName) {
        String url = baseUrl + "/summoner/v4/summoners/by-name/" + summonerName;
        log.info("Calling Riot API - url: " + url);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", "RGAPI-eada46ba-b1f4-4ef6-8622-ceba408f4a41");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<SummonerDTO> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, SummonerDTO.class);
        return response;
    }

}
