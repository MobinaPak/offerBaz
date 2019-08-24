package ir.alzahra.offerBaz.notify;

import java.io.Serializable;

/**
 * @author hanieh Moafi
 * @since 04/08/2019
 */
public class CustomEventParameters implements Serializable {

    private String notification;
    private NotificationType notificationType;
    private Object[] params;




    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
