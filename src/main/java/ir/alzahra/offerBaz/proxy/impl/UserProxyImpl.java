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
        return callRest(RestURIConstants.MAIN_URI + "/ws" + RestURIConstants.USER + RestURIConstants.REGISTER_USER, userDTO, new ParameterizedTypeReference<ResponseDTO<UserDTO>>() {
        });
    }
}
