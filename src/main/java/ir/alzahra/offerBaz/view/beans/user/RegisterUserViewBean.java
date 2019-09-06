package ir.alzahra.offerBaz.view.beans.user;

import ir.alzahra.offerBaz.dto.ProfileDTO;
import ir.alzahra.offerBaz.dto.ProfileRoleDTO;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IUserProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mobina Pak
 * @Date: 8/8/2019
 **/
@Component("registerUserViewBean")
@Scope("view")
public class RegisterUserViewBean extends BaseBean {

    private UserDTO userDTO;
    private String userName;
    private String password;

    private IUserProxy userProxy;

    @Autowired
    public void setUserProxy(IUserProxy userProxy) {
        this.userProxy = userProxy;
    }

    public RegisterUserViewBean() {
        userDTO = new UserDTO();
    }

    public void register() {
        try {
            List<ProfileRoleDTO> roles = new ArrayList<>();
            roles.add(new ProfileRoleDTO("ROLE_USER"));
            userDTO.setProfile(new ProfileDTO(userName, password, true , roles));
            userDTO.setPhoneNumber(userName);
            userProxy.register(userDTO);
            addNotificationMessage();
            emptyPage();
        } catch (BaseException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    e.getMessage(), ""));
        }
    }

    private void emptyPage() {
        userDTO = new UserDTO();
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
