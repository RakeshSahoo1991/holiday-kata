package com.tm.holidaykata.model;

import java.util.List;

/**
 * @author srake
 *
 */
public class PublicHolidayDto {

	private String localName;
	private String date;
	private String name;
	private String countryCode;
	private Boolean fixed;
	private Boolean global;
	private List<String> countries;
	private Integer lunchYear;
	private PublicHolidayType type;
	
	
	
	public Integer getLunchYear() {
		return lunchYear;
	}
	public void setLunchYear(Integer lunchYear) {
		this.lunchYear = lunchYear;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Boolean getFixed() {
		return fixed;
	}
	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
	}
	public Boolean getGlobal() {
		return global;
	}
	public void setGlobal(Boolean global) {
		this.global = global;
	}
	public List<String> getCountries() {
		return countries;
	}
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	public PublicHolidayType getType() {
		return type;
	}
	public void setType(PublicHolidayType type) {
		this.type = type;
	}
	
	
	
}
