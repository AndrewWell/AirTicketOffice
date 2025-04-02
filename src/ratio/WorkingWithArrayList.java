package ratio;

import working_with_files.ArrayTransformation;
import working_with_files.ReadingFile;

public class WorkingWithArrayList {
    private static final String CREW_FILE = "crew";
    private static final String AIRPLANE_FILE = "airplanes";
    private static final String FLIGHT_FILE = "flights";
    private static final String TICKET_FILE = "tickets";
    private ReadingFile readingFile;
    private ArrayTransformation arrayTransformation;
    private State state;

    public WorkingWithArrayList() {
        readingFile = new ReadingFile(CREW_FILE);
        arrayTransformation = new ArrayTransformation(readingFile.read());
        state = new State();
        fillingCrew();
        fillingAirplane();
        fillingFlight();
        fillingTicket();//TODO потом раскомить класс создания переменных
    }

    public State getState() {
        return state;
    }

    /**
     * Заполнение массива Crew из файла
     */
    protected void fillingCrew() {
        String[][] res = arrayTransformation.transformation();

        for (int i = 0; i < res.length; i++) {
            state.addCrew(res[i][0], res[i][1], Integer.parseInt(res[i][2]), res[i][3]);
        }
    }

    /**
     * Заполнение массива Airplane из файла
     */
    protected void fillingAirplane() {
        readingFile.setFileName(AIRPLANE_FILE);
        arrayTransformation.setData(readingFile.read());

        String[][] res = arrayTransformation.transformation();
        for (int i = 0; i < res.length; i++) {
            state.addAirplane(res[i][0], res[i][1], Integer.parseInt(res[i][2]), Integer.parseInt(res[i][3]),
                    Integer.parseInt(res[i][4]), Integer.parseInt(res[i][5]), res[i][6], res[i][7]);
        }
    }

    /**
     * Заполнение массива Flights из файла
     */
    protected void fillingFlight() {
        readingFile.setFileName(FLIGHT_FILE);
        arrayTransformation.setData(readingFile.read());

        String[][] res = arrayTransformation.transformation();
        for (int i = 0; i < res.length; i++) {
            state.addFlight(res[i][0], res[i][1], res[i][2], res[i][3], res[i][4], res[i][5], Integer.parseInt(res[i][6]));
        }
    }

    /**
     * Заполнение массива Tickets из файла
     */
    private void fillingTicket() {
        readingFile.setFileName(TICKET_FILE);
        arrayTransformation.setData(readingFile.read());

        String[][] res = arrayTransformation.transformation();
        for (int i = 0; i < res.length; i++) {
            state.addTicket(res[i][0], res[i][1], res[i][2], res[i][3], Integer.parseInt(res[i][4]), Double.parseDouble(res[i][5]),
                    Integer.parseInt(res[i][6]), Double.parseDouble(res[i][7]), Integer.parseInt(res[i][8]), Double.parseDouble(res[i][9]));
        }
    }

}
