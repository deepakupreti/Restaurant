package com.example.restaurant.handler.ErrorHandlers;


import com.example.restaurant.constants.AppStatusCode;
import com.example.restaurant.constants.Status;
import com.example.restaurant.exception.CustomExceptions;
import com.example.restaurant.model.response.BaseResponse;
import com.example.restaurant.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ErrorResponseAdviceHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomExceptions.RestaurantClosedException.class})
    protected ResponseEntity<Object> handleRestaurantClosedException(RuntimeException ex, WebRequest request) {
        log.info("restaurant is closed", ex);
        ErrorResponse errorDetails = new ErrorResponse(
                Collections.singletonList(ex.getMessage()),
                AppStatusCode.RESTAURANT_CLOSED.getDesc(),
                AppStatusCode.RESTAURANT_CLOSED.getCode()
        );
        return new ResponseEntity<>(
                new BaseResponse<>(Status.ERROR, errorDetails), new HttpHeaders(), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = {CustomExceptions.MaximumOrderLimitBreachedException.class})
    protected ResponseEntity<Object> handleMaximumOrderLimitException(RuntimeException ex, WebRequest request) {
        log.info("Restaurant order limit exhausted ", ex);
        ErrorResponse errorDetails = new ErrorResponse(
                Collections.singletonList(ex.getMessage()),
                AppStatusCode.RESTAURANT_ORDER_LIMIT_EXHAUSTED.getDesc(),
                AppStatusCode.RESTAURANT_ORDER_LIMIT_EXHAUSTED.getCode()
        );
        return new ResponseEntity<>(
                new BaseResponse<>(Status.ERROR, errorDetails), new HttpHeaders(), HttpStatus.NOT_FOUND
        );
    }


}
