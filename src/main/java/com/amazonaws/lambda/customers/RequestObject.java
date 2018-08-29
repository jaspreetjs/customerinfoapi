package com.amazonaws.lambda.customers;

public class RequestObject {
	
	long cin;

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public RequestObject() {
		this.cin = -1;
	}

	public RequestObject(long cin) {
		this.cin = cin;
	}
	
}
