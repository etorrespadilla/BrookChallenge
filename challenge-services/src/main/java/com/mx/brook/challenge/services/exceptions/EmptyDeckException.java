package com.mx.brook.challenge.services.exceptions;

public class EmptyDeckException extends Exception{
	private static final long serialVersionUID = 1L;

	public EmptyDeckException(String message) {
        super(message);
	}
}
