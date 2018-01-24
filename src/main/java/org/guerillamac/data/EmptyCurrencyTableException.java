package org.guerillamac.data;

public class EmptyCurrencyTableException extends RuntimeException {
	public EmptyCurrencyTableException(String message) {
		super(message);
	}

	public EmptyCurrencyTableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
