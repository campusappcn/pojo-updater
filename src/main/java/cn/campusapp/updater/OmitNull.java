package cn.campusapp.updater;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Indicates the annotated field will not receive a null value
 * Created by chen on 16/1/6.
 */
@Target(ElementType.FIELD)
public @interface OmitNull {
}
