package ir.alzahra.offerBaz.model.dao;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/
public interface GenericDao<E> {

     void insert(E entity);
     void update(E entity);
     void delete(E entity);
}
