package ir.alzahra.offerBaz.model.dao;

import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.UserEntity;

/**
 * @Author: Mobina Pak
 * @Date: 8/1/2019
 **/
public interface IUserDao extends GenericDao<UserEntity> {

    UserEntity searchUserByUserName(String userName) throws BaseException;
}
