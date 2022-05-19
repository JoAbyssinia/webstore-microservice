package edu.miu.stockservice.error;

public class StockErrorHandler<T> {
    private boolean message;
    private T t;


    public StockErrorHandler(boolean message) {
        this.message = message;
    }

    public StockErrorHandler(boolean message, T t) {
        this.message = message;
        this.t = t;
    }


    public boolean getsuccess() {
        return message;
    }

    public T getData() {
        return t;
    }

}
