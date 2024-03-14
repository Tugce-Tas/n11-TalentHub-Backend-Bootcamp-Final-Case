package com.tugcetasyildiz.restaurants.exceptionhandling.message;

public enum EnumErrorMessage implements BaseErrorMessage {
    INVALID_RESTAURANT_ID("Invalid restaurant Id!"),
    ITEM_NOT_FOUND("Item is not found!");

    private final String message;
    EnumErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}