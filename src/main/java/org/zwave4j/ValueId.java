/*
 * Copyright (c) 2013 Alexander Zagumennikov
 *
 * SOFTWARE NOTICE AND LICENSE
 *
 * This file is part of ZWave4J.
 *
 * ZWave4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ZWave4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ZWave4J.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.zwave4j;

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

    public ValueId(long homeId, short nodeId, ValueGenre genre, short commandClassId, short instance, short index, ValueType type) {
        this.homeId = homeId;
        this.nodeId = nodeId;
        this.genre = genre;
        this.commandClassId = commandClassId;
        this.instance = instance;
        this.index = index;
        this.type = type;
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
}
