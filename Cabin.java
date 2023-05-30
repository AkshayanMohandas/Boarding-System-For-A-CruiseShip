public class Cabin {
    public String noOfGuests;
    public Passenger passenger;//calling passenger class

    public Cabin(String noOfGuests, Passenger passenger) {
        this.noOfGuests = noOfGuests;
        this.passenger = passenger;
    }
}
