package sulaiman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Bus {
    private int busNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int capacity;


    public Bus(int busNumber, String source, String destination, String departureTime, String arrivalTime, int capacity) {
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
    }


    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}


public class BusReservationSystem {
    private static List<Bus> buses;

    public BusReservationSystem() {
        this.buses = new ArrayList<>();
    }

    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public boolean removeBus(int busNumber) {
        if (buses.isEmpty()) {
            System.out.println("Nothing removed in the bus list.");
        } else {
            for (int i = 0; i < buses.size(); i++) {
                if (buses.get(i).getBusNumber() == busNumber) {
                    buses.remove(i);
                    System.out.println("Bus removed successfully!");
                    break;
                }
            }
        }
        return true;
    }

    public void displayAllBuses() {
        if (buses.isEmpty()) {
            System.out.println("Nothing found to display in the bus list.");
        } else {
            for (Bus bus : buses) {
                System.out.println("************* Displayed All Buses found  ***************");
                System.out.println("Bus Number: " + bus.getBusNumber());
                System.out.println("Source: " + bus.getSource());
                System.out.println("Destination: " + bus.getDestination());
                System.out.println("Departure Time: " + bus.getDepartureTime());
                System.out.println("Arrival Time: " + bus.getArrivalTime());
                System.out.println("Bus Capacity: " + bus.getCapacity());
                System.out.println("---------------------------");

            }
        }
    }

    public void updateBus(int busNumber, String source, String destination, String departureTime, String arrivalTime, int capacity) {
        if (buses.isEmpty()) {
            System.out.println("Nothing updated in the bus list.");
        } else {
            for (Bus bus : buses) {
                if (bus.getBusNumber() == busNumber) {
                    bus.setSource(source);
                    bus.setDestination(destination);
                    bus.setDepartureTime(departureTime);
                    bus.setArrivalTime(arrivalTime);
                    bus.setCapacity(Integer.parseInt(String.valueOf(capacity)));
                    System.out.println("Bus updated successfully!");
                    break;
                }
            }
        }
    }
}
