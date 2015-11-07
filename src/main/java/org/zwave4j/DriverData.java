package org.zwave4j;

/**
 * @author zagumennikov
 */
public class DriverData {
    
    private long sofCnt;			
    private long ackWaiting;			
    private long readAborts;			
    private long badChecksum;			
    private long readCnt;			
    private long writeCnt;			
    private long canCnt;			
    private long nakCnt;			
    private long ackCnt;			
    private long oofCnt;			
    private long dropped;			
    private long retries;			
    private long callbacks;			
    private long badRoutes;			
    private long noAck;				
    private long netBusy;			
    private long notIdle;
    private long nondelivery;			
    private long routedBusy;			
    private long broadcastReadCnt;		
    private long broadcastWriteCnt;

    public long getSofCnt() {
        return sofCnt;
    }

    public void setSofCnt(long sofCnt) {
        this.sofCnt = sofCnt;
    }

    public long getAckWaiting() {
        return ackWaiting;
    }

    public void setAckWaiting(long ackWaiting) {
        this.ackWaiting = ackWaiting;
    }

    public long getReadAborts() {
        return readAborts;
    }

    public void setReadAborts(long readAborts) {
        this.readAborts = readAborts;
    }

    public long getBadChecksum() {
        return badChecksum;
    }

    public void setBadChecksum(long badChecksum) {
        this.badChecksum = badChecksum;
    }

    public long getReadCnt() {
        return readCnt;
    }

    public void setReadCnt(long readCnt) {
        this.readCnt = readCnt;
    }

    public long getWriteCnt() {
        return writeCnt;
    }

    public void setWriteCnt(long writeCnt) {
        this.writeCnt = writeCnt;
    }

    public long getCanCnt() {
        return canCnt;
    }

    public void setCanCnt(long canCnt) {
        this.canCnt = canCnt;
    }

    public long getNakCnt() {
        return nakCnt;
    }

    public void setNakCnt(long nakCnt) {
        this.nakCnt = nakCnt;
    }

    public long getAckCnt() {
        return ackCnt;
    }

    public void setAckCnt(long ackCnt) {
        this.ackCnt = ackCnt;
    }

    public long getOofCnt() {
        return oofCnt;
    }

    public void setOofCnt(long oofCnt) {
        this.oofCnt = oofCnt;
    }

    public long getDropped() {
        return dropped;
    }

    public void setDropped(long dropped) {
        this.dropped = dropped;
    }

    public long getRetries() {
        return retries;
    }

    public void setRetries(long retries) {
        this.retries = retries;
    }

    public long getCallbacks() {
        return callbacks;
    }

    public void setCallbacks(long callbacks) {
        this.callbacks = callbacks;
    }

    public long getBadRoutes() {
        return badRoutes;
    }

    public void setBadRoutes(long badRoutes) {
        this.badRoutes = badRoutes;
    }

    public long getNoAck() {
        return noAck;
    }

    public void setNoAck(long noAck) {
        this.noAck = noAck;
    }

    public long getNetBusy() {
        return netBusy;
    }

    public void setNetBusy(long netBusy) {
        this.netBusy = netBusy;
    }

    public long getNotIdle() {
        return notIdle;
    }

    public void setNotIdle(long notIdle) {
        this.notIdle = notIdle;
    }

    public long getNondelivery() {
        return nondelivery;
    }

    public void setNondelivery(long nondelivery) {
        this.nondelivery = nondelivery;
    }

    public long getRoutedBusy() {
        return routedBusy;
    }

    public void setRoutedBusy(long routedBusy) {
        this.routedBusy = routedBusy;
    }

    public long getBroadcastReadCnt() {
        return broadcastReadCnt;
    }

    public void setBroadcastReadCnt(long broadcastReadCnt) {
        this.broadcastReadCnt = broadcastReadCnt;
    }

    public long getBroadcastWriteCnt() {
        return broadcastWriteCnt;
    }

    public void setBroadcastWriteCnt(long broadcastWriteCnt) {
        this.broadcastWriteCnt = broadcastWriteCnt;
    }
}
