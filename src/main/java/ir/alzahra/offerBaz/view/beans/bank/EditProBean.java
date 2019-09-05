package ir.alzahra.offerBaz.view.beans.bank;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.enums.DtoState;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import ir.alzahra.offerBaz.view.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * @Author: zahra soltaninejad
 * @Date: 9/5/2019, Thu
 **/
@Component("editProBean")
@Scope("view")
public class EditProBean extends BaseBean implements Serializable{


        private ProductDTO productDTO;

        @Autowired
        private IOfferProxy offerProxy;


        public void init() {
            productDTO = (ProductDTO) GeneralUtil.getAndRemoveObjectFromObjectRepository(FacesContext.getCurrentInstance(), "viewObject");

        }

        public ProductDTO getProductDTO() {
            return productDTO;
        }

        public void setProductDTO(ProductDTO productDTO) {
            this.productDTO = productDTO;
        }

        public void edit() {
            try {
                productDTO.setDtoState(DtoState.Edit);
                offerProxy.editProduct(productDTO);
                addNotificationMessage();
            } catch (BaseException e) {
                //TODO
            }

        }

        public void delete() {
            productDTO.setDtoState(DtoState.Delete);
            try {
                offerProxy.deleteProduct(productDTO);
                addNotificationMessage();
            } catch (BaseException e) {
                //TODO
            }
        }


}
