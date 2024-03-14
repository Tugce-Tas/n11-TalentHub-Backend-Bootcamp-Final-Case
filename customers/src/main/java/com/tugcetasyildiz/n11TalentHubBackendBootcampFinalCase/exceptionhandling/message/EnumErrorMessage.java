package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message;

public enum EnumErrorMessage implements BaseErrorMessage {
    INVALID_CUSTOMER_ID("Invalid customer Id!"),
    INVALID_RESTAURANT_ID("Invalid restaurant Id!"),
    INVALID_COMMENT_ID("Invalid comment Id!"),
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