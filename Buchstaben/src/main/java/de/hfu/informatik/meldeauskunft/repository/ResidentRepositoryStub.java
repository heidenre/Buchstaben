package de.hfu.informatik.meldeauskunft.repository;

import java.util.ArrayList;
import java.util.List;

import de.hfu.informatik.meldeauskunft.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository{

	private List<Resident> resident = new ArrayList<Resident>();
	
	public void newResident(Resident resident) {
		this.resident.add(resident);
	}
	
	public List<Resident> getResidents() {
		return resident;
	}
	
}
