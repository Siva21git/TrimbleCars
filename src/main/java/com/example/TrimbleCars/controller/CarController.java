package com.example.TrimbleCars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping("/register")
	public ResponseEntity<Car> registerCar(@RequestBody Car car) {
		Car savedCar = carService.registerCar(car);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getCarDetails(@PathVariable Long id) {
		Car car = carService.getCarDetails(id);
		return ResponseEntity.ok(car);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> cars = carService.getAllCars();
		return ResponseEntity.ok(cars);
	}
}
