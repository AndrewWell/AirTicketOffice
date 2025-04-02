package entity;

public interface Baggage {

    String getDescription();//Описание груза
    double getWeight();//Вес груза
    String getDeparturePoint();//Пункт отправления
    String getDestination();//Пункт назначения
    String getFlightNum();//Номер рейса
    String getStatus();//Статус груза
}
