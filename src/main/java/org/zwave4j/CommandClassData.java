package org.zwave4j;

/**
 * @author zagumennikov
 */
public class CommandClassData {

    private short commandClassId;
    private long sentCnt;
    private long receivedCnt;

    public CommandClassData(short commandClassId, long sentCnt, long receivedCnt) {
        this.commandClassId = commandClassId;
        this.sentCnt = sentCnt;
        this.receivedCnt = receivedCnt;
    }

    public short getCommandClassId() {
        return commandClassId;
    }

    public long getSentCnt() {
        return sentCnt;
    }

    public long getReceivedCnt() {
        return receivedCnt;
    }
}
