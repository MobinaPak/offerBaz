package ir.alzahra.offerBaz.control;

import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.entity.UserEntity;

/**
 * @Author: Mobina Pak
 * @Date: 8/1/2019
 **/
public interface IUserService {
    UserEntity register(UserEntity userEntity);
    UserEntity searchUserByUserName(UserEntity userEntity) throws BaseException;
    UserEntity edit(UserEntity userEntity);
}
