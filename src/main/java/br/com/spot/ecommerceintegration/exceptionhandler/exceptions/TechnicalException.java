package br.com.spot.ecommerceintegration.exceptionhandler.exceptions;

public class TechnicalException extends ExchangeException {

    private static final long serialVersionUID = 1L;

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
