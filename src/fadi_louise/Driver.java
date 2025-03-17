package fadi_louise;

/*
 * Title: Delivery management system
 *
 * Date: 21/11/2023
 *
 * @author Fadi Louise
 *
 * The purpose of the Driver class:
 * The `Driver` class represents a driver in a delivery
 * company management system. It includes attributes such as name, active
 * delivery zone, assigned deliveries, car registration number, maximum weight
 * capacity, maximum volume capacity, current weight, and current volume. The
 * class provides constructors for creating driver objects with different sets
 * of parameters. It includes setter and getter methods for updating and
 * retrieving the attributes. The class also provides methods to assign and
 * accomplish deliveries, and it checks whether a delivery is within the
 * driver's active zone before assignment. The `toString` method is overridden
 * to create a detailed string representation of a `Driver` object.
 *
 * The operations done here are:
 * 1) Driver(String name)
 * 2) Driver(String name, String carRegistrationNb, double maxWeight,
 * double maxVolume, int[] zone)
 * 3) setName(String name): void
 * 4) setZone(int[] zone): void
 * 5) setCarRegistrationNb(String carRegistrationNb): void
 * 6) setMaxWeight(double maxWeight): void
 * 7) setMaxVolume(double maxVolume): void
 * 8) getName(): String
 * 9) getZone(): int[]
 * 10) getDeliveries(): ArrayList<DeliveryItem>
 * 11) getCarRegistrationNb(): String
 * 12) getMaxWeight(): double
 * 13) getMaxVolume(): double
 * 14) getCurrentWeight(): double
 * 15) getCurrentVolume(): double
 * 16) assignDelivery(DeliveryItem item): boolean
 * 17) accomplishDelivery(int serialNumber): boolean
 * 18) toString(): String (Overrides the toString method in the Object class)
 *
 */
import java.util.ArrayList;

public class Driver {

    private String name;
    private int[] zone = {10000, 50000};
    private ArrayList<DeliveryItem> deliveries = new ArrayList<>();
    private String carRegistrationNb;
    private double maxWeight;
    private double maxVolume;
    private double currentWeight = 0;
    private double currentVolume = 0;

    /**
     * Constructor for creating a driver with minimal information.
     *
     * @param name The name of the driver.
     */
    public Driver(String name) {
        this(name, "", 0.0, 0.0, new int[]{10000, 50000});
    }

    /**
     * Constructor for creating a driver with more details.
     *
     * @param name The name of the driver.
     * @param carRegistrationNb The car registration number of the driver.
     * @param maxWeight The maximum weight capacity of the driver.
     * @param maxVolume The maximum volume capacity of the driver.
     * @param zone The active delivery zone of the driver.
     */
    public Driver(String name, String carRegistrationNb, double maxWeight,
            double maxVolume, int[] zone) {
        setName(name);
        setCarRegistrationNb(carRegistrationNb);
        setMaxWeight(maxWeight);
        setMaxVolume(maxVolume);
        setZone(zone);
    }

    /**
     * Gets the name of the driver.
     *
     * @return The name of the driver.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the active delivery zone of the driver.
     *
     * @return The active delivery zone as an array of two integers.
     */
    public int[] getZone() {
        return zone;
    }

    /**
     * Gets the list of deliveries assigned to the driver.
     *
     * @return The list of deliveries assigned to the driver.
     */
    public ArrayList<DeliveryItem> getDeliveries() {
        return deliveries;
    }

    /**
     * Gets the car registration number of the driver.
     *
     * @return The car registration number of the driver.
     */
    public String getCarRegistrationNb() {
        return carRegistrationNb;
    }

    /**
     * Gets the maximum weight capacity of the driver.
     *
     * @return The maximum weight capacity of the driver.
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Gets the maximum volume capacity of the driver.
     *
     * @return The maximum volume capacity of the driver.
     */
    public double getMaxVolume() {
        return maxVolume;
    }

    /**
     * Gets the current weight of the driver.
     *
     * @return The current weight capacity of the driver.
     */
    public double getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Gets the current volume of the driver.
     *
     * @return The current volume capacity of the driver.
     */
    public double getCurrentVolume() {
        return currentVolume;
    }

    /**
     * Sets the name of the driver.
     *
     * @param name The name of the driver.
     */
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    /**
     * Sets the active delivery zone of the driver.
     *
     * @param zone The active delivery zone as an array of two integers.
     */
    public void setZone(int[] zone) {
        this.zone = zone;
    }

