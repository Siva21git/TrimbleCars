package com.example.TrimbleCars.service;

import java.util.List;

import com.example.TrimbleCars.entities.CarOwner;

public interface CarOwnerService {

	CarOwner registerOwner(CarOwner owner);

	List<CarOwner> getAllOwners();

	CarOwner getOwnerById(Long id);

}
