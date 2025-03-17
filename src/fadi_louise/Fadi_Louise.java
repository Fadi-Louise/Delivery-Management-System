/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadi_louise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Fadi_Louise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<DeliveryItem> allItems = new ArrayList<>();

        while (true) {
            System.out.println("Delivery Management System Menu:");
            System.out.println("1. Add new driver.");
            System.out.println("2. Receive new item.");
            System.out.println("3. Display all items (received - assigned"
                    + " - delivered)");
            System.out.println("4. Display all received items.");
            System.out.println("5. Display all assigned items.");
            System.out.println("6. Display all delivered items.");
            System.out.println("7. Display all drivers.");
            System.out.println("8. Assign item to a driver.");
            System.out.println("9. Set item to received.");
            System.out.println("10. Check a driver load.");
            System.out.println("11. Display total cost.");
            System.out.println("0. Exit.");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                case 1:
                    addNewDriver(input, drivers);
                    break;
                case 2:
                    receiveNewItem(input, allItems);
                    break;
                case 3:
                    displayAllItems(allItems);
                    break;
                case 4:
                    displayItemsByStatus(allItems, "Received");
                    break;
                case 5:
                    displayItemsByStatus(allItems, "Assigned");
                    break;
                case 6:
                    displayItemsByStatus(allItems, "Delivered");
                    break;
                case 7:
                    displayAllDrivers(drivers);
                    break;
                case 8:
                    assignItemToDriver(input, allItems, drivers);
                    break;
                case 9:
                    setItemToReceived(input, allItems);
                    break;
                case 10:
                    checkDriverLoad(input, drivers);
                    break;
                case 11:
                    displayTotalCost(allItems);
                    break;
                default:
                    System.out.println("Invalid choice."
                            + " Please enter a valid option.");
            }
        }
    }

    private static void addNewDriver(Scanner scanner, ArrayList<Driver> drivers) {
        System.out.print("Enter driver name: ");
        String name = scanner.nextLine();
        System.out.print("Enter car registration number: ");
        String carRegistrationNb = scanner.nextLine();
        System.out.print("Enter max weight capacity: ");
        double maxWeight = scanner.nextDouble();
        System.out.print("Enter max volume capacity: ");
        double maxVolume = scanner.nextDouble();

        int lowerBound, upperBound;
        do {
            System.out.print("Enter active zone lower bound: ");
            lowerBound = scanner.nextInt();
            System.out.print("Enter active zone upper bound: ");
            upperBound = scanner.nextInt();

            if (upperBound <= lowerBound) {
                System.out.println("Error: Upper bound must be larger than the"
                        + " lower bound. Please enter valid values.");
            }
        } while (upperBound <= lowerBound);

        int[] zone = {lowerBound, upperBound};
        Driver newDriver = new Driver(name, carRegistrationNb, maxWeight,
                maxVolume, zone);
        drivers.add(newDriver);

        System.out.println("New driver added successfully.");
    }

    private static void receiveNewItem(Scanner scanner,
            ArrayList<DeliveryItem> allItems) {
        System.out.println("Choose the type of item to receive:");
        System.out.println("1. Envelope");
        System.out.println("2. Package");

        System.out.print("Enter your choice: ");
        int itemTypeChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (itemTypeChoice) {
            case 1:
                receiveNewEnvelope(scanner, allItems);
                break;
            case 2:
                receiveNewPackage(scanner, allItems);
                break;
            default:
                System.out.println("Invalid choice."
                        + " Please enter a valid option.");
        }
    }

    private static void receiveNewEnvelope(Scanner scanner,
            ArrayList<DeliveryItem> allItems) {
        System.out.print("Enter sender name: ");
        String senderName = scanner.nextLine();
        System.out.print("Enter receiver name: ");
        String receiverName = scanner.nextLine();
        System.out.print("Enter receiver postal code: ");
        int receiverPostalCode = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter envelope size: ");
        String size = scanner.nextLine();

        Envelope newEnvelope = new Envelope(senderName, receiverName,
                receiverPostalCode, size);
        allItems.add(newEnvelope);

        System.out.println("Envelope received successfully.");
    }

    private static void receiveNewPackage(Scanner scanner,
            ArrayList<DeliveryItem> allItems) {
        System.out.print("Enter sender name: ");
        String senderName = scanner.nextLine();
        System.out.print("Enter receiver name: ");
        String receiverName = scanner.nextLine();
        System.out.print("Enter receiver postal code: ");
        int receiverPostalCode = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter package height: ");
        double height = scanner.nextDouble();
        System.out.print("Enter package width: ");
        double width = scanner.nextDouble();
        System.out.print("Enter package length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter package weight: ");
        double weight = scanner.nextDouble();

        Package newPackage = new Package(senderName, receiverName,
                receiverPostalCode, height, width, length, weight);
        allItems.add(newPackage);

        System.out.println("Package received successfully.");
    }

    private static void displayAllItems(ArrayList<DeliveryItem> allItems) {
        if (allItems.isEmpty()) {
            System.out.println("No items to display.");
            return;
        }

        System.out.println("All Items:");

        for (DeliveryItem item : allItems) {
            if (item instanceof Envelope) {
                System.out.println(((Envelope) item).toString());
            } else if (item instanceof Package) {
                System.out.println(((Package) item).toString());
            }
        }
    }

    private static void displayItemsByStatus(ArrayList<DeliveryItem> allItems,
            String status) {
        if (allItems.isEmpty()) {
            System.out.println("No items to display.");
            return;
        }

        System.out.println("Items with Status '" + status + "':");

        for (DeliveryItem item : allItems) {
            if (item.getStatusString().equalsIgnoreCase(status)) {
                if (item instanceof Envelope) {
                    System.out.println(((Envelope) item).toString());
                } else if (item instanceof Package) {
                    System.out.println(((Package) item).toString());
                }
            }
        }
    }

    private static void displayAllDrivers(ArrayList<Driver> allDrivers) {
        if (allDrivers.isEmpty()) {
            System.out.println("No drivers to display.");
            return;
        }

        System.out.println("All Drivers:");

        for (Driver driver : allDrivers) {
            System.out.println(driver.toString());
            System.out.println("---------------");
        }
    }

    private static void assignItemToDriver(Scanner scanner,
            ArrayList<DeliveryItem> allItems, ArrayList<Driver> drivers) {
        System.out.println("Enter the serial number of the item"
                + " you want to assign to a driver:");
        int serialNumber = scanner.nextInt();

        DeliveryItem itemToAssign = findItemBySerialNumber(serialNumber, allItems);

        if (itemToAssign != null) {
            System.out.println("Enter the name of the driver to whom"
                    + " you want to assign the item:");
            scanner.nextLine(); 
            String driverName = scanner.nextLine();

            Driver assignedDriver = findDriverByName(driverName, drivers);

            if (assignedDriver != null) {
                boolean assignmentSuccessful
                        = assignedDriver.assignDelivery(itemToAssign);

                if (assignmentSuccessful) {
                    System.out.println("Item successfully assigned to driver: "
                            + assignedDriver.getName());
                } else {
                    System.out.println("Failed to assign item to driver."
                            + " Check driver's capacity and active zone.");
                }
            } else {
                System.out.println("Driver not found."
                        + " Please check the driver name.");
            }
        } else {
            System.out.println("Item not found. Please check the serial number.");
        }
    }

