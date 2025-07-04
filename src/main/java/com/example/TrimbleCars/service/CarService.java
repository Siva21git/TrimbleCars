package com.example.TrimbleCars.service;

import java.util.List;

import com.example.TrimbleCars.entities.Car;

public interface CarService {

	Car registerCar(Car car);

	Car getCarDetails(Long carId);

	List<Car> getAllCars();

}
