package fadi_louise;

/*
 * Title: Delivery management system
 * 
 * Date: 21/11/2023
 * 
 * @author Fadi Louise
 * 
 * The purpose of the DeliveryItem class:
 * The DeliveryItem class represents a delivery item by encapsulating
its characteristics 
 * such as serial number, date, status, sender and receiver details,
cost, and insurance. It provides
 * accessor and mutator methods for setting and retrieving
these attributes' values. It also provides
 * methods for updating the status, adding or canceling insurance,
and converting a DeliveryItem
 * object to a string representation. The class has constructors for
creating a delivery item with
 * different sets of parameters. The set methods include validation
logic to ensure the input values
 * meet specific criteria.
 *  
 *  The operations done here are:
 *  
 * 1) DeliveryItem(String senderName, String receiverName, int receiverPostalCode)
 * 2) DeliveryItem(String senderName, int senderPostalCode,
String receiverName, int receiverPostalCode)
 * 3) DeliveryItem(String senderName, int senderPostalCode,
String receiverName, int receiverPostalCode,
 *                  double cost, boolean insurance)
 * 4) setSenderName(String senderName): void
 * 5) setReceiverName(String receiverName): void
 * 6) setSenderPostalCode(int senderPostalCode): void
 * 7) setReceiverPostalCode(int receiverPostalCode): void
 * 8) setCost(double cost): void
 * 9) setInsurance(boolean insurance): void
 * 10) setStatus(char status): void
 * 11) addInsurance(): void
 * 12) cancelInsurance(): void
 * 13) toString(): String
 * 14) getSerialNumber(): int
 * 15) getDate(): Date
 * 16) getStatus(): char
 * 17) getSenderName(): String
 * 18) getReceiverName(): String
 * 19) getSenderPostalCode(): int
 * 20) getReceiverPostalCode(): int
 * 21) getCost(): double
 * 22) hasInsurance(): boolean
 * 23) getStatusString(): String
 * 
 */
import java.util.Date;

/**
 * The `DeliveryItem` class represents an item to be delivered. It includes
 * information such as sender, receiver, delivery status, cost, and insurance.
 * This class serves as a base class for more specific delivery item types.
 */
public class DeliveryItem {

    private static int serialGenerator = 1000;

    private int serialNumber;
    private java.util.Date date;
    private char status;
    private String senderName;
    private String receiverName;
    private int senderPostalCode;
    private int receiverPostalCode;
    private double cost;
    private boolean insurance;

    /**
     * Constructor for creating a DeliveryItem with minimal information by
     * calling this constructor.
     *
     * @param senderName The name of the sender.
     * @param receiverName The name of the receiver.
     * @param receiverPostalCode The postal code of the receiver.
     */
    public DeliveryItem(String senderName, String receiverName,
            int receiverPostalCode) {
        this(senderName, 10000, receiverName, receiverPostalCode);
    }

    /**
     * Constructor for creating a DeliveryItem with more details by calling this
     * constructor.
     *
     * @param senderName The name of the sender.
     * @param senderPostalCode The postal code of the sender.
     * @param receiverName The name of the receiver.
     * @param receiverPostalCode The postal code of the receiver.
     * @param cost The cost of delivery.
     * @param insurance Whether insurance is opted for.
     */
    public DeliveryItem(String senderName, int senderPostalCode,
            String receiverName, int receiverPostalCode) {
        this(senderName, senderPostalCode, receiverName, receiverPostalCode,
                2, false);
    }

    /**
     * Constructor for creating a DeliveryItem with more details.
     *
     * @param senderName The name of the sender.
     * @param senderPostalCode The postal code of the sender.
     * @param receiverName The name of the receiver.
     * @param receiverPostalCode The postal code of the receiver.
     * @param cost The cost of delivery.
     * @param insurance Whether insurance is opted for.
     */
    public DeliveryItem(String senderName, int senderPostalCode,
            String receiverName, int receiverPostalCode, double cost,
            boolean insurance) {
        setSenderName(senderName);
        setSenderPostalCode(senderPostalCode);
        setReceiverName(receiverName);
        setReceiverPostalCode(receiverPostalCode);
        setCost(cost);
        setInsurance(insurance);
        creating();
    }

