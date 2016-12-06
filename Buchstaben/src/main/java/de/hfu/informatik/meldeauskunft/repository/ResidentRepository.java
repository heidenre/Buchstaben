package de.hfu.informatik.meldeauskunft.repository;

import java.util.List;

import de.hfu.informatik.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();
  void newResident(Resident resident);

}