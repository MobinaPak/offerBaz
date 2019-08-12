package ir.alzahra.offerBaz.facade;

import ir.alzahra.offerBaz.dto.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/

public interface IProductFacade {

    @Transactional(rollbackFor = Exception.class)
    void insert(ProductDTO productDTO);
}
