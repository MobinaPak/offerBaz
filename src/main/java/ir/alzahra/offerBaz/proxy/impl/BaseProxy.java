package ir.alzahra.offerBaz.proxy.impl;

import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import org.springframework.core.ParameterizedTypeReference;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
public abstract class BaseProxy {
    abstract <T> T callRest(String address, ParameterizedTypeReference<ResponseDTO<T>> t) throws BaseException;

    abstract <T> T callRest(String address, Object sendObject, ParameterizedTypeReference<ResponseDTO<T>> t) throws BaseException;

    abstract void callRest(String address) throws BaseException;

    abstract void callRest(String address, Object sendObject) throws BaseException;
}
