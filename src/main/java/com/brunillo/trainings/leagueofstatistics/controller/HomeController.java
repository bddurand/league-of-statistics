package com.brunillo.trainings.leagueofstatistics.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/")
    public Map getStatus() {
        Map map = new HashMap();
        map.put("app_version", appVersion);

        return map;
    }
}
