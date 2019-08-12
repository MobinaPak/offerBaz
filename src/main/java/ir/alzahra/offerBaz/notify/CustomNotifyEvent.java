package ir.alzahra.offerBaz.notify;

import org.springframework.context.ApplicationEvent;

/**
 * @author hanieh Moafi
 * @since 04/08/2019
 */
public class CustomNotifyEvent extends ApplicationEvent {

    private CustomEventParameters customEventParameters;

    public CustomNotifyEvent(final Object source, final String notification, final NotificationType notificationType) {
        super(source);
        customEventParameters = new CustomEventParameters();
        customEventParameters.setNotification(notification);
        customEventParameters.setNotificationType(notificationType);
    }

    public CustomEventParameters getCustomEventParameters() {
        return customEventParameters;
    }


}
