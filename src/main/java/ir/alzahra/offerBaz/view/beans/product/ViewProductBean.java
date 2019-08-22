package ir.alzahra.offerBaz.view.beans.product;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author z.moafi
 * @since 22/08/2019
 */

@Component("viewProductBean")
@Scope("view")
public class ViewProductBean extends BaseBean {

    @Autowired
    private IOfferProxy offerProxy;

    private ProductDTO productDTO;
    private String trackingCode;



    public void init(){

    }


    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }


    public void searchProduct(){

        try {
            productDTO = offerProxy.findProduct(trackingCode);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }
}
