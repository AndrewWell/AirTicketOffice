import ratio.State;
import ratio.WorkingWithArrayList;
import variables.Flight;
import working_with_files.data_generation.GenerationManagement;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        GenerationManagement generationManagement = new GenerationManagement(10, 10, 15);
        generationManagement.generation();

        WorkingWithArrayList workingWithArrayList = new WorkingWithArrayList();
        State state = workingWithArrayList.getState();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        try {
            while (running) {
                System.out.println("\n1. Посмотреть списки доступных рейсов");
                System.out.println("2. Поиск рейсов вылетающих из пункта А");
                System.out.println("3. Поиск рейсов прибывающих в пункт Б");
                System.out.println("4. Поиск рейсов совершающие перелет между датой А и датой Б");
                System.out.println("5. Приобрести билет на рейс А");
                System.out.println("Для выхода из приложения нажмите 'q'");
                String choice = scanner.next();
                BuyingTicket buyingTicket = new BuyingTicket(5, 15);

                switch (choice) {
                    case ("1"):
                        System.out.println("\t\t\t\t=====Список рейсов=====");
                        for (Flight flight : state.getFlightArrayList()) {
                            System.out.println(flight);
                        }
                        break;
                    case ("2"):
                        System.out.println("Введите город вылета");
                        choice = scanner.next();
                        System.out.println("\nСписок самолетов вылетающих из " + choice);
                        for (int i = 0; i < state.getFlightArrayList().size(); i++) {
                            if (state.isPlaneTakesOffFromPointN(choice, i)) System.out.println(state.getFlight(i));
                        }
                        break;
                    case ("3"):
                        System.out.println("Введите город прибытия");
                        choice = scanner.next();
                        System.out.println("\nСписок самолетов совершающих посадку в " + choice);
                        for (int i = 0; i < state.getFlightArrayList().size(); i++) {
                            if (state.isPlaneLandsInPointN(choice, i)) System.out.println(state.getFlight(i));
                        }
                        break;
                    case ("4"):
                        System.out.println("Введите первую дату в формате 'yyyy-MM-dd'");
                        String firstDate = scanner.next();
                        System.out.println("Введите вторую дату в формате 'yyyy-MM-dd'");
                        String secondDate = scanner.next();
                        System.out.println("\nСписки рейсов совершающих перелет с " + firstDate + " по " + secondDate);
                        for (int i = 0; i < state.getFlightArrayList().size(); i++) {
                            if (state.isFlightsBetweenDates(firstDate, secondDate, i))
                                System.out.println(state.getFlight(i));
                        }
                        break;
                    case ("5"):
                        System.out.println("Для продолжение покупки билета необходимо ввести дату рождения в формате yyyy-MM-dd");
                        choice = scanner.next();
                        if (!buyingTicket.isAdult(choice)) {
                            System.out.println("Пассажир не достиг совершенолетия, покупка билета невозможна");
                            break;
                        }

                        System.out.println("\t\t\t\t=====Список рейсов=====");
                        for (int i = 0; i < state.getAirplaneArrayList().size(); i++) {
                            if (state.isAircraftInOperation(i)) System.out.println("[" + i + "] " + state.getFlight(i));
                        }
                        System.out.println("\nУкажите номер рейса");
                        int num = scanner.nextInt();
                        System.out.println("Был выбран рейс № " + num);
                        System.out.println(state.getAirplane(num));

                        System.out.println("На выбранный рейс есть слежующие места:\n" +
                                "Бизнес класс - " + state.getTicket(num).getTicketClassA() + " мест\n" +
                                "Эконом класс - " + state.getTicket(num).getTicketClassB() + " мест\n" +
                                "Туристический класс - " + state.getTicket(num).getTicketClassC() + " мест\n");


                        System.out.println("Какой класс билета Вы хотите приобрести?");
                        System.out.println("1. Бизнес класс");
                        System.out.println("2. Эконом класс");
                        System.out.println("3. Туристический класс");
                        int numSeat = scanner.nextInt();
                        if (numSeat == 1)
                            System.out.println("Цена билета составит: " + buyingTicket.getPriceTicket(state.getTicket(num).getDepartureDate(), state.getTicket(num).getTicketPriceA()));
                        else if (numSeat == 2)
                            System.out.println("Цена билета составит: " + buyingTicket.getPriceTicket(state.getTicket(num).getDepartureDate(), state.getTicket(num).getTicketPriceB()));
                        else if (numSeat == 3)
                            System.out.println("Цена билета составит: " + buyingTicket.getPriceTicket(state.getTicket(num).getDepartureDate(), state.getTicket(num).getTicketPriceC()));
                        break;
                    case ("q"):
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте еще раз.");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        scanner.close();
/*

        System.out.println("\nСписок рейсов совершающих маршрут: Москва - Казань");
        for (int i = 0; i < state.getFlightArrayList().size(); i++) {
            if ((state.isPlaneTakesOffFromPointN("Moscow", i)) && (state.isPlaneLandsInPointN("Kazan", i)))
                System.out.println(state.getFlight(i));
        }

        }
        System.out.println("\nСписки самолетов не выведенные из эксплуатации");
        for(int i=0;i<state.getAirplaneArrayList().size();i++){
            if(state.isAircraftInOperation(i)) System.out.println(state.getAirplane(i));
        }
 */

    }
}


