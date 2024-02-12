import java.util.*;

public class ReservationApp {
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> hotels;

    private ArrayList<Bus> buses;
    private ArrayList<Train> trains;
    private String userName;
    private String userPassword;
    private int phoneNumber;
    private int NIN;
    private String address;
    int isBooked;


    public static int sumOfReservation(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            // Unboxing of i automatically
            if (i % 2 != 0)
                sum += i;

            // Unboxing of i is done automatically
            // using intvalue implicitly
            if (i.intValue() % 2 != 0)
                sum += i.intValue();
        }
        // Returning the odd sum
        return sum;
    }


    //Initialize Array List
    public ReservationApp() {
        this.flights = new ArrayList<Flight>();
        this.hotels = new ArrayList<Hotel>();
        this.buses = new ArrayList<Bus>();
        this.trains = new ArrayList<Train>();
    }


    // constructor for main class
    public ReservationApp(String userName, String userPassword, int phoneNumber, int NIN, String address) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.phoneNumber = phoneNumber;
        this.NIN = NIN;
        this.address = address;
    }



    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNIN() {
        return NIN;
    }

    public void setNIN(int NIN) {
        this.NIN = NIN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //to String methods

    @Override
    public String toString() {
        return "ReservationApp{" +
                "userName='" + userName + '\'' +
                ", userPassword=" + userPassword +
                ", phoneNumber=" + phoneNumber +
                ", NIN=" + NIN +
                ", address='" + address + '\'' +
                '}';
    }


    //methods for users to login
    public boolean Login() {
        String userName;
        String userPassword;
        int NIN;


        Scanner login = new Scanner(System.in);
        int registeredUsers = 0;
        String input;
        while (true) {
            System.out.println("Enter 'register' to register a new user and 'Login' to login as a User or 'exit' to quit:");
            input = login.nextLine();
            if (input.equalsIgnoreCase("register")) {


                System.out.print("Enter your UserName: ");
                userName = login.nextLine();
                System.out.print("Enter your UserPassword: ");
                userPassword = login.nextLine();
                System.out.print("Enter your NIN: ");
                NIN = login.nextInt();
                login.close();

                System.out.println("\n ************ The users currently logged in at the moment ************* \n");
                System.out.println("userName: " + userName + " \n userPassword " + userPassword + " \n NIN " + NIN);
                System.out.println("User registered successfully!");

                return true;

            } else if (input.equalsIgnoreCase("login")) {


                System.out.println("Succesfully login");

                return true;

            } else if (input.equalsIgnoreCase("exit")) {

                break;


            } else {
                registeredUsers++;
                System.out.println("Total registered users: " + registeredUsers);

            }


        System.out.println("Total registered users: " + registeredUsers);
        login.close();
    }
        return false;
    }





                 // methods to search for flights
    public void searchFlights( String origin, String destination, String date, int numPassengers) {
        System.out.println("Searching for flights from " + origin + " to " + destination + " on "
                + date + " for " + numPassengers + " passengers.");


    }


    // methods to search for hotels
   public void searchHotels(String location, String checkIn, String checkOut, int numGuests) {
       System.out.println("Searching for hotels in " + location + " from " + checkIn + " to " + checkOut + " for " + numGuests + " guests.");
   }

    // methods to search for bus

   public void searchBus(int busNumberPlate, String origin, String destination, boolean RSVP, int seatNum, double price) {
       System.out.println("Searching for bus " + busNumberPlate + " bus stop " + origin+ " to " +destination + " Reserved " +RSVP+ " seat " + seatNum + " price " + price+ " is affordable");
   }


    // methods to search for trains
   public void searchTrain(int trainId, String seatNum, boolean RSVP, String origin, String destination, double price) {
       System.out.println("searching for train " +trainId+ " seat " +seatNum+ " reservation made " +RSVP+ " train terminal " +origin+ " to " +destination+ " price " +price+ " is affordable");
   }

             // search for places available

                 public boolean[] places;

                public void Reservation(int numPlaces) {
                    places = new boolean[numPlaces];
                 }

                public void reservePlace(int placeNumber) {
                    if (placeNumber >= 0 && placeNumber < places.length) {
                      places[placeNumber] = true;
                         System.out.println("Place " + placeNumber + " reserved successfully.");
                     } else {
                         System.out.println("Invalid place number.");
                     }
                 }

                 public void releasePlace(int placeNumber) {
                     if (placeNumber >= 0 && placeNumber < places.length) {
                         places[placeNumber] = false;
                         System.out.println("Place " + placeNumber + " released successfully.");
                     } else {
                         System.out.println("Invalid place number.");
                     }
                 }

                 public boolean isPlaceAvailable(int placeNumber) {
                     if (placeNumber >= 0 && placeNumber < places.length) {
                         return !places[placeNumber];
                     } else {
                         System.out.println("Invalid place number.");
                         return false;
                     }
                 }





    // function to book flight
     public void bookFlight(int flightNumber, String flightPassengerName, String origin, String destination, String date, int numPassengers, double price, Boolean RSVP, String userName, String userPassword, int phoneNumber, int NIN, String address) {
      Flight flight = new Flight(flightNumber, flightPassengerName, origin, destination,date, numPassengers, price, RSVP, userName, userPassword, address, NIN, phoneNumber);
        int confirmationNumber = generateConfirmationNumber();
       flight.setConfirmationNumber(confirmationNumber);
        this.flights.add(flight);
      System.out.println("Flight booked! Confirmation number: " + confirmationNumber);
    }


    // function to book hotel
     public void bookHotel(int hotelId, String name, String location, String checkIn, String checkOut, int guests, double price, Boolean RSVP, String userName, String userPassword, int phoneNumber, int NIN, String address) {
       Hotel hotel = new Hotel(hotelId, name, location, checkIn, checkOut, guests, price, userName, userPassword, phoneNumber, NIN, address);
       int confirmationNumber = generateConfirmationNumber();
        hotel.setConfirmationNumber(confirmationNumber);
        this.hotels.add(hotel);
        System.out.println("Hotel booked! Confirmation number: " + confirmationNumber);
    }


    // function to book bus
     public void bookBus(int busNumberPlate, String origin, String destinaion, int seatNum, double price, Boolean RSVP, String color, String userName, String userPassword, int phoneNumber, int NIN, String address)  {
        Bus bus = new Bus(busNumberPlate, origin, destinaion, seatNum, price, RSVP, color, userName, userPassword, phoneNumber, NIN, address);
        int confirmationNumber = generateConfirmationNumber();
        bus.setConfirmationNumber(confirmationNumber);
        this.buses.add(bus);
        System.out.println("Bus booked! Confirmation number: " + confirmationNumber);
     }


    // function to book train
    
    public void bookTrain(int trainId, String name, String seatNum, String origin, String destination, String color, double price, Boolean RSVP, String userName, String userPassword, int phoneNumber, int NIN, String address) {
        Train train = new Train(trainId, name, seatNum, origin, destination, color, price, RSVP, userName, userPassword, phoneNumber, NIN, address);


        if (isBooked < 100  && generateConfirmationNumber() > 11 || isBooked > 160) {
            System.out.println("Train is booked.");
        int confirmationNumber = generateConfirmationNumber();
        train.setConfirmationNumber(confirmationNumber);
        this.trains.add(train);
        System.out.println("Train booked! Confirmation number: " + confirmationNumber);

        } else {
            System.out.println("Train is not fully booked.");
        }
    }

    // function to cancel reservation request
    public void cancelReservation(int confirmationNumber) {
        // Cancel a flight, a train, a bus or hotel reservation based on confirmation number
        for (Flight flight: this.flights) {
            if (flight.getConfirmationNumber() == confirmationNumber) {
                this.flights.remove(flight);
                System.out.println("Flight reservation with confirmation number " + confirmationNumber + " cancelled.");
               return;
           }
        }
        for (Hotel hotel: this.hotels) {
            if (hotel.getConfirmationNumber() == confirmationNumber) {
                this.hotels.remove(hotel);
                System.out.println("Hotel reservation with confirmation number " + confirmationNumber + " cancelled.");
                return;
            }
        }
        
    
        for (Bus bus: this.buses) {
        if (bus.getConfirmationNumber() == confirmationNumber) {
            this.buses.remove(bus);
            System.out.println("Hotel reservation with confirmation number " + confirmationNumber + " cancelled.");
            return;
        }
         }


      for (Train train: this.trains) {
        if (train.getConfirmationNumber() == confirmationNumber) {
        this.trains.remove(train);
        System.out.println("Hotel reservation with confirmation number " + confirmationNumber + " cancelled.");
        return;
        }
        }
        System.out.println("No reservation found with confirmation number " + confirmationNumber + ".");
        }
        
            // function to random generate confirmed reservation
      private int generateConfirmationNumber() {
        // Generate a random 6-digit confirmation number
      Random rand = new Random();
       return rand.nextInt(900000) + 100000;
    }
   }


   // class Flight inherited from the super class ReservationApp
