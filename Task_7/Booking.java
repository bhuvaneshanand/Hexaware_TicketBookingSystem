package Task_7;

public class Booking {
    int nextBookingId = 1;
    int bookingId;
    Customer[] customers;
    Event event;
    int num_tickets;
    double total_cost;
    String booking_date;

    public Booking(Customer[] customers, Event event, int num_tickets, double total_cost, String booking_date) {
        this.bookingId = nextBookingId++;
        this.customers = customers;
        this.event = event;
        this.num_tickets = num_tickets;
        this.total_cost = total_cost;
        this.booking_date = booking_date;
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Event Name: " + event.getEvent_name());
        System.out.println("Number of Tickets: " + num_tickets);
        System.out.println("Total Cost: " + total_cost);
        System.out.println("Booking Date: " + booking_date);
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Event getEvent() {
        return event;
    }

    public int getNum_tickets() {
        return num_tickets;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public String getBooking_date() {
        return booking_date;
    }
}
