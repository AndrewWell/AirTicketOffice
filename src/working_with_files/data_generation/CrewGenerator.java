package working_with_files.data_generation;


import variables.CrewMember;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrewGenerator {
    private int numberOfEmployGen;
    public static final String[] JOB_TITLE = {
            "Captain",
            "Second Pilot",
            "Cabin Crew",
            "Lead Cabin Crew"
    };
    private static final String[] NAMES = {
            "Ivanov Ivan",
            "Petrov Maksim",
            "Florov Alexey",
            "Simonov Andrey",
            "Zaharov Sergey"
    };
    private static final String CREW_FILE = "crew";

    public CrewGenerator(int numberOfEmployGen) {
        this.numberOfEmployGen = numberOfEmployGen;
    }

    public void generation() {
        List<CrewMember> crewMembers = generateCrew(numberOfEmployGen);
        writeCrewToFile(crewMembers, CREW_FILE + ".txt");
    }

    private static final Random RANDOM = new Random();

    private static List<CrewMember> generateCrew(int count) {
        List<CrewMember> crewMembers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String fullName = NAMES[RANDOM.nextInt(NAMES.length)];
            String licenseNumber = "LIC" + (1000 + i); // Пример номера лицензии
            int flightHours = RANDOM.nextInt(1000); // Случайное количество летных часов
            String position = JOB_TITLE[RANDOM.nextInt(JOB_TITLE.length)];
            crewMembers.add(new CrewMember(fullName, licenseNumber, flightHours, position));
        }
        return crewMembers;
    }

    private static void writeCrewToFile(List<CrewMember> crewMembers, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (CrewMember member : crewMembers) {
                writer.write(member.toString());
                writer.newLine();
            }
            System.out.println("Список экипажа успешно записан в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
