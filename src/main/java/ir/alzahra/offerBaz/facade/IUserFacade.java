package ir.alzahra.offerBaz.facade;

import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
public interface IUserFacade {

    @Transactional(rollbackFor = Exception.class)
    UserDTO register(UserDTO userDTO);

    @Transactional(rollbackFor = Exception.class)
    UserDTO searchUserByUserName(UserDTO userDTO) throws BaseException;

    @Transactional(rollbackFor = Exception.class)
    UserDTO edit(UserDTO userDTO) throws BaseException;
}
