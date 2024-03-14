package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidCommentIdException extends BusinessException {

    public InvalidCommentIdException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}