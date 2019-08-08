package ir.alzahra.offerBaz.model.dao.impl;

import ir.alzahra.offerBaz.model.dao.IUserDao;
import ir.alzahra.offerBaz.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: Mobina Pak
 * @Date: 8/1/2019
 **/
@Repository
public class UserDAO extends AbstractDAO implements IUserDao {

    @Override
    public void insert(UserEntity entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    public void delete(UserEntity entity) {

    }
}
