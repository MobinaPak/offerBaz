package ir.alzahra.offerBaz.dto;

import ir.alzahra.offerBaz.enums.ResponseStatus;

/**
 * @Autor: Mobina Pak
 * @Date: 3/5/2019
 **/
public class ResponseDTO<T> extends BaseDto{

    private ResponseStatus responseStatus;
    private T response;
    private String msg;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
