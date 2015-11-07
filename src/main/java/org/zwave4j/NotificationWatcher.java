package org.zwave4j;

/**
 * @author zagumennikov
 */
public interface NotificationWatcher {

    void onNotification(Notification notification, Object context);
}
