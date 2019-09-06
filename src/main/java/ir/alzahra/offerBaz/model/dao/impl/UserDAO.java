package ir.alzahra.offerBaz.model.dao.impl;

import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IUserDao;
import ir.alzahra.offerBaz.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

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
        entityManager.merge(entity);
    }

    @Override
    public UserEntity searchUserByUserName(String userName) throws BaseException {
        String jpql = "select user from UserEntity user where user.profile.userName =:userName";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("userName", userName);
        try {
            return (UserEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new BaseException();
        }
    }

    @Override
    public void delete(UserEntity entity) {

    }
}
