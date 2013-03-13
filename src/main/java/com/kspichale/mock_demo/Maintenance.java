package com.kspichale.mock_demo;

public class Maintenance {

	private final Vehicle vehicle;
	private boolean scheduled = false;

	public Maintenance(final Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public boolean schedule(final VehicleFleet fleet) {
		if (fleet.isAvailable(vehicle)) {
			fleet.setAvailability(vehicle, false);
			scheduled = true;
			return true;
		}
		return false;
	}
}
