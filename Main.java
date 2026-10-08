import java.util.Scanner;

// This class represents one movie booking
class MovieTicket {

    // Data members (the details we store)
    String movieName;
    double ticketPrice;
    int numberOfTickets;

    // Constructor: runs when we create a new MovieTicket object
    // It fills in the details we pass in
    MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Step 1: total = price x number of tickets
    double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    // Step 2: 10% discount if 5 or more tickets, else 0
    double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        } else {
            return 0;
        }
    }

    // Step 3: final amount = total - discount
    double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    // Step 4: print the bill
    void displayBill() {
        double discount = calculateDiscount();

        System.out.println("======= Final Bill =======");
        System.out.println("movie name : " + movieName);
        System.out.printf("ticket price : %.2f%n", ticketPrice);
        System.out.println("number of  tickets: " + numberOfTickets);

        // Show discount only if one was given
        if (discount > 0) {
            System.out.printf("Discount : %.2f%n", discount);
        }

        System.out.printf("Final amount : %.2f%n", calculateFinalAmount());
        System.out.println("=====================");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter movie name: ");
        String name = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        System.out.print("Enter number of tickets: ");
        int count = sc.nextInt();

        // Create the object (this calls the constructor)
        MovieTicket ticket = new MovieTicket(name, price, count);

        // Show the bill
        ticket.displayBill();
    }
}