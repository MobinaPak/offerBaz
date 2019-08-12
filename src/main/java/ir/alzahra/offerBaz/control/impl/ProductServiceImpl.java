package ir.alzahra.offerBaz.control.impl;

import ir.alzahra.offerBaz.control.IProductService;
import ir.alzahra.offerBaz.model.dao.IProductDao;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import ir.alzahra.offerBaz.notify.CustomSpringEvent;
import ir.alzahra.offerBaz.notify.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Autowired
    private CustomSpringEvent applicationEventPublisher;

    @Override
    public void insert(ProductEntity productEntity) {
        productDao.insert(productEntity);
        applicationEventPublisher.notify("product.insert.success", NotificationType.Info);

    }
}
