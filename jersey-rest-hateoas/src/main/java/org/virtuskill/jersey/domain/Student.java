package org.virtuskill.jersey.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Student {

	private long id;
	private String name;
	private Date admissionDate;
	private String section;
	private String school;
	private List<HateoasVO> links = new ArrayList<HateoasVO>();
	private List<Address> address;

	public Student() {
		this.admissionDate = new Date();
	}

	public Student(long id, String name, String section, String school, List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.admissionDate = new Date();
		this.section = section;
		this.school = school;
		this.address = address;
	}

	@XmlTransient
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<HateoasVO> getLinks() {
		return links;
	}

	public void setLinks(List<HateoasVO> links) {
		this.links = links;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public List addLink(String link, String rel) {
		HateoasVO hateoasVO = new HateoasVO();
		hateoasVO.setLink(link);
		hateoasVO.setRel(rel);
		links.add(hateoasVO);
		return links;
	}
}
