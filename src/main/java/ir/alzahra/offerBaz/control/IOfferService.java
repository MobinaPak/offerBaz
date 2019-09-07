package ir.alzahra.offerBaz.control;


import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

import java.util.List;

/**
 * @Author: Mobina Pak
 * @Date: 5/3/2019
 **/
public interface IOfferService {


    void insertBank(BankEntity bankDTO)throws BaseException;

    List<BankEntity> getAllBanks()throws BaseException;

    void updateBank(BankEntity bankEntity, String trackCode)throws BaseException;

    BankEntity findBankByName(String bankName)throws BaseException;

    ProductEntity findProductByCode(String trackingCode)throws BaseException;

//    void initializeDatabase(String name) throws BaseException;
//
    String generateUniqueCode(String name2) throws BaseException;

    void updateProduct(ProductEntity productEntity)throws BaseException;

    void deleteProduct(ProductEntity productEntity)throws BaseException;

    String findBankByAbbreviation(String name)throws BaseException;

    List<ProductEntity> searchProductByParam(Long param)throws BaseException;

    List<BankEntity> searchBankByParam(String bankName)throws BaseException;

    void deleteBank(BankEntity bankEntity)throws BaseException;

    void checkExistProduct(String name)throws BaseException;

    void editBankInfo(BankEntity bankEntity)throws BaseException;
}
