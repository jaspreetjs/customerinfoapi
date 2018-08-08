package com.amazonaws.lambda.customers;

public class RequestParams {

	long cin;

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public RequestParams() {
		this.cin = -1;
	}

	public RequestParams(long cin) {
		this.cin = cin;
	}

}
