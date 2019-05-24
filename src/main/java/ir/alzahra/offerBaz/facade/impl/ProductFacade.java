package ir.alzahra.offerBaz.facade.impl;

import ir.alzahra.offerBaz.control.IProductService;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.facade.IProductFacade;
import ir.alzahra.offerBaz.facade.mapper.MapperClass;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
@Component
public class ProductFacade implements IProductFacade {

    @Autowired
    private IProductService productService;


    @Override
    public void insert(ProductDTO productDTO) {
        ProductEntity p=MapperClass.mapper(new ProductEntity(),productDTO);
        productService.insert(p);


    }
}
