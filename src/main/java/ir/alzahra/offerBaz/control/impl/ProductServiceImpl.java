package ir.alzahra.offerBaz.control.impl;

import ir.alzahra.offerBaz.control.IProductService;
import ir.alzahra.offerBaz.model.dao.IProductDao;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import org.springframework.stereotype.Service;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
@Service
public class ProductServiceImpl implements IProductService {

    private IProductDao productDao;

    @Override
    public void insert(ProductEntity productEntity) {
        productDao.insert(productEntity);

    }
}
