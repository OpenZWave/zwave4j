package org.zwave4j;

/**
 * @author zagumennikov
 */
public enum ControllerState {
    NORMAL,
    STARTING,
    CANCEL,
    ERROR,
    WAITING,
    SLEEPING,
    IN_PROGRESS,
    COMPLETED,
    FAILED,
    NODE_OK,
    NODE_FAILED,
    NOT_SUPPORTED
}
