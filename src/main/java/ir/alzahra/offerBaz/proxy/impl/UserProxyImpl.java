package ir.alzahra.offerBaz.proxy.impl;

import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IUserProxy;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
@Component
public class UserProxyImpl extends BaseProxy implements IUserProxy {

    @Override
    public UserDTO register(UserDTO userDTO) throws BaseException {
        return callRest(RestURIConstants.MAIN_URI  + RestURIConstants.USER + RestURIConstants.REGISTER_USER, userDTO, new ParameterizedTypeReference<ResponseDTO<UserDTO>>() {
        });
    }

    @Override
    public UserDTO getUser(UserDTO userDTO) throws BaseException {
        return callRest(RestURIConstants.MAIN_URI + RestURIConstants.USER + RestURIConstants.GET_USER, userDTO, new ParameterizedTypeReference<ResponseDTO<UserDTO>>() {
        });
    }

    @Override
    public UserDTO edit(UserDTO userDTO) throws BaseException {
        return callRest(RestURIConstants.MAIN_URI + RestURIConstants.USER + RestURIConstants.EDIT_USER, userDTO, new ParameterizedTypeReference<ResponseDTO<UserDTO>>() {
        });
    }
}
