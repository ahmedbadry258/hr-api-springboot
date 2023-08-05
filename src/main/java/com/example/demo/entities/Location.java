package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LOCATIONS")
public class Location implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@Column(name = "LOCATION_ID")
	private Long locationId;
	
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE_PROVINCE")
	private String stateProvince;
	
//	@Column(name = "COUNTRY_ID")
//	private String countryId;
	
	@ManyToOne()
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;


public Location() {
	super();
}

public Long getLocationId() {
	return locationId;
}

public void setLocationId(Long locationId) {
	this.locationId = locationId;
}

public String getStreetAddress() {
	return streetAddress;
}

public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
}

public String getPostalCode() {
	return postalCode;
}

public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getStateProvince() {
	return stateProvince;
}

public void setStateProvince(String stateProvince) {
	this.stateProvince = stateProvince;
}

public Country getCountry() {
	return country;
}

public void setCountry(Country country) {
	this.country = country;
}
	

}
