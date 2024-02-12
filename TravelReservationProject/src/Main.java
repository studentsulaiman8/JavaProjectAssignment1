import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ReservationApp app = new ReservationApp();

        if (app.Login()) {
            System.out.println("\n ************ All searches available at the moment ************* \n");
            app.searchFlights("Bo", "Freetown", "4/2/2024", 4);
            app.searchHotels("Bo", "5/2/2024", "12/3/2024", 9);
            app.searchBus(1273, "Bo", "freetown", true, 12, 9000);
            app.searchTrain(124, "278", true, "freetown", "mile 91", 230);


            System.out.println("\n ************ All bookings made at the moment ************* \n");
            app.bookFlight(114, "Sullay", "Makeni", "Moyamba", "12/3/2024", 4, 70000, true, "sesay1", "1234", 211, 2345672, "Makeni");
            app.bookFlight(112, "abdul", "Kabala", "Pujehun", "12/9/2024", 5, 8000, false, "abds", "127900", 234, 12345, "Kabala");
            app.bookHotel(111, "turay", "Koinadugu", "12/2/2024", "14/2/2024", 9, 900, true, "david", "123abc", 123985, 19576, "Koinadugu");
            app.bookBus(123, "Bo", "Freetown", 7, 200, true, "Blue", "sesay", "1234", 123456, 1234, "Makeni");
            app.bookTrain(237, "sesay", "23", "Moyamba", "freetown", "yellow", 980, false, "turay", "190980", 96824, 6834, "makeni");


//           Cancel a flight or hotel reservation based on reservation number
            System.out.println("\n ************ All Cancelled reservations at the moment ************* \n");
            app.cancelReservation(112);


            // Reserved Places
            System.out.println("\n ************ All Reservations available at the moment ************* \n");

            app.Reservation(10);


            app.reservePlace(3);
            app.reservePlace(1);
            app.releasePlace(2);

            System.out.println("Is place 3 available? " + app.isPlaceAvailable(3));
            System.out.println("Is place 7 available? " + app.isPlaceAvailable(7));


            System.out.println("\n ************ All users available at the moment ************* \n");
            // Creating an empty ArrayList of integer type
            List<Integer> list = new ArrayList<>();

            // Adding the int primitives type values to List
            for (int i = 0; i < 10; i++)
                list.add(i);

            // Getting sum of all odd numbers in List
            int sumOdd = ReservationApp.sumOfReservation(list);

            // Printing sum of odd numbers of request
            System.out.println("Sum of odd numbers = "
                    + sumOdd);

            System.out.println("\n ************ All Registries available at the moment for trains ************* \n");
            Train.Register registerArray = new Train.Register(10);

            // Write values to registers
            registerArray.writeRegister(0, 45);
            registerArray.writeRegister(1, 12);
           // registerArray.writeRegister(2, 90);


            // Read values from registers
            System.out.println("Register 0: " + registerArray.readRegister(0));
            System.out.println("Register 1: " + registerArray.readRegister(1));
            System.out.println("Register 2: " + registerArray.readRegister(2));

            // Attempt to write to an invalid register address
            registerArray.writeRegister(900, 999);


        } else {
            System.out.println("Login invalid exited code");

        }
    }
}
