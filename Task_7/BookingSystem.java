package Task_7;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class BookingSystem {
    public ArrayList<Event> events;

    public BookingSystem() {
        this.events = new ArrayList<>();
    }

    public Event createEvent(String event_name, String event_date, String event_time, String venue_name, Venue venue, int total_seats, int available_seats, double ticket_price, String event_type)
 {
        Event event = null;
        switch (event_type.toLowerCase()) {
            case "movie":
                event = new Movie(event_name,event_date,event_time,venue_name,venue,total_seats,available_seats,ticket_price,event_type,"","","");
                break;
            case "concert":
                event = new Concert(event_name,event_date,event_time,venue_name,venue,total_seats,available_seats,ticket_price,event_type,"","");
                break;
            case "sports":
                event = new Sports(event_name,event_date,event_time,venue_name,venue,total_seats,available_seats,ticket_price,event_type,"","");
                break;
            default:
                System.out.println("Invalid event type: " + event_type);
        }

        if (event != null) {
            events.add(event);
        }

        return event;
    }

    public double calculateBookingCost(int numTickets, double ticketPrice) {
        return numTickets * ticketPrice;
    }

    public void bookTickets(String eventName, int numTickets) {
        Event event = findEvent(eventName);
        if (event != null) {
            event.book_tickets(numTickets);
        } else {
            System.out.println("Event not found.");
        }
    }

    public void cancelTickets(String eventName, int numTickets) {
        Event event = findEvent(eventName);
        if (event != null) {
            event.cancel_booking(numTickets);
        } else {
            System.out.println("Event not found.");
        }
    }

    public int getAvailableNoOfTickets(String eventName) {
        Event event = findEvent(eventName);
        if (event != null) {
            return event.getAvailable_seats();
        } else {
            System.out.println("Event not found.");
            return 0;
        }
    }

    public Event findEvent(String eventName) {
        for (Event event : events) {
            if (event.getEvent_name().equalsIgnoreCase(eventName)) {
                return event;
            }
        }
        return null;
    }

    public abstract void getEventDetails();

    public static void main(String[] args) {
        BookingSystem bookingSystem = new TicketBookingSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Ticket Booking System Menu ======");
            System.out.println("1. Create Event");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Get Available Seats");
            System.out.println("5. Get Event Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n=== Create Event ===");
                    System.out.print("Enter event name: ");
                    String eventName = sc.nextLine();
                    System.out.print("Enter event date (yyyy-mm-dd): ");
                    String eventDate = sc.nextLine();
                    System.out.print("Enter event time: ");
                    String eventTime = sc.nextLine();
                    System.out.print("Enter total seats: ");
                    int totalSeats = sc.nextInt();
                    System.out.print("Enter ticket price: ");
                    double ticketPrice = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter event type (movie, concert, sports): ");
                    String eventType = sc.nextLine();
                    System.out.print("Enter venue name: ");
                    String venueName = sc.nextLine();
                    System.out.print("Enter venue address: ");
                    String address = sc.nextLine();

                    Venue venue = new Venue(venueName, address);
                    bookingSystem.createEvent(eventName, eventDate, eventTime, venueName, venue, totalSeats,totalSeats , ticketPrice, eventType);
                    break;

                case 2:
                    System.out.println("\n=== Book Tickets ===");
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();
                    System.out.print("Enter number of tickets to book: ");
                    int numTickets = sc.nextInt();
                    bookingSystem.bookTickets(eventName, numTickets);
                    break;

                case 3:
                    System.out.println("\n=== Cancel Tickets ===");
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();
                    System.out.print("Enter number of tickets to cancel: ");
                    numTickets = sc.nextInt();
                    bookingSystem.cancelTickets(eventName, numTickets);
                    break;

                case 4:
                    System.out.println("\n=== Get Available Seats ===");
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();
                    System.out.println("Available Seats: " + bookingSystem.getAvailableNoOfTickets(eventName));
                    break;

                case 5:
                    System.out.println("\n=== Get Event Details ===");
                    bookingSystem.getEventDetails();
                    break;

                case 6:
                    System.out.println("Exiting Ticket Booking System. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
