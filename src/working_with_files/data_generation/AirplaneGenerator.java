package working_with_files.data_generation;

import variables.Airplane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AirplaneGenerator {
    private int numberOfAirplaneGen;
    private static final String[] MODELS = {
            "Boeing 737",
            "Airbus A320",
            "Embraer 190",
            "Bombardier Q400"
    };
    private static final String[] MANUFACTURERS = {
            "Boeing",
            "Airbus",
            "Embraer",
            "Bombardier"
    };
    private static final String[] CONDITIONS = {
            "Operation",
            "Maintenance",
            "Decommissioned"
    };
    private static final String AIRPLANE_FILE = "airplanes";

    public AirplaneGenerator(int numberOfAirplaneGen) {
        this.numberOfAirplaneGen = numberOfAirplaneGen;
    }

    public void generation() {
        List<Airplane> airplanes = generateAirplanes(numberOfAirplaneGen);
        writeAirplanesToFile(airplanes, AIRPLANE_FILE + ".txt");
    }

    private static List<Airplane> generateAirplanes(int count) {
        List<Airplane> airplanes = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String model = MODELS[random.nextInt(MODELS.length)];
            String manufacturer = MANUFACTURERS[random.nextInt(MANUFACTURERS.length)];
            int yearOfManufacture = 2000 + random.nextInt(23); // 2000 to 2023
            int passengerCapacity = 50 + random.nextInt(300); // 50 to 350
            int crewMembers = 3 + random.nextInt(6); // 3 to 6
            int baggageCapacity = 500 + random.nextInt(5000); // 500 to 5500 kg
            String registrationNumber = "REG-" + (1000 + random.nextInt(9000));
            String technicalCondition = CONDITIONS[random.nextInt(CONDITIONS.length)];

            airplanes.add(new Airplane(model, manufacturer, yearOfManufacture, passengerCapacity,
                    crewMembers, baggageCapacity, registrationNumber, technicalCondition));
        }

        return airplanes;
    }

    private static void writeAirplanesToFile(List<Airplane> airplanes, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Airplane airplane : airplanes) {
                writer.write(airplane.toString());
                writer.newLine();
            }
            System.out.println("Список самолетов успешно записан в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
