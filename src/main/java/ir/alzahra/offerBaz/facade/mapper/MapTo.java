package ir.alzahra.offerBaz.facade.mapper;

import java.lang.annotation.*;

/**
 * @Author: hanieh Moafi
 * @Date: 5/24/2019
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MapTo {
    Class targetEntity() default void.class;

}
