package ir.alzahra.offerBaz.view.beans;

import ir.alzahra.offerBaz.exception.BaseException;
import ir.alzahra.offerBaz.notify.CustomEventParameters;
import ir.alzahra.offerBaz.notify.CustomSpringEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;


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
        context = tempContext;
    }

    public void addNotificationMessage() {

        CustomEventParameters customEventParameters = getCustomEventParameters();
        if (customEventParameters == null) return;
        String message = show(customEventParameters.getNotification(),customEventParameters.getParams());

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
       if (customSpringEventListener.getCustomEventParameters().size()!=0) {
           int index=customSpringEventListener.getCustomEventParameters().size()-1;
           CustomEventParameters customEventParameters = customSpringEventListener.getCustomEventParameters().get(index);
           customSpringEventListener.getCustomEventParameters().clear();
           return customEventParameters;
       }else {
           new CustomEventParameters();

       }
       return null;

    }


    public static String show(String msgCode,Object[] params) {
        if (Objects.nonNull(params) && params.length>0){
            for (int i = 0; i < params.length; i++) {
                if (!(params[i] instanceof BigDecimal) && !(params[0].getClass().getName().contains("alzahra")))
                    params[i] = params[i].toString();
            }

        }
        return context.getMessage(msgCode, params,defaultMsg, Locale.ENGLISH);

    }


    public void handleBaseException(Throwable throwable) {
        Throwable cause = throwable.getCause();

        if (cause instanceof AccessDeniedException) {
            cause.printStackTrace();
        } else if (throwable instanceof BaseException) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, show(throwable.getMessage(), new Object[0]), ""));

        }
    }


}
