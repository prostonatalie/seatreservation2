public class SeatReservation {
    private int seatNum;
    private  boolean openSeat;
    //private int lastTransaction;

    public SeatReservation(int seatNum)
    {
        this.seatNum = seatNum;
        this.openSeat = true;
    }
    /*
    public BankAccount(int seatNum, int balance, int lastTransaction)
    {
        this.acctNum = acctNum;
        this.balance = balance;
        this.lastTransaction = lastTransaction;
    }
*/
    public int getSeatNum()
    {
        return seatNum;
    }

    public boolean statusSeat(int seatNum)
    {
        if (openSeat) {
            return true;
        }
        return false;
    }

    public void reserveSeat(int seatNum) {
        if (statusSeat(seatNum) == true) {
            openSeat = false;
            System.out.println("Seat Reserved Successfully");
        }
        else {
            System.out.println("Sorry, could not reserve this seat");
        }
    }
    /*
    public boolean withdraw(int amount)
    {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount;
            lastTransaction = -amount;
            return true;
        }
        else
            return false;
    }

    public int getBalance()
    {
        return balance;
    }

    public int getLastTransactAmount()
    {
        return lastTransaction;
    }

    @Override
    public String toString()
    {
        return String.format("Account %d (balance $%d)",
                acctNum, balance);
    }

     */
}
