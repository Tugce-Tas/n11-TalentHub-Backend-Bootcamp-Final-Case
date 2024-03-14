package com.tugcetasyildiz.restaurants.exceptionhandling.message;

import java.io.Serializable;

public interface BaseErrorMessage  extends Serializable {
    String getMessage();

}