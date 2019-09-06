package ir.alzahra.offerBaz.model.dao;

import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.BankEntity;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

import java.util.List;

/**
 * @Author: hanieh Moafi
 * @Date: 8/12/2019
 **/
public interface IBankDao extends GenericDao<BankEntity> {
    List<BankEntity> getAllBanks()throws BaseException;

    BankEntity findByName(String bankName)throws BaseException;

    String findBankByAbbreviation(String name)throws BaseException;

    List<BankEntity> findBankByParam(String bankName)throws BaseException;
}
