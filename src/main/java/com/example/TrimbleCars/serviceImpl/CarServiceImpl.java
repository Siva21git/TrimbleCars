package com.example.TrimbleCars.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrimbleCars.Exception.CarNotFoundException;
import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.repository.CarRepository;
import com.example.TrimbleCars.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public Car registerCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Car getCarDetails(Long carId) {
		return carRepository.findById(carId).orElseThrow(() -> new CarNotFoundException("Car not found"));
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

}
