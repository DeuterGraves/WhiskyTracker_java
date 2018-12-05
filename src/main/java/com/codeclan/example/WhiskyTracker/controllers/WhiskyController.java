package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/year/{year}")
        public List<Whisky> findAllWhiskiesForYear(@PathVariable int year){
        return whiskyRepository.findAllWhiskiesForYear(year);
    }

    @GetMapping(value = "/region/{region}")
        public List<Whisky> findAllWhiskiesFrom(@PathVariable String region){
        return whiskyRepository.findAllWhiskiesFrom(region);
    }

    @GetMapping(value = "/distillery/{id}/age/{age}")
    public List<Whisky> findAllWhiskiesFromDistilleryOfAge(@PathVariable Long distilleryId, @PathVariable int age){
        return whiskyRepository.findAllWhiskiesFromDistilleryOfAge(distilleryId, age);
    }

}
