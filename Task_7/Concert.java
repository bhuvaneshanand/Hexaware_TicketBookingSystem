package Task_7;

public class Concert extends Event {
	
	String artist; 
	String type;

	Concert(){
		artist="Anirudh"; 
		type="Music";
		
	}
	
	Concert(String event_name, String event_date, String event_time, String venue_name,Venue venue, int total_seats,int available_seats, double ticket_price, String event_type,String artist, String type){
		
		super(event_name,event_date,event_time,venue_name,venue,total_seats,available_seats,ticket_price,event_type);
		this.artist=artist;
		this.type=type;

	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@Override
	public String toString() {
		return super.toString()+"Concert [artist=" + artist + ", type=" + type + "]";
	}

	public void  display_event_details(){
		System.out.println("Event Name: " + event_name);
        System.out.println("Event Date: " + event_date);
        System.out.println("Event Time: " + event_time);
        System.out.println("Venue Name: " + venue_name);
        System.out.println("Total Seats: " + total_seats);
        System.out.println("Available Seats: " + available_seats);
        System.out.println("Ticket Price: $" + ticket_price);
        System.out.println("Event Type: " + event_type);
        
		System.out.println("Concert [artist=" + artist + ", type=" + type + "]");

	}
	
	public double calculate_total_revenue(){
        return ticket_price * (total_seats - available_seats);
    }
	
	public int getBookedNoOfTickets() {
        return total_seats - available_seats;
    }
	
	
	public double book_tickets(int num_tickets){
	
		if (num_tickets <= available_seats) {
            available_seats -= num_tickets;
            System.out.println(num_tickets + " tickets booked successfully.");
        } 
		else {
            System.out.println("Not enough available seats to book " + num_tickets + " tickets.");
        }
		return num_tickets;
		
	}
	
	public int cancel_booking(int num_tickets) {
        available_seats += num_tickets;                                            
        System.out.println(num_tickets + " tickets canceled successfully.");
        return num_tickets;
			
        }
	
	
}
