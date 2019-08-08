package ir.alzahra.offerBaz.proxy.impl;

import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.enums.ResponseStatus;
import ir.alzahra.offerBaz.exception.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
abstract class BaseProxy {

    @Value("${SERVER_URL}")
    protected String serverUrl;

    protected <T> T callRest(String address, ParameterizedTypeReference<ResponseDTO<T>> t) throws BaseException {
        return callRest(address, null, t);
    }

    protected <T> T callRest(String address, Object sendObject, ParameterizedTypeReference<ResponseDTO<T>> t) throws BaseException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();

        String headerValue = FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get("cookie");
        requestHeaders.add("Cookie", headerValue);

        HttpEntity requestEntity = new HttpEntity(sendObject, requestHeaders);
        ResponseEntity<ResponseDTO<T>> response = restTemplate.exchange(
                address,
                HttpMethod.POST,
                requestEntity,
                t);
        ResponseDTO<T> responseDto = response.getBody();
        if (responseDto.getResponseStatus().equals(ResponseStatus.OK)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, responseDto.getMsg(), ""));
        } else {
            throw new BaseException(responseDto.getMsg());
        }
        return responseDto.getResponse();
    }

    protected void callRest(String address) throws BaseException {
        callRest(address, null);
    }

    protected void callRest(String address, Object sendObject) throws BaseException {
        callRest(address, sendObject, new ParameterizedTypeReference<ResponseDTO<String>>() {
        });
    }
}
