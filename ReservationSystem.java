import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        ReservationManager manager = new ReservationManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Online Reservation System");
            System.out.println("1. Add Reservation");
            System.out.println("2. List Reservations");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter time (HH:MM): ");
                String time = scanner.nextLine();

                Reservation reservation = new Reservation(name, date, time);
                manager.addReservation(reservation);
                System.out.println("Reservation added successfully!");
            } else if (choice == 2) {
                manager.listReservations();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
