package br.com.spot.ecommerceintegration.exceptionhandler.exceptions;

public class BusinessException extends ExchangeException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }
}
