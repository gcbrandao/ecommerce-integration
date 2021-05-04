package br.com.spot.ecommerceintegration.exceptionhandler.exceptions;

public class ExchangeException extends Exception {

    private static final long serialVersionUID = 578169005408419146L;

    public ExchangeException(Throwable cause) {
        super(cause);
    }

    public ExchangeException(String message) {
        super(message);
    }

    public ExchangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
