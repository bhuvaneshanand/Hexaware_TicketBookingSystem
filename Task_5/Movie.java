package Task_5;

public class Movie extends Event {
	String genre;
	String ActorName;
	String ActresName; 
	
	Movie(){
		genre="Romance";
		ActorName="Bhuvan";
		ActresName="Akshaya"; 
		
	}
	
	Movie(String event_name, String event_date, String event_time, String venue_name, int total_seats,int available_seats, double ticket_price, String event_type,String genre, String ActorName, String ActresName){
		super(event_name,event_date,event_time,venue_name,total_seats,available_seats,ticket_price,event_type);
		this.genre=genre;
		this.ActorName=ActorName;
		this.ActresName=ActresName;

	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getActorName() {
		return ActorName;
	}

	public void setActorName(String actorName) {
		ActorName = actorName;
	}

	public String getActresName() {
		return ActresName;
	}

	public void setActresName(String actresName) {
		ActresName = actresName;
	}

	@Override
	public String toString() {
		return super.toString()+ "Movie [genre=" + genre + ", ActorName=" + ActorName + ", ActresName=" + ActresName + "]";
	}
	
	public void display_event_details() {
		super.display_event_details();
		System.out.println( "Movie [genre=" + genre + ", ActorName=" + ActorName + ", ActresName=" + ActresName + "]");
	}

	
	

}