    /**
     * Initializes common attributes of the `DeliveryItem` class.
     */
    private void creating() {
        this.serialNumber = serialGenerator++;
        this.date = new Date();
        this.status = 'R';
    }

    /**
     * Gets the unique serial number of the delivery item.
     *
     * @return The serial number of the delivery item.
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * Gets the date when the delivery item is received.
     *
     * @return The date of the delivery item.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the current status of the delivery item.
     *
     * @return The status of the delivery item.
     */
    public char getStatus() {
        return status;
    }

    /**
     * Gets the name of the sender.
     *
     * @return The name of the sender.
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Gets the name of the receiver.
     *
     * @return The name of the receiver.
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * Gets the postal code of the sender.
     *
     * @return The postal code of the sender.
     */
    public int getSenderPostalCode() {
        return senderPostalCode;
    }

    /**
     * Gets the postal code of the receiver.
     *
     * @return The postal code of the receiver.
     */
    public int getReceiverPostalCode() {
        return receiverPostalCode;
    }

    /**
     * Gets the cost of the delivery item.
     *
     * @return The cost of the delivery item.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Checks if the sender has opted for insurance.
     *
     * @return True if insurance is opted for, false otherwise.
     */
    public boolean hasInsurance() {
        return insurance;
    }

    public String getStatusString() {
        switch (status) {
            case 'R':
                return "Received";
            case 'A':
                return "Assigned";
            case 'D':
                return "Delivered";
            default:
                return "Unknown";
        }
    }

    /**
     * Sets the date of the delivery item.
     *
     * @param date The date of the delivery item.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the name of the sender.
     *
     * @param senderName The name of the sender.
     */
    public void setSenderName(String senderName) {
        if (!senderName.isEmpty()) {
            this.senderName = senderName;
        } else {
            this.senderName = null;
        }
    }

    /**
     * Sets the name of the receiver.
     *
     * @param receiverName The name of the receiver.
     */
    public void setReceiverName(String receiverName) {
        if (!receiverName.isEmpty()) {
            this.receiverName = receiverName;
        } else {
            this.receiverName = null;
        }
    }

    /**
     * Sets the postal code of the sender.
     *
     * @param senderPostalCode The postal code of the sender.
     */
    public void setSenderPostalCode(int senderPostalCode) {
        if (senderPostalCode > 0) {
            this.senderPostalCode = senderPostalCode;
        } else {
            this.senderPostalCode = 10000;
        }
    }

    /**
     * Sets the postal code of the receiver.
     *
     * @param receiverPostalCode The postal code of the receiver.
     */
    public void setReceiverPostalCode(int receiverPostalCode) {
        if (receiverPostalCode > 0) {
            this.receiverPostalCode = receiverPostalCode;
        } else {
            this.receiverPostalCode = 10000;
        }
    }

    /**
     * Sets the cost of the delivery item.
     *
     * @param cost The cost of the delivery item.
     */
    public void setCost(double cost) {
        if (cost > 0) {
            this.cost = cost;
        } else {
            this.cost = 2;
        }
    }

    /**
     * Sets whether the sender has opted for insurance.
     *
     * @param insurance Whether insurance is opted for.
     */
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    /**
     * Sets the status of the delivery item.
     *
     * @param status The new status to be set ('A' for Assigned, 'D' for
     * Delivered, 'R' for Received).
     */
    public void setStatus(char status) {
        if (status == 'A' || status == 'D' || status == 'R') {
            this.status = status;
        } else {
            this.status = 'R';
        }
    }

    /**
     * Adds insurance to the delivery item.
     */
    public void addInsurance() {
        if (!insurance) {
            insurance = true;
            cost += 3;
        }
    }

    /**
     * Cancels insurance for the delivery item.
     */
    public void cancelInsurance() {
        if (insurance) {
            insurance = false;
            cost -= 3;
        }
    }

    /**
     * Returns a string representation of the DeliveryItem.
     *
     * @return A string representation of the DeliveryItem.
     */
    @Override
    public String toString() {

        String insuranceStatus = insurance ? "With insurance"
                : "Without insurance";

        return "[" + serialNumber + "] - [" + date + "]\n"
                + "Sender: " + senderName + " - " + senderPostalCode + "\n"
                + "Receiver: " + receiverName + " - " + receiverPostalCode + "\n"
                + "[" + insuranceStatus + "]\n"
                + "Status: " + getStatusString();
    }

}
