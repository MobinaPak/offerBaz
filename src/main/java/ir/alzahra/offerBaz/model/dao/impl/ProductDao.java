package ir.alzahra.offerBaz.model.dao.impl;

import ir.alzahra.offerBaz.dto.searchParameter.ProductSearchParam;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IProductDao;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

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
        entityManager.merge(entity);

    }

    public Long getCountOfRecord(){
        Query query = entityManager.createQuery("SELECT count (*) FROM ProductEntity ");
        return (long) query.getSingleResult();
    }

    @Override
    public void delete(ProductEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
//        entityManager.remove(entity);

    }

    @Override
    public ProductEntity findProductByCode(String trackingCode) throws BaseException {
        TypedQuery query =entityManager.createNamedQuery("findProductByCode", ProductEntity.class);
        query.setParameter("productCode",trackingCode);
        List<ProductEntity> products = query.getResultList();
        if (Objects.nonNull(products) && products.size()>0)
            return products.get(0);
        else
            return null;
    }

    @Override
    public List<ProductEntity> searchProductByParam(Long param) throws BaseException {

        String queryStatement="select * from PRODUCT p where (p.BANK_ID=:bankId)";
        Query query=entityManager.createNativeQuery(queryStatement,ProductEntity.class);
        query.setParameter("bankId",param);
       return query.getResultList();


    }
}
