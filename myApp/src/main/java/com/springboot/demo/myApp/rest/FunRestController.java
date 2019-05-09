package com.springboot.demo.myApp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FunRestController
 */
@RestController
public class FunRestController {

    //inject properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + " from " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hi the time is" + LocalDateTime.now();
    }

    //expose new edn point for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "push ups";
    }
    //test end point
    @GetMapping("/dota")
    public String getDota(){
        return "2 ez";
    }
}