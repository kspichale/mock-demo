package com.kspichale.mock_demo;

import java.util.Collection;

public interface VehicleFleet {

	void add(Vehicle vehicle);

	Collection<Vehicle> getAvailableVehicles();

	void setAvailability(Vehicle vehicle, boolean available);

	boolean isAvailable(Vehicle vehicle);

}
