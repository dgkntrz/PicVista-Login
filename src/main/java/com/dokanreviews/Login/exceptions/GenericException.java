package com.dokanreviews.Login.exceptions;

public class GenericException extends Exception{

    private int errorCode;
    private String errorMessage;

    public GenericException(Throwable throwable) {
        super(throwable);
    }

    public GenericException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public GenericException(String msg) {
        super(msg);
    }

    public GenericException(String message, int errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }


    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return this.errorCode + " : " + this.getErrorMessage();
    }
}
