package ir.alzahra.offerBaz.facade.impl;

import ir.alzahra.offerBaz.control.IUserService;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.exception.UserNotFoundException;
import ir.alzahra.offerBaz.exception.UserRegisterException;
import ir.alzahra.offerBaz.facade.IUserFacade;
import ir.alzahra.offerBaz.facade.mapper.MapperClass;
import ir.alzahra.offerBaz.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
@Component
@Transactional
public class UserFacadeImpl implements IUserFacade {

    private IUserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserFacadeImpl(IUserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO register(UserDTO userDTO) throws BaseException {
        userDTO.getProfile().setPassword(passwordEncoder.encode(userDTO.getProfile().getPassword()));
        UserEntity user = userService.searchUserByUserName(MapperClass.mapper(new UserEntity(), userDTO));
        if (user != null) {
            throw new UserRegisterException("user.register.duplicateUserName");
        }
        UserEntity userEntity = MapperClass.mapper(new UserEntity(), userDTO);
        userService.register(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO searchUserByUserName(UserDTO userDTO) throws BaseException {
        try {
            UserEntity userEntity = MapperClass.mapper(new UserEntity(), userDTO);
            UserEntity user = userService.searchUserByUserName(userEntity);
            return MapperClass.mapper(new UserDTO(), user);
        } catch (BaseException e) {
            throw new UserNotFoundException("user.login.userNotFound");
        }
    }

    @Override
    public UserDTO edit(UserDTO userDTO) {
        UserEntity userEntity = MapperClass.mapper(new UserEntity(), userDTO);
        UserEntity user = userService.edit(userEntity);
        return MapperClass.mapper(new UserDTO(), user);
    }
}
