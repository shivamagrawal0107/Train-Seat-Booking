import java.util.Scanner;

public class SeatBooking {
    static char[][] seats;
    
    public static void initializeSeats() {
        seats = new char[11][7];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 7; j++) {
                seats[i][j] = 'O'; // 'O' for available, 'X' for booked
            }
        }
    }
    
    public static void displaySeats() {
        System.out.println("\nCurrent Seat Status:");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static boolean bookSeats(int numSeats) {
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 7; j++) {
                if (seats[i][j] == 'O') {
                    seats[i][j] = 'X';
                    count++;
                    if (count == numSeats) {
                        return true; // All requested seats are booked
                    }
                }
            }
        }
        return false; // Not enough seats available
    }

    public static void main(String[] args) {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Train Seat Booking System!");
        
        while (true) {
            displaySeats();
            
            System.out.print("\nEnter the number of seats to book: ");
            int numSeatsToBook = scanner.nextInt();
            
            if (numSeatsToBook < 1 || numSeatsToBook > 7) {
                System.out.println("Invalid number of seats. Please enter a number between 1 and 7.");
                continue;
            }

            boolean seatsBooked = bookSeats(numSeatsToBook);

            if (seatsBooked) {
                System.out.println("\n" + numSeatsToBook + " seats booked successfully!");
            } else {
                System.out.println("Sorry, there are not enough seats available.");
            }
        }
    }
}