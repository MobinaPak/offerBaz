package ir.alzahra.offerBaz.control.impl;

import ir.alzahra.offerBaz.control.IUserService;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IUserDao;
import ir.alzahra.offerBaz.model.entity.UserEntity;
import ir.alzahra.offerBaz.notify.CustomSpringEvent;
import ir.alzahra.offerBaz.notify.NotificationType;
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

    @Autowired
    private CustomSpringEvent applicationEventPublisher;

    @Override
    public UserEntity register(UserEntity userEntity) {
        userDao.insert(userEntity);
        applicationEventPublisher.notify("user.register.success", NotificationType.Info);
        return userEntity;
    }

    @Override
    public UserEntity searchUserByUserName(UserEntity userEntity) throws BaseException {
        UserEntity u=userDao.searchUserByUserName(userEntity.getProfile().getUserName());
        return u;
    }

    @Override
    public UserEntity edit(UserEntity userEntity) {
        userDao.update(userEntity);
        return userEntity;
    }
}
