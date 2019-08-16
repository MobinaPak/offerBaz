package ir.alzahra.offerBaz.view.ws;

import ir.alzahra.offerBaz.dto.ResponseDTO;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.enums.ResponseStatus;
import ir.alzahra.offerBaz.facade.IUserFacade;
import ir.alzahra.offerBaz.view.RestURIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
@RestController
@RequestMapping(value = RestURIConstants.USER)
public class UserController {

    @Autowired
    private IUserFacade userFacade;

    @RequestMapping(method = RequestMethod.POST, value = RestURIConstants.REGISTER_USER)
    ResponseEntity<ResponseDTO<UserDTO>> register(@RequestBody UserDTO userDTO) {
        ResponseDTO<UserDTO> responseDto = new ResponseDTO<>();
        try {
            responseDto.setResponse(userFacade.register(userDTO));
            responseDto.setMsg("User registered successfully");
            responseDto.setResponseStatus(ResponseStatus.OK);
        } catch (Exception e) {
            responseDto.setMsg(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.ERROR);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = RestURIConstants.GET_USER)
    ResponseEntity<ResponseDTO<UserDTO>> searchUserByUserName(@RequestBody UserDTO userDTO) {
        ResponseDTO<UserDTO> responseDto = new ResponseDTO<>();
        try {
            responseDto.setResponse(userFacade.searchUserByUserName(userDTO));
            responseDto.setResponseStatus(ResponseStatus.OK);
        } catch (Exception e) {
            responseDto.setMsg(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.ERROR);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = RestURIConstants.EDIT_USER)
    ResponseEntity<ResponseDTO<UserDTO>> editUser(@RequestBody UserDTO userDTO) {
        ResponseDTO<UserDTO> responseDto = new ResponseDTO<>();
        try {
            responseDto.setResponse(userFacade.edit(userDTO));
            responseDto.setMsg("User edited successfully");
            responseDto.setResponseStatus(ResponseStatus.OK);
        } catch (Exception e) {
            responseDto.setMsg(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.ERROR);
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
