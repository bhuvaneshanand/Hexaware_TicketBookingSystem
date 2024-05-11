import java.util.Scanner;

public class Task_1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter available tickets: ");
        int availTicket = sc.nextInt();
        
        System.out.print("Enter number of tickets to book: ");
        int nTicket = sc.nextInt();

        
        if(nTicket <= availTicket) {
            int remainTicket =availTicket - nTicket;
            System.out.println("Tickets booked successfully.... Remaining tickets :  " + remainTicket);
        } else {
            System.out.println("Tickets unavailable........ Available tickets are :  " + availTicket);
        }
    }

}
