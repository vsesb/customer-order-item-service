package com.ness.microservice.order.exception;

import java.util.Date;

public class ExceptionResponse {
	private String error;
	private Date date;
	private String details;
	public ExceptionResponse() {
		
	}
	public ExceptionResponse(String error, Date date, String details) {
		super();
		this.error = error;
		this.date = date;
		this.details = details;
	}
	public String getError() {
		return error;
	}
	public Date getDate() {
		return date;
	}
	public String getDetails() {
		return details;
	}

	
}
