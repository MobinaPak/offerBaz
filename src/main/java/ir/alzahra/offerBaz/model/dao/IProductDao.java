package ir.alzahra.offerBaz.model.dao;

import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
public interface IProductDao extends GenericDao<ProductEntity> {

     ProductEntity findProductByCode(String trackingCode)throws BaseException;

//    void initializeDatabase(String s) throws BaseException;

//    Integer getUniqueNumber() throws BaseException;
}
