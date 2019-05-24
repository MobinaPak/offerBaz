package ir.alzahra.offerBaz.view.ws;

import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.facade.IProductFacade;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/

@RestController
@RequestMapping(value = RestURIConstants.PRODUCT)
public class ProductController {

    @Autowired
    private IProductFacade productFacade;


    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    ResponseEntity<ResponseDTO> insert(@RequestBody ProductDTO productDTO) {
        productFacade.insert(productDTO);
        return new ResponseEntity(HttpStatus.OK);

       }


}
