package com.kspichale.mock_demo;

public class Maintenance {

	private final Vehicle vehicle;

	public Maintenance(final Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public boolean schedule(final VehicleFleet fleet) {
		if (fleet.isAvailable(vehicle)) {
			fleet.setAvailability(vehicle, false);
			return true;
		}
		return false;
	}
}
