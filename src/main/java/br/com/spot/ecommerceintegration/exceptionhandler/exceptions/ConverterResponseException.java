package br.com.spot.ecommerceintegration.exceptionhandler.exceptions;

public class ConverterResponseException extends RuntimeException {

    private static final long serialVersionUID = 578169005408419146L;

    public ConverterResponseException(Throwable cause) {
        super(cause);
    }

    public ConverterResponseException(String message) {
        super(message);
    }

    public ConverterResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
