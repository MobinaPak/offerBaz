package ir.alzahra.offerBaz.model.dao;

import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.ProductEntity;

import java.util.List;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
public interface IProductDao extends GenericDao<ProductEntity> {

     ProductEntity findProductByCode(String trackingCode)throws BaseException;

    List<ProductEntity> searchProductByParam(Long param)throws BaseException;
    Long getCountOfRecord()throws BaseException;
    ProductEntity findByName(String name)throws BaseException;

//    void initializeDatabase(String s) throws BaseException;

//    Integer getUniqueNumber() throws BaseException;
}
