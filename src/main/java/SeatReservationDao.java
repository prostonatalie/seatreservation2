import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatReservationDao {
    private static Connection c;

    public SeatReservationDao() {
        try {
            if(c!=null) return;

            c = DriverManager.getConnection("jdbc:hsqldb:file:mymemdb.db", "SA", "");
            c.prepareStatement("create table bankaccount (acctNum int, balance int, lastTransaction int)").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SeatReservation> all() {

        List<SeatReservation> allAccounts = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement("select * from bankaccount");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int seatNum = rs.getInt("seatNum");
                //boolean openSeat = rs.getBoolean("openSeat");
                allAccounts.add(new SeatReservation(seatNum));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return allAccounts;
        }

    }

    public void save(SeatReservation seat) {
        try {
            PreparedStatement ps = c.prepareStatement("insert into invoice (acctNum, balance, lastTransaction) values (?,?, ?)");
            ps.setInt(1, seat.getSeatNum());
            //ps.setBoolean(seat.statusSeat(seat.getSeatNum()));

            ps.execute();

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
