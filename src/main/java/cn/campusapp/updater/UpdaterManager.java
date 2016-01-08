package cn.campusapp.updater;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by chen on 16/1/7.
 */
public interface UpdaterManager {
    <T> Updater<T> getUpdater(Class<T> tClass);

    @Target(ElementType.TYPE)
    @interface ManagedUpdater {
        Class<?> value();
    }
}
