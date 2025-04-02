package working_with_files.data_generation;

import entity.Ticket;
import ratio.State;
import ratio.WorkingWithArrayList;
import variables.Tickets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketPriceGenerator extends WorkingWithArrayList {
    private static final String TICKET_FILE = "tickets";

    private static State state;

    private int numberOfTicketGen;

    public TicketPriceGenerator() {
        this.state = getState();
        this.numberOfTicketGen = state.getAirplaneArrayList().size();
    }

    public void generation() {
        List<Ticket> tickets = generationTicket(numberOfTicketGen);
        writeTicketToFile(tickets, TICKET_FILE + ".txt");
    }

    public static List<Ticket> generationTicket(int count) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String departureDate = state.getFlight(i).getDepartureDate();
            String departureTime = state.getFlight(i).getDepartureTime();
            String departurePlace = state.getFlight(i).getDepartureLocation();
            String arrivalPlace = state.getFlight(i).getArrivalLocation();
            int ticketClassA = getNumberOfSeats(1, state.getAirplane(i).getPassengerCapacity());
            double ticketPriceA = getTicketPrice(1, state.getFlight(i).getDistance());
            int ticketClassB = getNumberOfSeats(2, state.getAirplane(i).getPassengerCapacity());
            double ticketPriceB = getTicketPrice(2, state.getFlight(i).getDistance());
            int ticketClassC = getNumberOfSeats(3, state.getAirplane(i).getPassengerCapacity());
            double ticketPriceC = getTicketPrice(3, state.getFlight(i).getDistance());
            tickets.add(new Tickets(departureDate, departureTime, departurePlace, arrivalPlace, ticketClassA,
                    ticketPriceA, ticketClassB, ticketPriceB, ticketClassC, ticketPriceC));
        }
        return tickets;
    }

    private static int getNumberOfSeats(int seatClass, int numberOfSeatsPlane) {
        switch (seatClass) {
            case (1):
                return (int) (numberOfSeatsPlane * 0.15);
            case (2):
                return (int) (numberOfSeatsPlane * 0.25);
            case (3):
                return (int) (numberOfSeatsPlane * 0.6);
            default:
                return -1;
        }
    }

    private static double getTicketPrice(int seatClass, int distance) {
        int ticketCoefficient = 35;
        switch (seatClass) {
            case (1):
                return Math.round(ticketCoefficient * distance * 0.3);
            case (2):
                return Math.round(ticketCoefficient * distance * 0.18);
            case (3):
                return Math.round(ticketCoefficient * distance * 0.1);
            default:
                return -1;
        }
    }

    private static void writeTicketToFile(List<Ticket> tickets, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Ticket ticket : tickets) {
                writer.write(ticket.toString());
                writer.newLine();
            }
            System.out.println("Список билетов успешно записан в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
