package com.ng.emts.esd.crazynaijadeal.api;

import com.ng.emts.esd.crazynaijadeal.exceptions.BadRequestException;
import com.ng.emts.esd.crazynaijadeal.exceptions.NotFoundException;
import com.ng.emts.esd.crazynaijadeal.model.base.CompleteLog;
import com.ng.emts.esd.crazynaijadeal.model.base.Response;
import com.ng.emts.esd.crazynaijadeal.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(annotations = {RestController.class})
@ResponseBody
public class ErrorAdvice {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleBadRequestException(BadRequestException e){
        return createAPIResponse(e,"400");
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleNotFoundException(NotFoundException e){
        return createAPIResponse(e,"404");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    private Response createAPIResponse(Exception e, String code){
        e.printStackTrace();
        CompleteLog log = LogUtil.getExceptionMessageWithGUID(e);
        logger.error(log.getUuid() + "\n" + log.getMessage());
        Response response = new Response(code, e.getMessage());
        response.setLogId(log.getUuid());

        return response;
    }
}
