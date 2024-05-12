package Task_6;

import java.util.Scanner;

public abstract class BookingSystem {

	public abstract Event create_event(String event_type, String event_name, String date, String time,String venue_name, int total_seats, double ticket_price,String attribute1, String attribute2, String attribute3);
	public abstract Event find_event(String event_type, String event_name);
	public abstract void display_event_details(Event event);
	public abstract double book_tickets(Event event, int num_tickets);
	public abstract void cancel_tickets(Event event, int num_tickets);
	
    
    
    
    
    
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Ticket Booking System Menu ======");
            System.out.println("1. Book Tickets");
            System.out.println("2. View Event Details");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                System.out.println("\n=== Book Tickets ===");
                System.out.print("Enter event type (movie, concert, sports): ");
                String eventType = sc.nextLine();
                System.out.print("Enter event name: ");
                String eventName = sc.nextLine();
                System.out.print("Enter date (yyyy-mm-dd): ");
                String date = sc.nextLine();
                System.out.print("Enter time: ");
                String time = sc.nextLine();
                System.out.print("Enter venue name: ");
                String venueName = sc.nextLine();
                System.out.print("Enter total seats: ");
                int totalSeats = sc.nextInt();
                System.out.print("Enter ticket price: ");
                double ticketPrice = sc.nextDouble();
                sc.nextLine(); 

                String attribute1 = "";
                String attribute2 = "";
                String attribute3 = "";

                if (eventType.equalsIgnoreCase("movie")) {
                    System.out.print("Genre: ");
                    attribute1 = sc.nextLine();
                    System.out.print("Actor Name: ");
                    attribute2 = sc.nextLine();
                    System.out.print("Actress Name: ");
                    attribute3 = sc.nextLine();
                } 
                else if (eventType.equalsIgnoreCase("concert")) {
                    System.out.print("Artist: ");
                    attribute1 = sc.nextLine();
                    System.out.print("Type: ");
                    attribute2 = sc.nextLine();
                } 
                else if (eventType.equalsIgnoreCase("sports")) {
                    System.out.print("Sport Name: ");
                    attribute1 = sc.nextLine();
                    System.out.print("Team Name: ");
                    attribute2 = sc.nextLine();
                }

                Event newEvent = bookingSystem.create_event(eventType, eventName, date, time,
                                                            venueName, totalSeats, ticketPrice,
                                                            attribute1, attribute2, attribute3);
                if (newEvent != null) {
                    System.out.print("Enter number of tickets to book: ");
                    int numTickets = sc.nextInt();
                    bookingSystem.book_tickets(newEvent, numTickets);
                }
                break;

                case 2:
                    System.out.println("\n=== View Event Details ===");
                    System.out.print("Enter event type (movie, concert, sports): ");
                    eventType = sc.nextLine();
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();

                    Event existingEvent = bookingSystem.find_event(eventType, eventName);
                    bookingSystem.display_event_details(existingEvent);
                    break;

                case 3:
                    System.out.println("\n=== Cancel Tickets ===");
                    System.out.print("Enter event type (movie, concert, sports): ");
                    eventType = sc.nextLine();
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();

                    existingEvent = bookingSystem.find_event(eventType, eventName);
                    if (existingEvent != null) {
                        System.out.print("Enter number of tickets to cancel: ");
                        int numTickets = sc.nextInt();
                        bookingSystem.cancel_tickets(existingEvent, numTickets);
                    }
                    break;

                case 4:
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
