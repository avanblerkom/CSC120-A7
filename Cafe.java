/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

  private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
  private int nSugarPackets; // The number of sugar packets remaining in inventory
  private int nCreams; // The number of "splashes" of cream remaining in inventory
  private int nCups; // The number of cups remaining in inventory

  // Constructor to initialize the Cafe with starting inventory
  public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
    super(name, address, nFloors); // Call the Building constructor
    this.nCoffeeOunces = nCoffeeOunces;
    this.nSugarPackets = nSugarPackets;
    this.nCreams = nCreams;
    this.nCups = nCups;
    System.out.println("You have built a cafe: ☕");
  }

  // Method to sell coffee
  public void sellCoffee(int size, int nSugarPackets, int nCreams) {
    if (nCoffeeOunces < size || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || nCups < 1) {
      System.out.println("Not enough stock to sell coffee. Restocking...");
      restock(size, nSugarPackets, nCreams, 1); // Restock with the required amounts
    }
    // Decrease inventory
    this.nCoffeeOunces -= size;
    this.nSugarPackets -= nSugarPackets;
    this.nCreams -= nCreams;
    this.nCups -= 1;
    System.out.println("Sold a coffee of size " + size + "oz with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
  }

  // Private method to restock inventory
  public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
    this.nCoffeeOunces += nCoffeeOunces;
    this.nSugarPackets += nSugarPackets;
    this.nCreams += nCreams;
    this.nCups += nCups;
    System.out.println("Restocked: " + nCoffeeOunces + " coffee ounces, " + nSugarPackets + " sugar packets, " + nCreams + " creams, and " + nCups + " cups.");
  }

  public static void main(String[] args) {
    Cafe myCafe = new Cafe("Campus Cafe", "123 College St", 1, 100, 50, 30, 20);
    myCafe.sellCoffee(12, 2, 3);
    myCafe.sellCoffee(100, 10, 5); // This will trigger restocking
  }
}
