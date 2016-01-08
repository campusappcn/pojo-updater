package cn.campusapp.updater;

/**
 * Created by chen on 16/1/6.
 */
public interface Updater<T> {
    String CLASS_PREFIX = "$Updater";

    void update(T oldT, T newT);
}