    /**
     * Sets the car registration number of the driver. If the provided
     * registration number is empty, it sets a default value.
     *
     * @param carRegistrationNb The car registration number of the driver.
     */
    public void setCarRegistrationNb(String carRegistrationNb) {
        if (!carRegistrationNb.isEmpty()) {
            this.carRegistrationNb = carRegistrationNb;
        } else {
            this.carRegistrationNb = " ";
        }
    }

    /**
     * Sets the maximum weight capacity of the driver. If the provided maximum
     * weight is less than or equal to 0, it sets a default value.
     *
     * @param maxWeight The maximum weight capacity of the driver.
     */
    public void setMaxWeight(double maxWeight) {
        if (maxWeight > 0) {
            this.maxWeight = maxWeight;
        } else {
            this.maxWeight = 500;
        }
    }

    /**
     * Sets the maximum volume capacity of the driver. If the provided maximum
     * volume is less than or equal to 0, it sets a default value.
     *
     * @param maxVolume The maximum volume capacity of the driver.
     */
    public void setMaxVolume(double maxVolume) {
        if (maxVolume > 0) {
            this.maxVolume = maxVolume;
        } else {
            this.maxVolume = 50;
        }
    }

    /**
     * Assigns a delivery item to the driver. It checks if the delivery is
     * within the driver's active zone by comparing the receiver's postal code.
     * If the delivery is within the zone, it further checks whether the item is
     * a `Package` or an `Envelope`. For a `Package`, it verifies that adding
     * its weight and volume won't exceed the maximum weight and volume capacity
     * of the driver. If these conditions are met, the item is added to the
     * driver's list of deliveries, and the current weight and volume are
     * updated. Returns true if the assignment is successful; otherwise, returns
     * false.
     *
     * @param item The delivery item to be assigned.
     * @return True if the assignment is successful, false otherwise.
     */
    public boolean assignDelivery(DeliveryItem item) {

        if (isInZone(item.getReceiverPostalCode())) {
            if (item instanceof Package) {

                if (currentWeight + ((Package) item).getWeight() <= maxWeight
                        && currentVolume
                        + ((Package) item).getVolume() <= maxVolume) {
                    deliveries.add(item);
                    currentWeight += ((Package) item).getWeight();
                    currentVolume += ((Package) item).getVolume();
                    return true;
                }
            } else if (item instanceof Envelope) {

                String envelopeSize = ((Envelope) item).getSize();

                if (!envelopeSize.isEmpty()) {
                    deliveries.add(item);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Private method to check whether a given postal code is within the
     * driver's active delivery zone.
     *
     * @param postalCode The postal code to be checked.
     * @return True if the postal code is within the active zone, false
     * otherwise.
     */
    private boolean isInZone(int postalCode) {
        return postalCode >= zone[0] && postalCode <= zone[1];
    }

    /**
     * Marks a delivery as accomplished by serial number. It iterates through
     * the list of deliveries and, based on the item type (`Package` or
     * `Envelope`), updates the current weight and volume accordingly. If the
     * delivery is successfully accomplished, it is removed from the list, and
     * the method returns true. If the delivery is not found or cannot be
     * accomplished for other reasons, the method returns false.
     *
     * @param serialNumber The serial number of the delivery item to be
     * accomplished.
     * @return True if the delivery is successfully accomplished, false
     * otherwise.
     */
    public boolean accomplishDelivery(int serialNumber) {
        for (DeliveryItem item : deliveries) {
            if (item instanceof Package) {
                if (item.getSerialNumber() == serialNumber) {

                    currentWeight -= ((Package) item).getWeight();
                    currentVolume -= ((Package) item).getVolume();

                    deliveries.remove(item);
                    return true;
                }
            } else if (item instanceof Envelope) {
                if (item.getSerialNumber() == serialNumber) {

                    deliveries.remove(item);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Provides a string representation of the driver.
     *
     * @return A string representation of the driver.
     */
    @Override
    public String toString() {
        return "[" + name + "]\n"
                + "Active Zone: [" + zone[0] + " - " + zone[1] + "]\n"
                + "Car: [" + carRegistrationNb + "]\n"
                + "Max Weight: [" + maxWeight + "] – Max Volume [" + maxVolume
                + "]";
    }
}
