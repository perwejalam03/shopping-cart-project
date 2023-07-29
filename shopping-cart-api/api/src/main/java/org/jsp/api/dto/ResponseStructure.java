package org.jsp.api.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private String message;
	private int statusCode;
}
