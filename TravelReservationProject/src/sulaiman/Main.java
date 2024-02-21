package sulaiman;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        BusReservationSystem reservationSystem = new BusReservationSystem();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****************************************");
            System.out.println("Welcome to the Bus Reservation App");
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = date.format(formatter);
            System.out.println(formattedDateTime);

            int hour = date.getHour();

            if (hour >= 0 && hour < 12) {
                System.out.println("Good Morning!!");
            } else if ( hour >= 12 && hour > 4) {
                System.out.println("Good Afternoon!!");
            } else {
                System.out.println("Good Evening!!");
            }

            System.out.println("****************************************");
            System.out.println("1. Add Bus");
            System.out.println("2. Remove Bus");
            System.out.println("3. Display All Buses");
            System.out.println("4. Update Bus");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {

                case 1:
                    System.out.print("Enter Bus Number: ");
                    int busNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Source: ");
                    String source = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter Departure Time: ");
                    String departureTime = scanner.nextLine();
                    System.out.print("Enter Arrival Time: ");
                    String arrivalTime = scanner.nextLine();
                    System.out.print("Enter Bus Capacity: ");
                    int capacity = scanner.nextInt();
                    Bus bus = new Bus(busNumber, source, destination, departureTime, arrivalTime, capacity);
                    reservationSystem.addBus(bus);
                    System.out.println("Bus added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Bus Number: ");
                    int removeBusNumber = scanner.nextInt();
                    reservationSystem.removeBus(removeBusNumber);


                    break;
                case 3:
                    reservationSystem.displayAllBuses();
                    break;
                case 4:
                    System.out.print("Enter Bus Number: ");
                    int updateBusNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Source: ");
                    String updatedSource = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String updatedDestination = scanner.nextLine();
                    System.out.print("Enter Departure Time: ");
                    String updatedDepartureTime = scanner.nextLine();
                    System.out.print("Enter Arrival Time: ");
                    String updatedArrivalTime = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    String updatedCapacity = String.valueOf(scanner.nextInt());
                    reservationSystem.updateBus(updateBusNumber, updatedSource, updatedDestination, updatedDepartureTime, updatedArrivalTime, Integer.parseInt(updatedCapacity));

                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

    }
}


