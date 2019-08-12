package ir.alzahra.offerBaz.proxy;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
public interface IProductProxy {

    public void insert(ProductDTO productDTO)throws BaseException;
}
