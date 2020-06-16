import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReservationManager {
    // Session persistance
    List<Reservation> reservations;
    List<Table> tables;
    Set<Customer> customers;

    private static ReservationManager INSTANCE;

    private ReservationManager(){
        customers = new HashSet<>();
        init();
    }

    public ReservationManager getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ReservationManager();
        return INSTANCE;
        // if this code is in the server every new instance is a new session
    }
    private void init() {
        reservations = new ArrayList<>();
        tables = new ArrayList<>();
    }
}

class Reservation {

}

class Customer {

}

class Table {

}