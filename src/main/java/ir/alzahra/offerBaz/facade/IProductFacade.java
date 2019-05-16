package ir.alzahra.offerBaz.facade;

import ir.alzahra.offerBaz.dto.ProductDTO;
import org.springframework.stereotype.Component;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/

public interface IProductFacade {

    void insert(ProductDTO productDTO);
}
