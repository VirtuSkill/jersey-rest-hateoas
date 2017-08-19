package org.virtuskill.jersey.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.virtuskill.jersey.domain.Address;
import org.virtuskill.jersey.repository.StudentDAO;

@Path("/")
public class AddressService {

	StudentDAO studentDAO = new StudentDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// access this element in path - jerseyWebApp/student/102/address
	public List<Address> getStudentAddress(@PathParam(value = "id") long id) {
		return studentDAO.getStudentAddress(id);
	}

	@GET
	@Path("{addressCity}")
	@Produces(MediaType.TEXT_PLAIN)
	// access this element in path - jerseyWebApp/student/102/address/paris
	public String getStudentAddressByCity(@PathParam(value = "id") long id,
			@PathParam(value = "addressCity") String addressCity) {
		return "Sub Resources example passed Id -" + id + " and City -" + addressCity;
	}
}
