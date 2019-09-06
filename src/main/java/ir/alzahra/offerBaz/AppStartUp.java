package ir.alzahra.offerBaz;

import ir.alzahra.offerBaz.dto.ProfileDTO;
import ir.alzahra.offerBaz.dto.ProfileRoleDTO;
import ir.alzahra.offerBaz.dto.UserDTO;
import ir.alzahra.offerBaz.exception.UserRegisterException;
import ir.alzahra.offerBaz.facade.IUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppStartUp implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IUserFacade userFacade;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            List<ProfileRoleDTO> roles = new ArrayList<>();
            roles.add(new ProfileRoleDTO("ROLE_ADMIN"));
            userFacade.register(new UserDTO(new ProfileDTO("admin", "admin", true, roles)));
        } catch (UserRegisterException e) {
            if (!e.getMessage().equalsIgnoreCase("user.register.duplicateUserName")) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
