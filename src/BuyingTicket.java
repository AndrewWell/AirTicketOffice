import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BuyingTicket {
    private double markupCoefficient = 0.15;
    private double discount = 0.2;
    private DateTimeFormatter formatter;
    private LocalDate currentDate;
    private static final int MAJORITY = 18;
    private int hotTicket, coldTicket;

    /**
     * @param hotTicket  количество дней до вылета, при котором увеличивается цена билета
     * @param coldTicket количество дней до вылета, при котором выдается скидка на билет
     */
    public BuyingTicket(int hotTicket, int coldTicket) {
        this.hotTicket = hotTicket;
        this.coldTicket = coldTicket;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        currentDate = LocalDate.now();
    }
    public boolean isAdult(String birthDate) {
        return (getAge(birthDate) >= MAJORITY);
    }

    /**
     * Метод возвращающий цену билета в зависимости от даты преобретения
     * @param departureDate дата вылета
     * @param price цена билета без скидок и наценок
     * @return
     */
    public double getPriceTicket(String departureDate, double price) {
        if (hotTicket > getNumberOfDaysBeforeDeparture(departureDate))
            return getPremiumTicket(price);
        else if (coldTicket < getNumberOfDaysBeforeDeparture(departureDate))
            return getDiscountedTicket(price);
        return price;
    }

    /**
     * Метод получения цены билета со скидкой
     *
     * @param price
     * @return
     */
    private double getDiscountedTicket(double price) {
        return price - getPercentage(price, discount);
    }

    /**
     * Метод получения цены билета с наценкой
     *
     * @param price
     * @return
     */
    private double getPremiumTicket(double price) {
        return price + getPercentage(price, markupCoefficient);
    }

    private double getPercentage(double price, double coefficient) {
        return Math.round(price * coefficient);
    }


    /**
     * Метод для получения возраста на основании даты рождения и локальной даты
     *
     * @param birthDate
     * @return
     */
    private int getAge(String birthDate) {
        LocalDate localDate = LocalDate.parse(birthDate, formatter);
        return (int) ChronoUnit.YEARS.between(localDate, currentDate);
    }

    /**
     * Метод вывода информации о количестве дней до вылета
     *
     * @param departureDate дата вылета
     * @return
     */
    private int getNumberOfDaysBeforeDeparture(String departureDate) {
        return (int) ChronoUnit.DAYS.between(currentDate, LocalDate.parse(departureDate, formatter));
    }
}
