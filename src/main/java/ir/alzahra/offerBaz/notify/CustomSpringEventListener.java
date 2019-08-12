package ir.alzahra.offerBaz.notify;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hanieh Moafi
 * @Date: 8/3/2019
 **/
@Component
public class CustomSpringEventListener implements ApplicationListener<CustomNotifyEvent> {

    private List<CustomEventParameters> customEventParameters=new ArrayList<>();

    @Override
    public void onApplicationEvent(CustomNotifyEvent customNotifyEvent) {
        customEventParameters.add(customNotifyEvent.getCustomEventParameters());
    }

    public List<CustomEventParameters> getCustomEventParameters() {
        return customEventParameters;
    }

}
