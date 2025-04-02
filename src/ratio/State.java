package ratio;

import entity.Aircraft;
import entity.Ticket;
import variables.Airplane;
import variables.CrewMember;
import variables.Flight;
import variables.Tickets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Класс для хранения данных
 */
public class State {
    private ArrayList<CrewMember> crewArrayList;
    private ArrayList<Airplane> airplaneArrayList;
    private ArrayList<Flight> flightArrayList;
    private ArrayList<Ticket> ticketArrayList;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public State() {
        crewArrayList = new ArrayList<CrewMember>();
        airplaneArrayList = new ArrayList<Airplane>();
        flightArrayList = new ArrayList<Flight>();
        ticketArrayList = new ArrayList<Ticket>();
    }

    /**
     * Добавление в динамический массив
     *
     * @param fullName      ФИО сотрудника
     * @param licenseNumber номер лицензии
     * @param flightHours   налетано часов
     * @param jobTitle      должность
     * @return Вывод булевого значения о состоянии записи данных
     */
    public boolean addCrew(String fullName, String licenseNumber, int flightHours, String jobTitle) {
        return crewArrayList.add(new CrewMember(fullName, licenseNumber, flightHours, jobTitle));
    }

    /**
     * Получение данных записанных в массиве на основании запрошенного индекса
     *
     * @param index Порядковый номер в массиве
     * @return
     */
    public CrewMember getCrew(int index) {
        return crewArrayList.get(index);
    }

    /**
     * Поиск по массиву "Crew" необходимый массив на основе лицензии сотрудника
     *
     * @param licenseNumber
     * @return
     */
    public int findIndexByLicenseCrew(String licenseNumber) {
        for (int i = 0; i < crewArrayList.size(); i++) {
            if (crewArrayList.get(i).getLicenseNumber().equals(licenseNumber))
                return i;
        }
        return -1;
    }

    /**
     * Добавление данных о воздушных суднах в динамический массив
     *
     * @param model              модель
     * @param manufacturer       производитель
     * @param yearOfManufacturer год выпуска
     * @param passengerCapacity  посадочных мест
     * @param crewMembers        необходимое количество экипажа (2 - летный экипаж)
     * @param baggageCapacity    грузоподъемность (в багажном отделении)
     * @param regNum             регистраицонный номер воздушного судна
     * @param techCondition      техническое состояние воздвушного судна
     * @return
     */
    public boolean addAirplane(String model, String manufacturer, int yearOfManufacturer,
                               int passengerCapacity, int crewMembers, int baggageCapacity, String regNum, String techCondition) {
        return airplaneArrayList.add(new Airplane(model, manufacturer, yearOfManufacturer, passengerCapacity, crewMembers,
                baggageCapacity, regNum, techCondition));
    }

    public Aircraft getAirplane(int index) {
        return airplaneArrayList.get(index);
    }

    /**
     * Поиск по массиву "Airplane" необходимый массив на основе регистрационного номера воздушного судна
     *
     * @param regNum
     * @return
     */
    public int findIndexByRegNumAirplane(String regNum) {
        for (int i = 0; i < airplaneArrayList.size(); i++) {
            if (airplaneArrayList.get(i).getRegNum().equals(regNum))
                return i;
        }
        return -1;
    }

    /**
     * Добавить данные о рейсах воздушных судов в динамический массив
     *
     * @param aircraftType      тип самолета
     * @param departureDate     дата отправления
     * @param departureTime     время отправления
     * @param arrivalTime       время прибытия
     * @param departureLocation место отправления
     * @param arrivalLocation   место прибытия
     * @param distance          расстояние
     * @return
     */
    public boolean addFlight(String aircraftType, String departureDate, String departureTime, String arrivalTime,
                             String departureLocation, String arrivalLocation, int distance) {
        return flightArrayList.add(new Flight(aircraftType, departureDate, departureTime, arrivalTime, departureLocation, arrivalLocation, distance));
    }

