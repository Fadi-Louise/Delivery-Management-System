package fadi_louise;

/*
 * Title: Delivery management system
 * 
 * Date: 21/11/2023
 * 
 * @author Fadi Louise
 *
 * The purpose of the Package class:
 * The Package class represents a package, a type of delivery item in
 * a delivery company management system. 
 * It extends the `DeliveryItem` class and includes additional attributes
 * such as height, width, length, weight, and volume. 
 * The class provides constructors for creating package objects with
 * different sets of parameters. 
 * It includes setter and getter methods for updating and retrieving
 * the dimensions and weight attributes. 
 * The class overrides the `toString` method to provide a customized string
 * representation of a package object.
 * The private `setVolume` method is used to calculate and set the volume
 * based on the dimensions. The private `setCost` method is used to calculate
 * and set the delivery cost based on the volume, weight, and insurance status.
 * 
 * The operations done here are:
 *  
 * 1) Package(String senderName, String receiverName,
 *    int receiverPostalCode, double height, double width,
 *    double length, double weight)
 * 2) Package(String senderName, int senderPostalCode, String receiverName,
 *    int receiverPostalCode, double height, double width, double length,
 *    double weight)
 * 3) setHeight(double height): void
 * 4) setWidth(double width): void
 * 5) setLength(double length): void
 * 6) setWeight(double weight): void
 * 7) setVolume(): void
 * 8) setCost(): void
 * 9) getHeight(): double
 * 10) getWidth(): double
 * 11) getLength(): double
 * 12) getWeight(): double
 * 13) getVolume(): double
 * 14) toString(): String (Overrides the toString method in the superclass)
 * 
 */
public class Package extends DeliveryItem {

    private double height;
    private double width;
    private double length;
    private double weight;
    private double volume;

    /**
     * Constructor for creating a package with minimal information.
     *
     * @param senderName The name of the sender.
     * @param receiverName The name of the receiver.
     * @param receiverPostalCode The postal code of the receiver.
     * @param height The height of the package.
     * @param width The width of the package.
     * @param length The length of the package.
     * @param weight The weight of the package.
     */
    public Package(String senderName, String receiverName,
            int receiverPostalCode, double height, double width,
            double length, double weight) {
        this(senderName, 10000, receiverName, receiverPostalCode,
                height, width, length, weight);
    }

    /**
     * Constructor for creating a package with more details.
     *
     * @param senderName The name of the sender.
     * @param senderPostalCode The postal code of the sender.
     * @param receiverName The name of the receiver.
     * @param receiverPostalCode The postal code of the receiver.
     * @param height The height of the package.
     * @param width The width of the package.
     * @param length The length of the package.
     * @param weight The weight of the package.
     */
    public Package(String senderName, int senderPostalCode, String receiverName,
            int receiverPostalCode, double height, double width, double length,
            double weight) {
        super(senderName, senderPostalCode, receiverName, receiverPostalCode);
        setHeight(height);
        setWidth(width);
        setLength(length);
        setWeight(weight);
        setVolume();
        setCost();
    }

    /**
     * Private method to set the volume of the package according to its
     * dimensions.
     */
    private void setVolume() {
        this.volume = height * width * length;
    }

    /**
     * Private method to set the cost of the package based on conditions. It
     * calculates the base cost depending on the volume and weight, and adds
     * additional cost for insurance if opted for.
     */
    private void setCost() {
        double originalCost;

        if (volume <= 2) {
            originalCost = 2.0 + 3 * weight;
        } else if (volume <= 5) {
            originalCost = 2.8 + 3 * weight;
        } else {
            originalCost = 2.8 + 3 * weight + 5 * (volume - 5);
        }

        if (hasInsurance()) {
            originalCost += 20 * weight;
        }

        super.setCost(originalCost);
    }

    /**
     * Gets the height of the package.
     *
     * @return The height of the package.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the width of the package.
     *
     * @return The width of the package.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the length of the package.
     *
     * @return The length of the package.
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets the weight of the package.
     *
     * @return The weight of the package.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets the volume of the package.
     *
     * @return The volume of the package.
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Sets the height of the package. If the provided height is not positive,
     * it sets the default height to 0.2.
     *
     * @param height The height of the package.
     */
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            this.height = 0.2;
        }
    }

    /**
     * Sets the width of the package. If the provided width is not positive, it
     * sets the default width to 0.2.
     *
     * @param width The width of the package.
     */
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            this.width = 0.2;
        }
    }

    /**
     * Sets the length of the package. If the provided length is not positive,
     * it sets the default length to 0.2.
     *
     * @param length The length of the package.
     */
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            this.length = 0.2;
        }
    }

    /**
     * Sets the weight of the package. If the provided weight is not positive,
     * it sets the default weight to 0.1.
     *
     * @param weight The weight of the package.
     */
    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 0.1;
        }
    }

    /**
     * Sets the volume of the package. If the provided volume is not positive,
     *
     * @param volume The volume of the package.
     */
    public void setVolume(double volume) {
        if (volume > 0) {
            this.volume = volume;
        }
    }

    /**
     * Provides a string representation of the package.
     *
     * @return A string representation of the package.
     */
    @Override
    public String toString() {

        String insuranceStatus = hasInsurance() ? "With insurance"
                : "Without insurance";

        return "Package: [" + getSerialNumber() + "] – [" + getDate() + "]\n"
                + "Dimension: [" + height + "] * [" + width + "] * [" + length
                + "]\n"
                + "Volume: [" + volume + "] – Weight: [" + weight + "]\n"
                + "Sender: " + getSenderName() + " – " + getSenderPostalCode()
                + "\n"
                + "Receiver: " + getReceiverName() + " – "
                + getReceiverPostalCode() + "\n"
                + "[" + insuranceStatus + "]\n"
                + "Status: " + getStatus() + "\n"
                + "Cost: $" + getCost();
    }
}
