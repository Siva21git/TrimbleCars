package com.example.TrimbleCars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TrimbleCars.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findByStatus(String string);

}
