package Model;

public class Flight {
    private final int dayOfWeek, depTime, depDelay, arrTime, arrDelay, cancelled, diverted, airTime, distance;

    public Flight(int dayOfWeek, int depTime, int depDelay, int arrTime, int arrDelay, int cancelled, int diverted, int airTime, int distance) {
        this.dayOfWeek = dayOfWeek;
        this.depTime = depTime;
        this.depDelay = depDelay;
        this.arrTime = arrTime;
        this.arrDelay = arrDelay;
        this.cancelled = cancelled;
        this.diverted = diverted;
        this.airTime = airTime;
        this.distance = distance;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDepTime() {
        return depTime;
    }

    public int getDepDelay() {
        return depDelay;
    }

    public int getArrTime() {
        return arrTime;
    }

    public int getArrDelay() {
        return arrDelay;
    }

    public int getCancelled() {
        return cancelled;
    }

    public int getDiverted() {
        return diverted;
    }

    public int getAirTime() {
        return airTime;
    }

    public int getDistance() {
        return distance;
    }    
}