/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents; // List of residents
  private boolean hasDiningRoom; // Indicates if the house has a dining room

  // Constructor to initialize the House
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); // Call the Building constructor
    this.residents = new ArrayList<Student>(); // Initialize the residents list
    this.hasDiningRoom = hasDiningRoom; // Set the dining room status
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents() {
    return this.residents.size();
  }

  // Method to move a student into the house
  public void moveIn(Student s) {
    if (!this.residents.contains(s)) { // Check if the student is not already a resident
      this.residents.add(s); // Add the student to the residents list
      System.out.println(s.getName() + " has moved in.");
    } else {
      System.out.println(s.getName() + " is already a resident.");
    }
  }

  // Method to move a student out of the house
  public Student moveOut(Student s) {
    if (this.residents.remove(s)) { // Remove the student if they are a resident
      System.out.println(s.getName() + " has moved out.");
      return s; // Return the student who moved out
    } else {
      System.out.println(s.getName() + " is not a resident.");
      return null; // Return null if the student was not a resident
    }
  }

  // Method to check if a student is a resident of the house
  public boolean isResident(Student s) {
    return this.residents.contains(s); // Check if the student is in the residents list
  }

  public static void main(String[] args) {
    House myHouse = new House("Maple House", "123 Maple St", 3, true);
    System.out.println("Dining room: " + myHouse.hasDiningRoom());
    System.out.println("Number of residents: " + myHouse.nResidents());
  }
}

