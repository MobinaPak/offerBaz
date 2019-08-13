package ir.alzahra.offerBaz.control;

import com.sun.org.apache.xpath.internal.operations.String;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

import java.util.List;

/**
 * @Author: Mobina Pak
 * @Date: 5/3/2019
 **/
public interface IOfferService {

    void insertProduct(ProductEntity productEntity)throws BaseException;

    void insertBank(BankEntity bankDTO)throws BaseException;

    List<BankEntity> getAllBanks()throws BaseException;

    void updateBank(BankEntity bankEntity)throws BaseException;

    BankEntity findBankByName(String bankName)throws BaseException;
}
