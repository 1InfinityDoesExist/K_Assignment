package com.example.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ZomatoResponseEntryExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<?> userNameAlreadyExistExceptionHandler(UserNameAlreadyExistException ex,
			WebRequest webRequest) {
		UserNameAlreadyExistResponse response = new UserNameAlreadyExistResponse(ex.getMessage());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public final ResponseEntity<?> aadharCardAlreadyExixstResponseHandler(AadharCardNumberAlreadyExistException ex,
			WebRequest webRequest) {

		AadharCardNumberAlreadyExistResponse aadharCardAlareadyExistExcepiton = new AadharCardNumberAlreadyExistResponse(
				ex.getMessage());
		return new ResponseEntity(aadharCardAlareadyExistExcepiton, HttpStatus.BAD_REQUEST);

	}
}
