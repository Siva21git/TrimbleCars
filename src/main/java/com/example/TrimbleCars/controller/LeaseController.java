package com.example.TrimbleCars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrimbleCars.entities.Lease;
import com.example.TrimbleCars.service.LeaseService;

@RestController
@RequestMapping("/leases")
public class LeaseController {

	@Autowired
	private LeaseService leaseService;

	@PostMapping("/start")
	public ResponseEntity<Lease> startLease(@RequestParam Long carId, @RequestParam Long customerId) {
		Lease lease = leaseService.startLease(carId, customerId);
		return ResponseEntity.status(HttpStatus.CREATED).body(lease);
	}

	@PostMapping("/end")
	public ResponseEntity<Void> endLease(@RequestParam Long leaseId) {
		leaseService.endLease(leaseId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/allleases")
	public ResponseEntity<List<Lease>> getAllLeases() {
	    List<Lease> leases = leaseService.getAllLeases();
	    return ResponseEntity.ok(leases);
	}

}
