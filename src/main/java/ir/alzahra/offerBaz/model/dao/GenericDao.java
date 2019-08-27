package ir.alzahra.offerBaz.model.dao;

import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
@Transactional(rollbackFor = Exception.class)
public interface GenericDao<E> {

     void insert(E entity);
     void update(E entity);
     void delete(E entity);
}
