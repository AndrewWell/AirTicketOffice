package variables;

public class Flight implements entity.Flight {
    private String aircraftType, departureTime, arrivalTime, departureLocation, arrivalLocation, departureDate;
    private int distance;

    public Flight(String aircraftType, String departureDate, String departureTime, String arrivalTime, String departureLocation, String arrivalLocation, int distance) {
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return aircraftType + "|" + departureDate + "|" + departureTime + "|" + arrivalTime + "|" + departureLocation + "|" + arrivalLocation + "|" + distance;
    }

    @Override
    public String getAircraftType() {
        return aircraftType;
    }

    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String getDepartureLocation() {
        return departureLocation;
    }

    @Override
    public String getArrivalLocation() {
        return arrivalLocation;
    }

    @Override
    public int getDistance() {
        return distance;
    }
}