class Flight extends ReservationApp {
  private int flightNumber;
  private String flightPassengerName;
  private String origin;
  private String destination;
  private String date;

  private int numPassengers;
  private double flightPrice;
  private Boolean RSVP;
  private  int confirmationNumber;


  // constructors for class flight
    public Flight(String userName, String userPassword, int phoneNumber, int NIN, String address, int flightNumber, String flightPassengerName, String origin, String destination, String date, int numPassengers, double flightPrice, Boolean RSVP) {
        super(userName, userPassword, phoneNumber, NIN, address);
        this.flightNumber = flightNumber;
        this.flightPassengerName = flightPassengerName;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.numPassengers = numPassengers;
        this.flightPrice = flightPrice;
        this.RSVP = RSVP;
    }

    // empty constructors for flight
    public Flight(int flightNumber, String flightPassengerName, String origin, String destination, String date, int numPassengers, double price, Boolean rsvp, String userName, String userPassword, String address, int nin, int phoneNumber) {
    }


    // Getters and Setters for class flight
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightPassengerName() {
        return flightPassengerName;
    }

    public void setFlightPassengerName(String flightPassengerName) {
        this.flightPassengerName = flightPassengerName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Boolean getRSVP() {
        return RSVP;
    }

    public void setRSVP(Boolean RSVP) {
        this.RSVP = RSVP;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}

// class Hotel inherited from the super class ReservationApp
class Hotel extends ReservationApp {
 private int hotelId;
 private String name;
 private String location;
 private String checkIn;
 private String checkOut;
 private int guests;
 private double price;
 private Boolean RSVP;
 private int confirmationNumber;


         // constructor for class hotel
    public Hotel(String userName, String userPassword, int phoneNumber, int NIN, String address, int hotelId, String name, String location, String checkIn, String checkOut, int guests, double price, Boolean RSVP) {
        super(userName, userPassword, phoneNumber, NIN, address);
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
        this.price = price;
        this.RSVP = RSVP;
    }


    // Empty constructor
    public Hotel(int hotelId, String name, String location, String checkIn, String checkOut, int guests, double price, String userName, String userPassword, int phoneNumber, int nin, String address) {
    }

    // Getters and Setters for class hotel

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getRSVP() {
        return RSVP;
    }

    public void setRSVP(Boolean RSVP) {
        this.RSVP = RSVP;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}

// class Bus inherited from the super class ReservationApp

class Bus extends ReservationApp {
  private int busNumberPlate;
  private String busColor;
  private String origin;
  private String destination;
  private Boolean RSVP;
  private int seatNum;
  private double price;
  private int confirmationNumber;


  // constructor for class bus
    public Bus(String userName, String userPassword, int phoneNumber, int NIN, String address, int busNumberPlate, String busColor, String origin, String destination, Boolean RSVP, int seatNum, double price) {
        super(userName, userPassword, phoneNumber, NIN, address);
        this.busNumberPlate = busNumberPlate;
        this.busColor = busColor;
        this.origin = origin;
        this.destination = destination;
        this.RSVP = RSVP;
        this.seatNum = seatNum;
        this.price = price;
    }

    //Empty constructor of class bus
    public Bus(int busNumberPlate, String origin, String destinaion, int seatNum, double price, Boolean rsvp, String color, String userName, String userPassword, int phoneNumber, int nin, String address) {
        
    }


     // setters and getters for class bus
    public int getBusNumberPlate() {
        return busNumberPlate;
    }

    public void setBusNumberPlate(int busNumberPlate) {
        this.busNumberPlate = busNumberPlate;
    }

    public String getBusColor() {
        return busColor;
    }

    public void setBusColor(String busColor) {
        this.busColor = busColor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getRSVP() {
        return RSVP;
    }

    public void setRSVP(Boolean RSVP) {
        this.RSVP = RSVP;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}

// class Train inherited from the super class ReservationApp

class Train extends ReservationApp {
    private int trainId;
    private String name;
    private String color;
    private String seatNum;
    private Boolean RSVP;
    private String origin;
    private String destination;
    private double price;
    private int confirmationNumber;


    //Constructor for train
    public Train(String userName, String userPassword, int phoneNumber, int NIN, String address, int trainId, String name, String color, String seatNum, Boolean RSVP, String origin, String destination, double price) {
        super(userName, userPassword, phoneNumber, NIN, address);
        this.trainId = trainId;
        this.name = name;
        this.color = color;
        this.seatNum = seatNum;
        this.RSVP = RSVP;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }


    // empty constructor
    public Train(int trainId, String name, String seatNum, String origin, String destination, String color, double price, Boolean rsvp, String userName, String userPassword, int phoneNumber, int nin, String address) {
    }


    // Setters and Getters for class train
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public Boolean getRSVP() {
        return RSVP;
    }

    public void setRSVP(Boolean RSVP) {
        this.RSVP = RSVP;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public static class Register extends ReservationApp {
        private int size;
        private int[] registers;

        // Constructor to initialize registers with 0
        public Register(int size) {
            this.size = size;
            this.registers = new int[size];
        }

        // Method to read a register at a given address
        public int readRegister(int address) {
            if (address >= 0 && address < size) {
                return registers[address];
            } else {
                System.out.println("Invalid register address");
                return -1; // Return a default value indicating an error
            }
        }

        // Method to write a value to a register at a given address
        public void writeRegister(int address, int value) {
            if (address >= 0 && address < size) {
                registers[address] = value;
            } else {
                System.out.println("Invalid register address");
            }
        }
    }
}