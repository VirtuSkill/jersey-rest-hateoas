package org.virtuskill.jersey.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {

	private long id;
	private String doorNo;
	private String streetName;
	private String city;
	private String zipCode;

	public Address() {

	}

	public Address(long id, String doorNo, String streetName, String city, String zipCode) {
		super();
		this.id = id;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
