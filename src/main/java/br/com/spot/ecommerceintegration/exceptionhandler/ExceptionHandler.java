package br.com.spot.ecommerceintegration.exceptionhandler;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ex.getBindingResult().getFieldErrors().get(0).getField();
		ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

		String errorMessage = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage()).findFirst()
				.orElse(Strings.EMPTY);

		return response(ex, request, headers, HttpStatus.BAD_REQUEST, errorMessage);
	}

	private ResponseEntity<Object> response(Exception ex, WebRequest request, HttpHeaders headers, HttpStatus status,
			String message) {
		return handleExceptionInternal(ex, message, headers, status, request);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(IOException.class)
	@ResponseBody
	ApiError handleBadRequest(HttpServletRequest req, Exception ex) {
		return new ApiError(ex.getMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(IllegalAccessException.class)
	@ResponseBody
	ApiError handleAcessError(HttpServletRequest req, Exception ex) {
		return new ApiError(ex.getMessage());
	}
}
