package ir.alzahra.offerBaz.view.beans.product;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.impl.IProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: hanieh Moafi
 * @Date: 5/5/2019
 **/
@Component("insertProductViewBean")
@Scope("view")
public class InsertProductViewBean {

    @Autowired
    private IProductProxy productProxy;

    private ProductDTO productDTO;


    public void init() {
        if (Objects.isNull(productDTO))
            emptyPage();


    }


    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }


    private void emptyPage() {
        productDTO = new ProductDTO();

    }

    public void insert() {
        try {

            productProxy.insert(productDTO);
        } catch (BaseException e) {
            //TODO
        }


    }
}
