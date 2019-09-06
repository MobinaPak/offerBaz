package ir.alzahra.offerBaz.control.impl;

import ir.alzahra.offerBaz.control.IUserService;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.model.dao.IUserDao;
import ir.alzahra.offerBaz.model.entity.ProfileRoleEntity;
import ir.alzahra.offerBaz.model.entity.UserEntity;
import ir.alzahra.offerBaz.notify.CustomSpringEvent;
import ir.alzahra.offerBaz.notify.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Mobina Pak
 * @Date: 8/1/2019
 **/
@Service("userDetailsService")
public class UserServiceImpl implements IUserService, UserDetailsService {

    private IUserDao userDao;
    private CustomSpringEvent applicationEventPublisher;

    @Autowired
    public UserServiceImpl(IUserDao userDao, CustomSpringEvent applicationEventPublisher) {
        this.userDao = userDao;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public UserEntity register(UserEntity userEntity) {
        userDao.insert(userEntity);
        applicationEventPublisher.notify("user.register.success", NotificationType.Info);
        return userEntity;
    }

    @Override
    public UserEntity searchUserByUserName(UserEntity userEntity) throws BaseException {
        return userDao.searchUserByUserName(userEntity.getProfile().getUserName());
    }

    @Override
    public UserEntity edit(UserEntity userEntity) {
        userDao.update(userEntity);
        applicationEventPublisher.notify("user.edit.success", NotificationType.Info);
        return userEntity;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) {
        UserEntity user = null;
        try {
            user = userDao.searchUserByUserName(username);
        } catch (BaseException e) {
            e.printStackTrace();
        }
        List<GrantedAuthority> authorities =
                buildUserAuthority(user.getProfile().getProfileRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        return new User(user.getProfile().getUserName(), user.getProfile().getPassword(), user.getProfile().getEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<ProfileRoleEntity> profileRoleEntityList) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        for (ProfileRoleEntity role : profileRoleEntityList) {
            setAuths.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<GrantedAuthority>(setAuths);
    }
}
