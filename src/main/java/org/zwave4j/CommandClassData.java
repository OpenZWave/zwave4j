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
public class CommandClassData {

    private long commandClassId;
    private long sentCnt;
    private long receivedCnt;

    public CommandClassData(long commandClassId, long sentCnt, long receivedCnt) {
        this.commandClassId = commandClassId;
        this.sentCnt = sentCnt;
        this.receivedCnt = receivedCnt;
    }

    public long getCommandClassId() {
        return commandClassId;
    }

    public long getSentCnt() {
        return sentCnt;
    }

    public long getReceivedCnt() {
        return receivedCnt;
    }
}
