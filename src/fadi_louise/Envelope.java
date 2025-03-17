package fadi_louise;

/*
 * Title: Delivery management system
 * 
 * Date: 21/11/2023
 * 
 * @author Fadi Louise
 * 
 * The purpose of the Envelope class:
 * The Envelope class represents an envelope, a type of delivery item in
a delivery company management system. 
 * It extends the DeliveryItem class and includes additional attributes
such as the size of the envelope. 
 * The class provides constructors for creating envelope objects with
different sets of parameters. 
 * It includes setter and getter methods for updating and retrieving
the size attribute. 
 * The class overrides the toString method to provide a customized string
representation of an envelope object.
 * The private setCost method is used to calculate and set the delivery
cost based on the size, insurance, sender, and receiver details.
 * 
 *  The operations done here are:
 *  
 * 1) Envelope(String senderName, String receiverName,
int receiverPostalCode, String size)
 * 2) Envelope(String senderName, int senderPostalCode,
String receiverName, int receiverPostalCode, String size)
 * 3) setSize(String size): void
 * 4) getSize(): String
 * 5) setCost(): void
 * 6) toString(): String (Overrides the toString method in the superclass)
 * 
 */
public class Envelope extends DeliveryItem {

    private String size;

    /**
     * Constructor for creating an envelope with minimal information.
     *
     * @param senderName The name of the sender.
     * @param receiverName The name of the receiver.
     * @param receiverPostalCode The postal code of the receiver.
     * @param size The size of the envelope.
     */
    public Envelope(String senderName, String receiverName,
            int receiverPostalCode, String size) {
        this(senderName, 10000, receiverName, receiverPostalCode, size);
    }

    /**
     * Constructor for creating an envelope with more details.
     *
     * @param senderName The name of the sender.
     * @param senderPostalCode The postal code of the sender.
     * @param receiverName The name of the receiver.
     * @param receiverPostalCode The postal code of the receiver.
     * @param size The size of the envelope.
     */
    public Envelope(String senderName, int senderPostalCode,
            String receiverName, int receiverPostalCode, String size) {
        super(senderName, senderPostalCode, receiverName, receiverPostalCode);
        setSize(size);
        setCost();
    }

    /**
     * Sets the size of the envelope. If the provided size is empty, it sets the
     * default size to "A2".
     *
     * @param size The size of the envelope.
     */
    public void setSize(String size) {
        if (!size.isEmpty() && "A2".equals(size)
                || "A6".equals(size)
                || "A7".equals(size)
                || "A9".equals(size)
                || "3 square".equals(size)
                || "4 square".equals(size)
                || "5 square".equals(size)) {
            this.size = size;
        } else {
            this.size = "A2";
        }
        setCost();
    }

    /**
     * Gets the size of the envelope.
     *
     * @return The size of the envelope.
     */
    // Getters
    public String getSize() {
        return size;
    }

    /**
     * Private method to set the cost of the envelope based on conditions. It
     * calculates the base cost depending on the size and adds additional cost
     * for insurance if opted for.
     */
    private void setCost() {
        double originalCost = 2.0;

        switch (size) {
            case "A2":
                originalCost = 2.0;
                break;
            case "A6":
                originalCost = 1.6;
                break;
            case "A7":
                originalCost = 1.5;
                break;
            case "A9":
                originalCost = 1.2;
                break;
            case "4 square":
                originalCost = 1.8;
                break;
            case "5 square":
                originalCost = 1.6;
                break;
            case "Add insurance":
                originalCost = 3.0;
                break;
            default:

                break;
        }

        if (hasInsurance()) {
            originalCost += 3.0;
        }

        setCost(originalCost);
    }

    /**
     * Provides a string representation of the envelope.
     *
     * @return A string representation of the envelope.
     */
    @Override
    public String toString() {

        String insuranceStatus = hasInsurance() ? "With insurance"
                : "Without insurance";

        return "Envelope: [" + getSerialNumber() + "] – [" + getDate() + "]\n"
                + "Size: [" + size + "]\n"
                + "Sender: " + getSenderName() + " – " + getSenderPostalCode()
                + "\n"
                + "Receiver: " + getReceiverName() + " – "
                + getReceiverPostalCode() + "\n"
                + "[" + insuranceStatus + "]\n"
                + "Status: " + getStatus() + "\n"
                + "Cost: $" + getCost();
    }

}
