import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeatFilterTest {
    @Test
    void filterAccounts() {

        SeatReservation acct1 = new SeatReservation(1);
        SeatReservation acct2 = new SeatReservation(2);
        //SeatReservation acct3 = new SeatReservation(3);

        //BankAccountDao dao = new BankAccountDao();
        SeatReservationDao dao = Mockito.mock(SeatReservationDao.class);

        List<SeatReservation> results = Arrays.asList(acct1, acct2);
        Mockito.when(dao.all()).thenReturn(results);

        SeatFilter filter = new SeatFilter(dao);
        List<SeatReservation> result = filter.filter();

        Assertions.assertEquals(acct1, result.get(0));

        //Assertions.assertTrue(result.get(0) == acct1);
        Assertions.assertEquals(2, result.size());
    }

}