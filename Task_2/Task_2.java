import java.util.Scanner;

public class Task_2 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Ticket Options:");
	        System.out.println("1. Silver");
	        System.out.println("2. Gold");
	        System.out.println("3. Diamond");

	        System.out.print("Enter option: ");
	        int input = sc.nextInt();
	       
	        System.out.print("Number of tickets to be booked: ");
	        int nTicket = sc.nextInt();

	        double ticketPrice;
	        double totalCost;
	        
	        if (input == 1) {
	            ticketPrice = 50.0; 
	        } else if (input == 2) {
	            ticketPrice = 100.0; 
	        } else if (input == 3) {
	            ticketPrice = 150.0; 
	        } else {
	            System.out.println("Invalid category.");
	            return;
	        }

	        totalCost = ticketPrice * nTicket;

	        System.out.println("Total cost:Rs " + totalCost);
	    }

}
