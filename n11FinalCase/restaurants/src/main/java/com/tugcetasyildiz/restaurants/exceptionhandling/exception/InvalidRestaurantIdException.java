package com.tugcetasyildiz.restaurants.exceptionhandling.exception;

import com.tugcetasyildiz.restaurants.exceptionhandling.message.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidRestaurantIdException extends BusinessException {
    public InvalidRestaurantIdException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}

