package iuh.fit.se.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeServiceException(String message) {
		super(message);
	}
}
