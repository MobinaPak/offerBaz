package ir.alzahra.offerBaz.proxy.impl;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.MultiWrapperDto;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IOfferProxy;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
@Component
public class OfferProxy extends BaseProxy implements IOfferProxy {



 /*   ************************************************************************************************* */


    @Override
    public void insertBank(BankDTO bankDTO)throws BaseException {
        callRest(RestURIConstants.MAIN_URI+"/bank/insertBank"
                , bankDTO);
    }

    @Override
    public List<BankDTO> getAllBanks() throws BaseException {
        return callRest(RestURIConstants.MAIN_URI+"/bank/getAllBanks",new ParameterizedTypeReference<ResponseDTO<List<BankDTO>>>(){});
    }

    @Override
    public void updateBank(BankDTO selectedBank) throws BaseException {
        callRest(RestURIConstants.MAIN_URI+"/bank/updateBank",selectedBank);

    }

    @Override
    public BankDTO findBankByName(String bankName) throws BaseException {
/*        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("bankName", Objects.toString(bankName, null));*/
       return callRest(RestURIConstants.MAIN_URI + "/bank/findBankByName", bankName, new ParameterizedTypeReference<ResponseDTO<BankDTO>>() {
       });

    }

    @Override
    public ProductDTO findProduct(String trackingCode) throws BaseException {
        return callRest(RestURIConstants.MAIN_URI + "/product/findProductByCode", trackingCode, new ParameterizedTypeReference<ResponseDTO<ProductDTO>>() {
        });
    }

    @Override
    public void editProduct(ProductDTO productDto) throws BaseException {
         callRest(RestURIConstants.MAIN_URI + "/product/updateProduct", productDto);
    }

    @Override
    public void deleteProduct(ProductDTO productDto) throws BaseException {
        callRest(RestURIConstants.MAIN_URI + "/product/deleteProduct", productDto);

    }

    @Override
    public String findBankByAbbreviation(String name) throws BaseException {
        return callRest(RestURIConstants.MAIN_URI + "/bank/findBankByAbbreviation", name, new ParameterizedTypeReference<ResponseDTO<String>>() {
        });
    }

    @Override
    public List<ProductDTO> searchProduct(Long searchParam) throws BaseException {
        return callRest(RestURIConstants.MAIN_URI + "/product/searchProductByParam", searchParam, new ParameterizedTypeReference<ResponseDTO<List<ProductDTO>>>() {

        });}

    @Override
    public List<BankDTO> findBankByParam(String bankName) throws BaseException {
        return callRest(RestURIConstants.MAIN_URI + "/bank/searchBankByParam", bankName, new ParameterizedTypeReference<ResponseDTO<List<BankDTO>>>() {
        });}

}
