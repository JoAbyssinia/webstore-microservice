package edu.miu.customerservice.error;

public class GenericCustomerError {
    private String message;
    public GenericCustomerError(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
