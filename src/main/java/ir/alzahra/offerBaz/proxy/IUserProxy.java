package ir.alzahra.offerBaz.proxy;

import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.BaseException;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
public interface IUserProxy {
    UserDTO register(UserDTO userDTO) throws BaseException;

    UserDTO getUser(UserDTO userDTO) throws BaseException;

    UserDTO edit(UserDTO userDTO) throws BaseException;
}
