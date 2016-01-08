package cn.campusapp.updater;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Require generating companion updater class for the annotated class
 * Created by chen on 16/1/6.
 */
@Target(ElementType.TYPE)
public @interface Updatable {
}
