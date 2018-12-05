package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
//    query signatures here
    List<Whisky> findAllWhiskiesForYear(int year);
    List<Whisky> findAllWhiskiesFrom(String region);
    List<Whisky> findAllWhiskiesFromDistilleryOfAge(Long distilleryId, int age);
}
