package ir.alzahra.offerBaz.model.dao.impl;

import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IProductDao;
import ir.alzahra.offerBaz.model.entity.ProductEntity;
import org.springframework.stereotype.Repository;

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

//    public Integer getUniqueNumber(){
//        String query= "select SESSION_COUNTER_SEQ.nextval from dual";
//        Query nativeQuery = entityManager.createNativeQuery(query);
//        return ((Number)nativeQuery.getSingleResult()).intValue();
//    }
//
//
//    public void initializeDatabase(String name) throws BaseException {
//        InputStream resourcAsStream = this.getClass().getClassLoader().getResourceAsStream(name);
//        ScriptRunner sr = new ScriptRunner(entityManager.unwrap(SessionImpl.class).connection());
//        sr.runScript(new InputStreamReader(resourcAsStream));
//
//    }
}
