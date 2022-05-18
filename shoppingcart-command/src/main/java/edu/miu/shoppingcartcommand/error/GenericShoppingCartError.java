package edu.miu.shoppingcartcommand.error;

public class GenericShoppingCartError extends Exception {
    private String message;
    public GenericShoppingCartError(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
