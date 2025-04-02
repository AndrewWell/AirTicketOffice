package working_with_files.data_generation;

import variables.Flight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightGenerator {
    private int numberOfFlightGen;
    private static final String[] AIRCRAFT_TYPES = {
            "Boeing 737",
            "Airbus A320",
            "Embraer 190",
            "Bombardier Q400"
    };
    private static final String[] LOCATIONS = {
            "Moscow",
            "St. Petersburg",
            "Severomorsk",
            "Uralsk",
            "Kazan"
    };
    private static final String FLIGHT_FILE = "flights";

    public FlightGenerator(int numberOfFlightGen) {
        this.numberOfFlightGen = numberOfFlightGen;
    }

    public void generation() {
        List<Flight> flights = generateFlights(numberOfFlightGen);
        writeFlightsToFile(flights, FLIGHT_FILE + ".txt");
    }

    private static List<Flight> generateFlights(int count) {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < count; i++) {
            String aircraftType = AIRCRAFT_TYPES[random.nextInt(AIRCRAFT_TYPES.length)];
            String departureDate = LocalDateTime.now().plusDays(random.nextInt(30)).format(dateFormatter);
            String departureTime = LocalDateTime.now().plusHours(random.nextInt(24)).format(timeFormatter);
            String arrivalTime = LocalDateTime.now().plusHours(random.nextInt(24) + 1).format(timeFormatter); // +1 для времени прибытия
            String departureLocation = LOCATIONS[random.nextInt(LOCATIONS.length)];
            int distance = random.nextInt(9901)+350;
            String arrivalLocation;
            do {
                arrivalLocation = LOCATIONS[random.nextInt(LOCATIONS.length)];
            } while (arrivalLocation.equals(departureLocation)); // Убедимся, что место прилета не совпадает с местом вылета

            flights.add(new Flight(aircraftType, departureDate, departureTime, arrivalTime, departureLocation, arrivalLocation, distance));
        }
        return flights;
    }

    private static void writeFlightsToFile(List<Flight> flights, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Flight flight : flights) {
                writer.write(flight.toString());
                writer.newLine();
            }
            System.out.println("Данные успешно записаны в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

}
