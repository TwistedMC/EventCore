package net.twistedmc.api.boosters;

public class NetworkBooster {

    private long endTime, startTime, endSeconds;
    private int multiplier;

    public NetworkBooster(long startTime, long endSeconds, long endTime, int multiplier) {
        this.startTime = startTime;
        this.endSeconds = endSeconds;
        this.endTime = endTime;
        this.multiplier = multiplier;
    }

    public NetworkBooster(long startTime, long endTime, int multiplier) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getEndSeconds() {
        return endSeconds;
    }

    public long getStartTime() {
        return startTime;
    }

}