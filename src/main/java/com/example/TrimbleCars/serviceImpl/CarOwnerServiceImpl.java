package com.example.TrimbleCars.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrimbleCars.entities.CarOwner;
import com.example.TrimbleCars.repository.CarOwnerRepository;
import com.example.TrimbleCars.service.CarOwnerService;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {

	@Autowired
	private CarOwnerRepository carOwnerRepository;

	@Override
	public CarOwner registerOwner(CarOwner owner) {
		return carOwnerRepository.save(owner);
	}

	@Override
	public List<CarOwner> getAllOwners() {
		return carOwnerRepository.findAll();
	}

	@Override
	public CarOwner getOwnerById(Long id) {
		return carOwnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
	}

}
