package de.hfu.informatik.meldeauskunft;

import static org.junit.Assert.*;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.eq;

import de.hfu.Buchstaben.Queue;
import de.hfu.informatik.meldeauskunft.domain.Resident;
import de.hfu.informatik.meldeauskunft.repository.*;
import de.hfu.informatik.meldeauskunft.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

public class Meldeauskunft_Test {

	String pattern = "MM/dd/yyyy";
    SimpleDateFormat format = new SimpleDateFormat(pattern);
	@Test
	public void filteredRepositoryTest1() throws ParseException {
		
		Resident resident1 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident2 = new Resident("Holger", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident3 = new Resident("Holle", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident4 = new Resident("Ho*", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		
		ResidentRepository Stub = new ResidentRepositoryStub();
		
		List<Resident> residentrepositoryStub = new ArrayList<Resident>();
		residentrepositoryStub = Stub.getResidents();
		
		Stub.newResident(resident1);
		Stub.newResident(resident2);
		Stub.newResident(resident3);
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(Stub);

		List<Resident> residentrepository = new ArrayList<Resident>();
		residentrepository = service.getFilteredResidentsList(resident4);
		
		assertEquals(residentrepository,residentrepositoryStub);
		
	}
	
	@Test
	public void filteredRepositoryTest2() throws ParseException {
		
		Resident resident1 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident2 = new Resident("Holger", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident3 = new Resident("Holle", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident4 = new Resident("Ho*",null,null,null,null);
		
		ResidentRepository Stub = new ResidentRepositoryStub();
		
		List<Resident> residentrepositoryStub = new ArrayList<Resident>();
		residentrepositoryStub = Stub.getResidents();
		
		Stub.newResident(resident1);
		Stub.newResident(resident2);
		Stub.newResident(resident3);
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(Stub);

		List<Resident> residentrepository = new ArrayList<Resident>();
		residentrepository = service.getFilteredResidentsList(resident4);
		
		assertEquals(residentrepository,residentrepositoryStub);
		
	}
	
	@Test
	public void filteredRepositoryTest3() throws ParseException {
		
		Resident resident1 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident2 = new Resident("Holger", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident3 = new Resident("Holle", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident4 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		
		ResidentRepository Stub = new ResidentRepositoryStub();
		
		List<Resident> residentrepositoryStub = new ArrayList<Resident>();
		residentrepositoryStub.add(resident1);
		
		Stub.newResident(resident1);
		Stub.newResident(resident2);
		Stub.newResident(resident3);
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(Stub);

		List<Resident> residentrepository = new ArrayList<Resident>();
		residentrepository = service.getFilteredResidentsList(resident4);
		
		assertEquals(residentrepository,residentrepositoryStub);
		
	}
	
	@Test
	public void filteredRepositoryTestMock() throws ParseException, ResidentServiceException {
		
		Resident resident1 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident2 = new Resident("Holger", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident3 = new Resident("Holle", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident4 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		
		ResidentRepository ResidentRepositoryMock = createMock(ResidentRepository.class);
		ResidentRepositoryMock.newResident(resident1);
		ResidentRepositoryMock.newResident(resident2);
		ResidentRepositoryMock.newResident(resident3);
		
		List<Resident> residentrepository = new ArrayList<Resident>();
		residentrepository.add(resident1);
		residentrepository.add(resident2);
		residentrepository.add(resident3);
		
		EasyMock.expect(ResidentRepositoryMock.getResidents()).andReturn(residentrepository);
	}
	
	@Test
	public void getUniqueResidentTest1() throws ParseException, ResidentServiceException {
		
		Resident resident1 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident2 = new Resident("Holger", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident3 = new Resident("Holle", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident4 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		
		ResidentRepository Stub = new ResidentRepositoryStub();
		
		List<Resident> residentrepositoryStub = new ArrayList<Resident>();
		residentrepositoryStub.add(resident1);
		
		Stub.newResident(resident1);
		Stub.newResident(resident2);
		Stub.newResident(resident3);
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(Stub);

		Resident testResident = new Resident();
		testResident = service.getUniqueResident(resident4);
		
		assertEquals(testResident,resident1);
		
	}
	
	@Test(expected=ResidentServiceException.class, timeout = 1000)
	public void getUniqueResidentTest2() throws ResidentServiceException, ParseException {
		
		Resident resident1 = new Resident("Horst", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident2 = new Resident("Holger", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident3 = new Resident("Holle", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		Resident resident4 = new Resident("Ho*", "Adler", "Schlossstrasse", "Berlin", format.parse("02/11/2012"));
		
		ResidentRepository Stub = new ResidentRepositoryStub();
		
		List<Resident> residentrepositoryStub = new ArrayList<Resident>();
		residentrepositoryStub.add(resident1);
		
		Stub.newResident(resident1);
		Stub.newResident(resident2);
		Stub.newResident(resident3);
		
		BaseResidentService service = new BaseResidentService();
		
		service.setResidentRepository(Stub);

		Resident testResident = new Resident();
		testResident = service.getUniqueResident(resident4);
	}

}
