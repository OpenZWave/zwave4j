package org.zwave4j;

/**
 * @author zagumennikov
 */
public interface ControllerCallback {

    void onCallback(ControllerState state, ControllerError err, Object context);
}
