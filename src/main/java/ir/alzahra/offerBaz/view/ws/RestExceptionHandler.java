package ir.alzahra.offerBaz.view.ws;

import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.enums.ResponseStatus;
import ir.alzahra.offerBaz.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Autor: Mobina Pak
 * @Date: 2/5/2019
 **/
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = {Throwable.class})
    ResponseEntity<ResponseDTO> handle (Throwable t){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponseStatus(ResponseStatus.ERROR);
        if (t instanceof AccessDeniedException){
            responseDTO.setMsg("Your not allowed!");
        }else if (t instanceof BaseException){
            responseDTO.setMsg(t.getMessage());
        }else {
            responseDTO.setMsg("Problems Found!");
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}