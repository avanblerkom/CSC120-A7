/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

    private Hashtable<String, Boolean> collection; // Collection of books with availability status

    // Constructor to initialize the Library
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors); // Call the Building constructor
        this.collection = new Hashtable<String, Boolean>(); // Initialize the collection as an empty Hashtable
        System.out.println("You have built a library: 📖");
    }

    // Add a book title to the collection
    public void addTitle(String title) {
        if (!collection.containsKey(title)) {
            collection.put(title, true); // Add the book as available
            System.out.println("Added \"" + title + "\" to the collection.");
        } else {
            System.out.println("The book \"" + title + "\" is already in the collection.");
        }
    }

    // Remove a book title from the collection
    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
            collection.remove(title); // Remove the book
            System.out.println("Removed \"" + title + "\" from the collection.");
            return title;
        } else {
            System.out.println("The book \"" + title + "\" is not in the collection.");
            return null;
        }
    }

    // Check out a book (mark it as unavailable)
    public void checkOut(String title) {
        if (collection.containsKey(title) && collection.get(title)) {
            collection.replace(title, false); // Mark the book as unavailable
            System.out.println("Checked out \"" + title + "\".");
        } else if (!collection.containsKey(title)) {
            System.out.println("The book \"" + title + "\" is not in the collection.");
        } else {
            System.out.println("The book \"" + title + "\" is already checked out.");
        }
    }

    // Return a book (mark it as available)
    public void returnBook(String title) {
        if (collection.containsKey(title) && !collection.get(title)) {
            collection.replace(title, true); // Mark the book as available
            System.out.println("Returned \"" + title + "\".");
        } else if (!collection.containsKey(title)) {
            System.out.println("The book \"" + title + "\" is not in the collection.");
        } else {
            System.out.println("The book \"" + title + "\" was not checked out.");
        }
    }

    // Check if the collection contains a specific title
    public boolean containsTitle(String title) {
        return collection.containsKey(title); // Check if the title exists in the collection
    }

    // Check if a specific title is available
    public boolean isAvailable(String title) {
        return collection.containsKey(title) && collection.get(title); // Check if the title exists and is available
    }

    // Print the entire collection
    public void printCollection() {
        if (collection.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            System.out.println("Library Collection:");
            for (String title : collection.keySet()) {
                String status = collection.get(title) ? "Available" : "Checked out";
                System.out.println("- " + title + " (" + status + ")");
            }
        }
    }

    public static void main(String[] args) {
        Library myLibrary = new Library("Neilson Library", "7 Neilson Drive", 4);
        myLibrary.addTitle("Moby Dick");
        myLibrary.addTitle("Pride and Prejudice");
        myLibrary.checkOut("Moby Dick");
        myLibrary.printCollection();
        myLibrary.returnBook("Moby Dick");
        myLibrary.printCollection();
        myLibrary.removeTitle("Pride and Prejudice");
        myLibrary.printCollection();
    }
}