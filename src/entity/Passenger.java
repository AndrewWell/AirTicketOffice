package entity;

import java.time.LocalDateTime;

public interface Passenger {
    String getFullName();
    LocalDateTime getRegistrationTime();
    String getTicketNum();
    int getAge();
}
