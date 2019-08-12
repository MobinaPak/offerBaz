package ir.alzahra.offerBaz.view.ws;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.facade.IOfferFacade;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/

@RestController
@RequestMapping(value = "")
public class OfferController {

    @Autowired
    private IOfferFacade offerFacade;


    @RequestMapping(method = RequestMethod.POST, value = "/insertProduct.xhtml")
    ResponseEntity<ResponseDTO> insertProduct(@RequestBody ProductDTO productDTO) throws BaseException {
        offerFacade.insertProduct(productDTO);
        return new ResponseEntity(HttpStatus.OK);

       }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/insertBank")
    ResponseEntity<ResponseDTO> insertBank(@RequestBody BankDTO bankDTO) throws BaseException {
        offerFacade.insertBank(bankDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/getAllBanks")
    ResponseEntity<ResponseDTO<List<BankDTO>>> getAllBanks() throws BaseException {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setResponse(offerFacade.getAllBanks());

        return new ResponseEntity<ResponseDTO<List<BankDTO>>>(responseDto, HttpStatus.OK);



    }
    @RequestMapping(method = RequestMethod.POST, value = "/bank/updateBank")
    ResponseEntity<ResponseDTO> updateBank(@RequestBody BankDTO bankDTO) throws BaseException {
        offerFacade.updateBank(bankDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

}
