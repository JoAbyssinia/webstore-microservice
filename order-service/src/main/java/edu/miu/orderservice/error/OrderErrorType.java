package edu.miu.orderservice.error;

public class OrderErrorType extends Exception{
    private String message;
    public OrderErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
