package com.web.elasticsearch.exceptions;

public class DataNotFoundException extends RuntimeException{
	public DataNotFoundException(String msg){
		super(msg);
	}
}
