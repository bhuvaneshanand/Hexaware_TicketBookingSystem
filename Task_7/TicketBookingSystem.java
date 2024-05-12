package Task_7;

public class TicketBookingSystem extends BookingSystem {

    @Override
    public void getEventDetails() {
        for (Event event : events) {
            event.display_event_details();
            System.out.println("--------------");
        }
    }
}
