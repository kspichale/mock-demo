package com.kspichale.mock_demo;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Vehicle extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1579677179893541654L;

	@Column
	private boolean available = true;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
