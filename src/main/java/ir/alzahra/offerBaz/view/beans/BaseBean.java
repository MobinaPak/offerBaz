package ir.alzahra.offerBaz.view.beans;

import ir.alzahra.offerBaz.notify.CustomEventParameters;
import ir.alzahra.offerBaz.notify.CustomSpringEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Locale;


/**
 * @author hanieh Moafi
 * @since 04/08/2019
 */
@Component("baseBean")
public class BaseBean {


    @Autowired
    protected CustomSpringEventListener customSpringEventListener;

    private static ApplicationContext context;
    private final static String defaultMsg = "خطای سیستمی رخ داده است.";

    @Autowired
    private ApplicationContext tempContext;

   @PostConstruct
    public void init() {
        this.context = tempContext;
    }

    public void addNotificationMessage() {

        CustomEventParameters customEventParameters = getCustomEventParameters();
        if (customEventParameters == null) return;
        String message = show(customEventParameters.getNotification());

        switch (customEventParameters.getNotificationType()) {
            case Nothing:
            case Info:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,message, ""));
                break;
            case Warning:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, ""));
                break;
        }
    }




    protected CustomEventParameters getCustomEventParameters() {
        int size=customSpringEventListener.getCustomEventParameters().size();
        CustomEventParameters customEventParameters = customSpringEventListener.getCustomEventParameters().get(0);
        customSpringEventListener.getCustomEventParameters().remove(0);
        return customEventParameters;
    }


    public static String show(String msgCode) {
        Object[] f = new Object[10];
        return context.getMessage(msgCode, f,defaultMsg, Locale.ENGLISH);

    }


}
