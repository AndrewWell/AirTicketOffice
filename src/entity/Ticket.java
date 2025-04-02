package entity;

public interface Ticket {
    String getDepartureDate();
    String getDepartureTime();
    String getDeparturePlace();
    String getArrivalPlace();
    int getTicketClassA();
    double getTicketPriceA();
    int getTicketClassB();
    double getTicketPriceB();
    int getTicketClassC();
    double getTicketPriceC();
}
