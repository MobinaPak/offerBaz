package ir.alzahra.offerBaz.view.beans.user;

import ir.alzahra.offerBaz.dto.ProfileDTO;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.proxy.IUserProxy;
import ir.alzahra.offerBaz.view.beans.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Objects;

/**
 * @Author: Mobina Pak
 * @Date: 8/9/2019
 **/
@Component("editUserInformationViewBean")
@Scope("view")
public class EditUserInformationViewBean extends BaseBean {

    private UserDTO userDTO;

    private IUserProxy userProxy;

    @Autowired
    public void setUserProxy(IUserProxy userProxy) {
        this.userProxy = userProxy;
    }

    public void init() {
        try {
            userDTO = new UserDTO();
            userDTO.setProfile(new ProfileDTO());
            userDTO.getProfile().setUserName("0");
            userDTO = userProxy.getUser(userDTO);
        } catch (BaseException e) {
            e.printStackTrace();
        }
        if (Objects.isNull(userDTO)){
            emptyPage();
        }
    }

    public void edit() {
        try {
            userProxy.edit(userDTO);
            emptyPage();
        } catch (BaseException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    e.getMessage(), ""));
        }
    }

    public void dismiss() {
        emptyPage();
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
}
