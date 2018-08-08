package com.amazonaws.lambda.customers;

public class ResponseObject {

	long cin;
	String name;
	String customerType;
	String address;
	String residenceCountry;
	String incorporationCountry;
	String industryClassification;
	String queryStatus;

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public String getIncorporationCountry() {
		return incorporationCountry;
	}

	public void setIncorporationCountry(String incorporationCountry) {
		this.incorporationCountry = incorporationCountry;
	}

	public String getIndustryClassification() {
		return industryClassification;
	}

	public void setIndustryClassification(String industryClassification) {
		this.industryClassification = industryClassification;
	}

	public String getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}

	public ResponseObject() {
		this.cin = -1;
		this.name = null;
		this.customerType = null;
		this.address = null;
		this.residenceCountry = null;
		this.incorporationCountry = null;
		this.industryClassification = null;
		this.queryStatus = null;
	}

	public ResponseObject(long cin, String name, String customerType, String address, String residenceCountry,
			String incorporationCountry, String industryClassification, String queryStatus) {
		this.cin = cin;
		this.name = name;
		this.customerType = customerType;
		this.address = address;
		this.residenceCountry = residenceCountry;
		this.incorporationCountry = incorporationCountry;
		this.industryClassification = industryClassification;
		this.queryStatus = queryStatus;
	}

}
