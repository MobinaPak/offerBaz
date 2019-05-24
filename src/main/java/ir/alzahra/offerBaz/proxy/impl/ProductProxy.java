package ir.alzahra.offerBaz.proxy.impl;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.enums.ResponseStatus;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
@Component
public class ProductProxy extends BaseProxy implements ir.alzahra.offerBaz.proxy.impl.IProductProxy {

    @Value("${SERVER_URL}")
    private String serverUrl;

    @Override
    public <T> T callRest(String address, ParameterizedTypeReference<ResponseDTO<T>> t) throws BaseException {
        return callRest(address, null, t);
    }

    @Override
    public <T> T callRest(String address, Object sendObject, ParameterizedTypeReference<ResponseDTO<T>> t) throws BaseException {
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", responseDto.getMsg()));
        } else {
            throw new BaseException(responseDto.getMsg());
        }
        return responseDto.getResponse();
    }

    @Override
    public void callRest(String address) throws BaseException {
        callRest(address, null);
    }

    @Override
    public void callRest(String address, Object sendObject) throws BaseException {
        callRest(address, sendObject, new ParameterizedTypeReference<ResponseDTO<String>>() {
        });
    }

 /*   ************************************************************************************************* */

    @Override
    public void insert(ProductDTO productDTO) throws BaseException {
         callRest(serverUrl+"/ws/product/insert", productDTO);
    }
}
