package com.kspichale.mock_demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kspichale.mock_demo.repository.VehicleRepository;

@Service
public class PersistentVehicleFleet implements VehicleFleet {

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public void add(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	@Override
	public Collection<Vehicle> getAvailableVehicles() {
		return vehicleRepository.findByAvailable(true);
	}

	@Override
	public void setAvailability(Vehicle vehicle, boolean available) {
		vehicle.setAvailable(available);
		vehicleRepository.save(vehicle);
	}

	@Override
	public boolean isAvailable(Vehicle vehicle) {
		return vehicle.isAvailable();
	}
}
