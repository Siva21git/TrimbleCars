package com.example.TrimbleCars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.entities.CarOwner;
import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.entities.Lease;
import com.example.TrimbleCars.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // === Car Owner Operations ===

    @PostMapping("/car-owners")
    public ResponseEntity<CarOwner> registerCarOwner(@RequestBody CarOwner carOwner) {
        return ResponseEntity.ok(adminService.registerOwner(carOwner));
    }

    @GetMapping("/car-owners")
    public ResponseEntity<List<CarOwner>> getAllCarOwners() {
        return ResponseEntity.ok(adminService.getAllOwners());
    }

    // === Customer Operations ===

    @PostMapping("/customers")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(adminService.registerCustomer(customer));
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllAvailableCars() {
        return ResponseEntity.ok(adminService.getAllAvailableCars());
    }

    @PostMapping("/leases/start")
    public ResponseEntity<Lease> startLease(@RequestParam Long customerId, @RequestParam Long carId) {
        return ResponseEntity.ok(adminService.startLeaseAsAdmin(customerId, carId));
    }

    @PostMapping("/leases/end")
    public ResponseEntity<Lease> endLease(@RequestParam Long leaseId) {
        return ResponseEntity.ok(adminService.endLeaseAsAdmin(leaseId));
    }

    @GetMapping("/leases")
    public ResponseEntity<List<Lease>> getAllLeases() {
        return ResponseEntity.ok(adminService.getAllLeases());
    }

}
