package ir.alzahra.offerBaz.model.dao.impl;

import ir.alzahra.offerBaz.model.dao.GenericDao;
import ir.alzahra.offerBaz.model.dao.IProductDao;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
@Repository
public class ProductDao extends AbstractDAO implements IProductDao {


    @Override
    public void insert(ProductEntity entity) {
        entityManager.persist(entity);

    }

    @Override
    public void update(ProductEntity entity) {

    }

    @Override
    public void delete(ProductEntity entity) {

    }
}
