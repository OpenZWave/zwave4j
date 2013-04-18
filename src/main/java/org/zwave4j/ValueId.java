package org.zwave4j;

import java.math.BigInteger;

/**
 * @author zagumennikov
 */
public class ValueId {

    private long homeId;
    private short nodeId;
    private ValueGenre genre;
    private short commandClassId;
    private short instance;
    private short index;
    private ValueType type;
    private long id;

    public ValueId(long homeId, short nodeId, ValueGenre genre, short commandClassId, short instance, short index, ValueType type, long id) {
        this.homeId = homeId;
        this.nodeId = nodeId;
        this.genre = genre;
        this.commandClassId = commandClassId;
        this.instance = instance;
        this.index = index;
        this.type = type;
        this.id = id;
    }

    public long getHomeId() {
        return homeId;
    }

    public short getNodeId() {
        return nodeId;
    }

    public ValueGenre getGenre() {
        return genre;
    }

    public short getCommandClassId() {
        return commandClassId;
    }

    public short getInstance() {
        return instance;
    }

    public short getIndex() {
        return index;
    }

    public ValueType getType(){
        return type;
    }

    public long getId() {
        return id;
    }
}
