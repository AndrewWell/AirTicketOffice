package variables;

import entity.Ticket;

public class Tickets implements Ticket {
    private String departureDate, departureTime, departurePlace, arrivalPlace;
    private int ticketClassA, ticketClassB, ticketClassC;
    private double ticketPriceA, ticketPriceB, ticketPriceC;

    public Tickets(String departureDate, String departureTime, String departurePlace,
                   String arrivalPlace, int ticketClassA, double ticketPriceA, int ticketClassB,
                   double ticketPriceB, int ticketClassC, double ticketPriceC) {
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.ticketClassA = ticketClassA;
        this.ticketClassB = ticketClassB;
        this.ticketClassC = ticketClassC;
        this.ticketPriceA = ticketPriceA;
        this.ticketPriceB = ticketPriceB;
        this.ticketPriceC = ticketPriceC;
    }

    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String getDeparturePlace() {
        return departurePlace;
    }

    @Override
    public String getArrivalPlace() {
        return arrivalPlace;
    }

    @Override
    public int getTicketClassA() {
        return ticketClassA;
    }

    @Override
    public double getTicketPriceA() {
        return ticketPriceA;
    }

    @Override
    public int getTicketClassB() {
        return ticketClassB;
    }

    @Override
    public double getTicketPriceB() {
        return ticketPriceB;
    }

    @Override
    public int getTicketClassC() {
        return ticketClassC;
    }

    @Override
    public double getTicketPriceC() {
        return ticketPriceC;
    }

    @Override
    public String toString() {
        return departureDate + "|" + departureTime + "|" + departurePlace + "|" + arrivalPlace + "|" + ticketClassA +
                "|" + ticketPriceA + "|" + ticketClassB + "|" + ticketPriceB + "|" + ticketClassC + "|" + ticketPriceC;
    }
}