    /**
     * Добавить данные о билетах на рейсы воздушных судов в динамический массив
     *
     * @param departureDate  дата вылета
     * @param departureTime  время вылета
     * @param departurePlace место вылета
     * @param arrivalPlace   место прибытия
     * @param ticketClassA   количество мест в классе А
     * @param ticketPriceA   цена билета в класс А
     * @param ticketClassB   количество мест в классе Б
     * @param ticketPriceB   цена билета в классе Б
     * @param ticketClassC   количество мест в классе С
     * @param ticketPriceC   цена билета в классе С
     * @return
     */
    public boolean addTicket(String departureDate, String departureTime, String departurePlace, String arrivalPlace,
                             int ticketClassA, double ticketPriceA, int ticketClassB, double ticketPriceB, int ticketClassC, double ticketPriceC) {
        return ticketArrayList.add(new Tickets(departureDate, departureTime, departurePlace, arrivalPlace, ticketClassA, ticketPriceA, ticketClassB, ticketPriceB, ticketClassC, ticketPriceC));
    }

    public Ticket getTicket(int index) {
        return ticketArrayList.get(index);
    }

    /**
     * Поиск индекс массива по модели самолета
     *
     * @param model
     * @return
     */
    public int findIndexByModelAirplane(String model) {
        for (int i = 0; i < airplaneArrayList.size(); i++) {
            if (airplaneArrayList.get(i).getModel().equals(model))
                return i;
        }
        return -1;
    }

    /**
     * Проверка на взлет самолета с указанного города
     *
     * @param pointN город взлета
     * @param index  порядковый номер массива в списке заплонированных рейсов
     * @return
     */
    public boolean isPlaneTakesOffFromPointN(String pointN, int index) {
        return getFlight(index).getDepartureLocation().equals(pointN);
    }

    /**
     * Проверка на место пасадки самолета
     *
     * @param pointN город посадки
     * @param index  порядковый номер массива в списке запланированных рейсов
     * @return
     */
    public boolean isPlaneLandsInPointN(String pointN, int index) {
        return getFlight(index).getArrivalLocation().equals(pointN);
    }

    /**
     * Проверка самолета на перелет в указанные даты
     *
     * @param startDate дата начала
     * @param endDate   дата окончания
     * @param index     порядковый номер массива в списке запланированных рейсов
     * @return
     */
    public boolean isFlightsBetweenDates(String startDate, String endDate, int index) {
        LocalDate startDateF = LocalDate.parse(startDate, formatter);
        LocalDate endDateF = LocalDate.parse(endDate, formatter);
        LocalDate dateInArray = LocalDate.parse(getFlight(index).getDepartureDate());

        return (dateInArray.isEqual(startDateF) || dateInArray.isAfter(startDateF))
                && (dateInArray.isEqual(endDateF) || dateInArray.isBefore(endDateF));
    }

    /**
     * Проверка на тех.состояние самолета
     *
     * @param index порядковый номер массива в списке авиопарка
     * @return
     */
    public boolean isAircraftInOperation(int index) {
        return !(getAirplane(index).getTechCondition().equals("Decommissioned"));
    }

    public int getNumberOfClassASeats(int index) {
        return getTicket(index).getTicketClassA();
    }

    public double getOriginalCostOfClassA(int index) {
        return getTicket(index).getTicketPriceA();
    }

    public int getNumberOfClassBSeats(int index) {
        return getTicket(index).getTicketClassB();
    }

    public double getOriginalCostOfClassB(int index) {
        return getTicket(index).getTicketPriceB();
    }

    public int getNumberOfClassCSeats(int index) {
        return getTicket(index).getTicketClassC();
    }

    public double getOriginalCostOfClassC(int index) {
        return getTicket(index).getTicketPriceC();
    }

    public Flight getFlight(int index) {
        return flightArrayList.get(index);
    }

    public ArrayList<CrewMember> getCrewArrayList() {
        return crewArrayList;
    }

    public ArrayList<Airplane> getAirplaneArrayList() {
        return airplaneArrayList;
    }

    public ArrayList<Flight> getFlightArrayList() {
        return flightArrayList;
    }

    public ArrayList<Ticket> getTicketArrayList() {
        return ticketArrayList;
    }
}
