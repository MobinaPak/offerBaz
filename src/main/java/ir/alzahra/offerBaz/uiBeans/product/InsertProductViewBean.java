package ir.alzahra.offerBaz.uiBeans.product;

import ir.alzahra.offerBaz.dto.ProductDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: Home
 * @Date: 5/5/2019
 **/
@Component("insertProductViewBean")
@Scope("view")
public class InsertProductViewBean {

   private ProductDTO productDTO;

   public void init(){

   }

   public ProductDTO getProductDTO() {
      return productDTO;
   }

   public void setProductDTO(ProductDTO productDTO) {
      this.productDTO = productDTO;
   }

   public void insert(){

   }
}
