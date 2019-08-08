package ir.alzahra.offerBaz.control.impl;

import ir.alzahra.offerBaz.control.IUserService;
import ir.alzahra.offerBaz.model.dao.IUserDao;
import ir.alzahra.offerBaz.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mobina Pak
 * @Date: 8/1/2019
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserEntity register(UserEntity userEntity) {
        userDao.insert(userEntity);
        return userEntity;
    }
}
