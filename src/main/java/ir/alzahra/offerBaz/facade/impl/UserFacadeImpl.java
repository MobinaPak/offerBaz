package ir.alzahra.offerBaz.facade.impl;

import ir.alzahra.offerBaz.control.IUserService;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.facade.IUserFacade;
import ir.alzahra.offerBaz.facade.mapper.MapperClass;
import ir.alzahra.offerBaz.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
@Component
@Transactional
public class UserFacadeImpl implements IUserFacade {

    @Autowired
    private IUserService userService;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = MapperClass.mapper(new UserEntity(), userDTO);
        userService.register(userEntity);
        return userDTO;
    }
}