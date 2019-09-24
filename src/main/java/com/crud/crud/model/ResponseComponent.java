package com.crud.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseComponent<T> {

	
	private String label;
	private int code;
	private T data;
	private String status;
	
	public ResponseComponent(int code,String status,String label)
	{
		this.code = code;
		this.label = label;
		this.status = status;
	}

	public ResponseComponent(int code, String message) {
		this.code = code;
		this.label = message;
		
	}
	
	
	
}
