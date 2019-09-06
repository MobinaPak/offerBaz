package ir.alzahra.offerBaz.facade;

import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.exception.UserNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
public interface IUserFacade {

    @Transactional(noRollbackFor = UserNotFoundException.class, rollbackFor = Exception.class)
    UserDTO register(UserDTO userDTO) throws BaseException;

    @Transactional(noRollbackFor = UserNotFoundException.class, rollbackFor = Exception.class)
    UserDTO searchUserByUserName(UserDTO userDTO) throws BaseException;

    @PreAuthorize("isAuthenticated()")
    @Transactional(rollbackFor = Exception.class)
    UserDTO edit(UserDTO userDTO) throws BaseException;
}
