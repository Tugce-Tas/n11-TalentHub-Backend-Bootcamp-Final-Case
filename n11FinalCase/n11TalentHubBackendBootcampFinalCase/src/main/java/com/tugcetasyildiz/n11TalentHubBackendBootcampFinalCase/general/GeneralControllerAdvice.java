package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.*;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message.GeneralErrorMessage;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.KafkaProducerService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class GeneralControllerAdvice extends ResponseEntityExceptionHandler {

    private final KafkaProducerService kafkaProducerService;

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){
        String message = e.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessage = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessage);

        kafkaProducerService.sendMessage("errorLog", message);
        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(InvalidCustomerIdException e, WebRequest request) {
        String message = e.getLocalizedMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);
        kafkaProducerService.sendMessage("errorLog", message);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(InvalidRestaurantIdException e, WebRequest request) {
        String message = e.getLocalizedMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);
        kafkaProducerService.sendMessage("errorLog", message);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(InvalidCommentIdException e, WebRequest request) {
        String message = e.getMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);
        kafkaProducerService.sendMessage("errorLog", message);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(ItemNotFoundException e, WebRequest request) {
        String message = e.getMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);
        kafkaProducerService.sendMessage("errorLog", message);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(BusinessException e, WebRequest request) {
        String message = e.getMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessage(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);
        kafkaProducerService.sendMessage("errorLog", message);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }


}