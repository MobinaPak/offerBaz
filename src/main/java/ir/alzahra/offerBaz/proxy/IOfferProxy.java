package ir.alzahra.offerBaz.proxy;

import ir.alzahra.offerBaz.dto.BankDTO;
import ir.alzahra.offerBaz.dto.ProductDTO;
import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;

import java.util.List;

/**
 * @Author: hanieh Moafi
 * @Date: 5/16/2019
 **/
public interface IOfferProxy {


    void insertBank(BankDTO bankDTO)throws BaseException;

    List<BankDTO> getAllBanks()throws BaseException;

    void updateBank(BankDTO selectedBank)throws BaseException;

    BankDTO findBankByName(String bankName)throws BaseException;

    ProductDTO findProduct(String trackingCode)throws BaseException;

    void editProduct(ProductDTO selectedProduct)throws BaseException;

    void deleteProduct(ProductDTO selectedProduct)throws BaseException;

    String findBankByAbbreviation(String substring)throws BaseException;

    List<ProductDTO> searchProduct(Long searchParam)throws BaseException;

    List<BankDTO> findBankByParam(String bankName)throws BaseException;

    void editBankInfo(BankDTO bankDTO) throws BaseException;

    void deleteBank(BankDTO bankDTO)throws BaseException;
}