// Helper method to find a delivery item by serial number
    private static DeliveryItem findItemBySerialNumber(int serialNumber,
            ArrayList<DeliveryItem> allItems) {
        for (DeliveryItem item : allItems) {
            if (item.getSerialNumber() == serialNumber) {
                return item;
            }
        }
        return null;
    }

// Helper method to find a driver by name
    private static Driver findDriverByName(String name, ArrayList<Driver> drivers) {
        for (Driver driver : drivers) {
            if (driver.getName().equalsIgnoreCase(name)) {
                return driver;
            }
        }
        return null;
    }

    private static void setItemToReceived(Scanner scanner,
            ArrayList<DeliveryItem> allItems) {
        System.out.println("Enter the serial number of the item"
                + " you want to mark as received:");
        int serialNumber = scanner.nextInt();

        DeliveryItem itemToReceive
                = findItemBySerialNumber(serialNumber, allItems);

        if (itemToReceive != null) {
            itemToReceive.setStatus('R');
            System.out.println("Item successfully marked as received.");
        } else {
            System.out.println("Item not found. Please check the serial number.");
        }
    }

// Helper method to find a delivery item by serial number
    private static void checkDriverLoad(Scanner scanner, ArrayList<Driver> drivers) {
        System.out.println("Enter the name of the driver"
                + " whose load you want to check:");
        String driverName = scanner.next();

        Driver driverToCheck = findDriverByName(driverName, drivers);

        if (driverToCheck != null) {
            System.out.println("Current load for " + driverToCheck.getName()
                    + ":");
            System.out.println("Weight: " + driverToCheck.getCurrentWeight()
                    + " kg");
            System.out.println("Volume: " + driverToCheck.getCurrentVolume()
                    + " cubic units");
        } else {
            System.out.println("Driver not found. Please check the driver's name.");
        }
    }

    private static void displayTotalCost(ArrayList<DeliveryItem> allItems) {
        double totalCost = 0.0;

        for (DeliveryItem item : allItems) {
            totalCost += item.getCost();
        }

        System.out.println("Total Cost of All Items: $" + totalCost);
    }

}
