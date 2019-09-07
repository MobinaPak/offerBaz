package ir.alzahra.offerBaz.view.ws;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.MultiWrapperDto;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.enums.ResponseStatus;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.facade.IOfferFacade;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    @RequestMapping(method = RequestMethod.POST, value = "/bank/insertBank")
    ResponseEntity<ResponseDTO> insertBank(@RequestBody BankDTO bankDTO) throws BaseException {
        offerFacade.insertBank(bankDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/getAllBanks")
    ResponseEntity<ResponseDTO<List<BankDTO>>> getAllBanks() throws BaseException {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setResponse(offerFacade.getAllBanks());
        responseDto.setResponseStatus(ResponseStatus.OK);
        return new ResponseEntity<ResponseDTO<List<BankDTO>>>(responseDto, HttpStatus.OK);



    }
    @RequestMapping(method = RequestMethod.POST, value = "/bank/updateBank")
    ResponseEntity<ResponseDTO> updateBank(@RequestBody BankDTO bankDTO) throws BaseException {
        offerFacade.updateBank(bankDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/editBankInfo")
    ResponseEntity<ResponseDTO> editBankInfo(@RequestBody BankDTO bankDTO) throws BaseException {
        offerFacade.editBankInfo(bankDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/findBankByName")
    ResponseEntity<ResponseDTO<BankDTO>> findBankByName(@RequestBody String bankName) throws BaseException {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setResponse(offerFacade.findBankByName(bankName));
        responseDto.setResponseStatus(ResponseStatus.OK);
        return new ResponseEntity<ResponseDTO<BankDTO>>(responseDto, HttpStatus.OK);


    }

    @RequestMapping(method = RequestMethod.POST, value = "/product/findProductByCode")
    ResponseEntity<ResponseDTO<ProductDTO>> findProductByCode(@RequestBody String trackingCode) throws BaseException {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setResponse(offerFacade.findProductByCode(trackingCode));
        responseDto.setResponseStatus(ResponseStatus.OK);
        return new ResponseEntity<ResponseDTO<ProductDTO>>(responseDto, HttpStatus.OK);


    }

    @RequestMapping(method = RequestMethod.POST, value = "/product/updateProduct")
    ResponseEntity<ResponseDTO> updateProduct(@RequestBody ProductDTO productDTO) throws BaseException {
        offerFacade.updateProduct(productDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/product/deleteProduct")
    ResponseEntity<ResponseDTO> deleteProduct(@RequestBody ProductDTO productDTO) throws BaseException {
        offerFacade.deleteProduct(productDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/deleteBank")
    ResponseEntity<ResponseDTO> deleteBank(@RequestBody BankDTO bankDTO) throws BaseException {
        offerFacade.deleteBank(bankDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/findBankByAbbreviation")
    ResponseEntity<ResponseDTO<String>> findBankByAbbreviation(@RequestBody String name) throws BaseException {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setResponse(offerFacade.findBankByAbbreviation(name));
        responseDto.setResponseStatus(ResponseStatus.OK);
        return new ResponseEntity<ResponseDTO<String>>(responseDto, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/product/searchProductByParam")
    ResponseEntity<ResponseDTO<List<ProductDTO>>> searchProductByParam(@RequestBody Long param) throws BaseException {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setResponse(offerFacade.searchProductByParam(param));
        responseDto.setResponseStatus(ResponseStatus.OK);
        return new ResponseEntity<ResponseDTO<List<ProductDTO>>>(responseDto, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/bank/searchBankByParam")
    ResponseEntity<ResponseDTO<List<BankDTO>>> searchBankByParam(@RequestBody String bankName) throws BaseException {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setResponse(offerFacade.searchBankByParam(bankName));
        responseDto.setResponseStatus(ResponseStatus.OK);
        return new ResponseEntity<ResponseDTO<List<BankDTO>>>(responseDto, HttpStatus.OK);

    }


}
