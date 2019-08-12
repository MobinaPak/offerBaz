package ir.alzahra.offerBaz.proxy.impl;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IProductProxy;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
@Component
public class ProductProxy extends BaseProxy implements IProductProxy {



 /*   ************************************************************************************************* */

    @Override
    public void insert(ProductDTO productDTO) throws BaseException {
         callRest(RestURIConstants.MAIN_URI+"/product/insert"
                 , productDTO);
    }
}
