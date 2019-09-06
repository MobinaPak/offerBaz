package ir.alzahra.offerBaz.view.beans.bank;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.view.util.GeneralUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * @author z.moafi
 * @since 28/08/2019
 */
@Component("viewProductInBank")
@Scope("view")
public class ViewProductInBank implements Serializable {

    private ProductDTO productDTO;

    public void init() {
        productDTO = (ProductDTO) GeneralUtil.getAndRemoveObjectFromObjectRepository(FacesContext.getCurrentInstance(), "viewObject");

    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
