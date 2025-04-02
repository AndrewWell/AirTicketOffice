package working_with_files.data_generation;

public class GenerationManagement {
    private CrewGenerator crewGenerator;
    private AirplaneGenerator airplaneGenerators;
    private FlightGenerator flightGenerator;
    private TicketPriceGenerator ticketPriceGenerator;
    private int numberOfGeneratedCrews, numberOfGeneratedAircraft, numberGeneratedFlights;

    public GenerationManagement(int numberOfGeneratedCrews, int numberOfGeneratedAircraft, int numberGeneratedFlights) {
        this.numberOfGeneratedCrews = numberOfGeneratedCrews;
        this.numberOfGeneratedAircraft = numberOfGeneratedAircraft;
        this.numberGeneratedFlights = numberGeneratedFlights;
    }

    public void generation() {
        if (checkGeneration(numberOfGeneratedCrews)) {
            crewGenerator = new CrewGenerator(numberOfGeneratedCrews);
            crewGenerator.generation();
        }
        if (checkGeneration(numberOfGeneratedAircraft)) {
            airplaneGenerators = new AirplaneGenerator(numberOfGeneratedAircraft);
            airplaneGenerators.generation();
        }
        if (checkGeneration(numberGeneratedFlights)) {
            flightGenerator = new FlightGenerator(numberGeneratedFlights);
            flightGenerator.generation();
        }
        if (numberGeneratedFlights > 0 && numberOfGeneratedAircraft > 0) {
            ticketPriceGenerator = new TicketPriceGenerator();
            ticketPriceGenerator.generation();

        }
    }

    private boolean checkGeneration(int numLineGeneration) {
        if (numLineGeneration < 1) {
            return false;
        }
        return true;
    }
}
