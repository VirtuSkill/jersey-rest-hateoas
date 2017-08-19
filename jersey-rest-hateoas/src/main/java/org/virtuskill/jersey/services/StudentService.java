package org.virtuskill.jersey.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.virtuskill.jersey.domain.Student;
import org.virtuskill.jersey.repository.StudentDAO;

@Path("/student")
public class StudentService {

	StudentDAO studentDAO = new StudentDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentDetails() {
		GenericEntity<List<Student>> entityBuilder = new GenericEntity<List<Student>>(
				studentDAO.getAllStudentDetails()) {
		};
		return Response.ok(entityBuilder).build();
	}

	//Simple Sub Resource example for demonstrate HATEOAS resolveTemplate concept
	@Path("/{id}/address")
	// Sub Resource, calling another class for servicing in pathParam
	public AddressService getAddressService() {
		return new AddressService();
	}

	//HATEOS EXAMPLE
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam(value = "id") long id, @Context UriInfo uriInfo) {
		Student studentObj = studentDAO.getStudent(id);
		// HATEOAS _SELF
		String _selfLink = _selfUrlBuilder(uriInfo, studentObj);
		studentObj.addLink(_selfLink, "_self");

		// HATEOAS _SCHOOL
		String _schoolLink = _schoolUrlBuilder(uriInfo, studentObj);
		studentObj.addLink(_schoolLink, "_school");

		// HATEOS _ADDRESS
		String _addressLink = _addressUrlBuilder(uriInfo, studentObj);
		studentObj.addLink(_addressLink, "_address");
		return studentObj;
	}

	public String _selfUrlBuilder(UriInfo uriInfo, Student studentObj) {
		return uriInfo.getBaseUriBuilder().path(StudentService.class).path(String.valueOf(studentObj.getId())).build()
				.toString();
	}

	public String _schoolUrlBuilder(UriInfo uriInfo, Student studentObj) {
		return uriInfo.getBaseUriBuilder().path(SchoolService.class).path(String.valueOf(studentObj.getSchool()))
				.build().toString();
	}

	public String _addressUrlBuilder(UriInfo uriInfo, Student studentObj) {
		return uriInfo.getBaseUriBuilder()
				.path(StudentService.class)
				.path(StudentService.class, "getAddressService")
				.path(AddressService.class)
				.resolveTemplate("id", studentObj.getId())
				.build().toString();
	}
}
