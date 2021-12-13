import java.util.ArrayList;
import java.util.List;

public class SeatFilter {
    private SeatReservationDao dao;

    public SeatFilter(SeatReservationDao dao) {
        this.dao = dao;
    }

//    public BankAccountFilter() {
//        this.dao = new BankAccountDao();
//    }

    public List<SeatReservation> filter() {

        List<SeatReservation> allAccounts = dao.all();

        List<SeatReservation> filtered = new ArrayList<>();

        for(SeatReservation seat : allAccounts) {
            if(seat.statusSeat(seat.getSeatNum()) == true)
                filtered.add(seat);
        }

        return filtered;

    }
}
