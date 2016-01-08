package cn.campusapp.updater;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Indicates that the updater should not take care of this field
 * Created by chen on 16/1/7.
 */
@Target(ElementType.FIELD)
public @interface Skip {
}
