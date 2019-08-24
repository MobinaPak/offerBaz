package ir.alzahra.offerBaz.notify;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author: hanieh Moafi
 * @Date: 8/3/2019
 **/
@Component
public class CustomSpringEvent implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher = null;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void notify(final String message, final NotificationType notificationType) {
        applicationEventPublisher.publishEvent(new CustomNotifyEvent(this, message, notificationType));
    }

    public void notify(final String message, final Object[] params,final NotificationType notificationType) {
        applicationEventPublisher.publishEvent(new CustomNotifyEvent(this, message, params, notificationType));
    }
}
