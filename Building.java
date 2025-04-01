/**
 * This class represents a Building, which serves as a base class for other types of buildings.
 * It includes attributes for the building's name, address, and number of floors.
 */
public class Building {

    protected String name = "<Name Unknown>"; // Name of the building
    protected String address = "<Address Unknown>"; // Address of the building
    protected int nFloors = 1; // Number of floors in the building

    /**
     * Constructor to initialize a Building with the specified name, address, and number of floors.
     * @param name The name of the building.
     * @param address The address of the building.
     * @param nFloors The number of floors in the building.
     * @throws RuntimeException if the number of floors is less than 1.
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) {
            this.name = name;
        }
        if (address != null) {
            this.address = address;
        }
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Constructor to initialize a Building using a House object.
     * @param h The House object to copy attributes from.
     */
    public Building(House h) {
        this.name = h.getName();
        this.address = h.getAddress();
        this.nFloors = h.getFloors();
    }

    /**
     * Gets the name of the building.
     * @return The name of the building.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the address of the building.
     * @return The address of the building.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the number of floors in the building.
     * @return The number of floors in the building.
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Returns a string representation of the building.
     * @return A string describing the building.
     */
    @Override
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
     * Main method to test the Building class.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }
}
