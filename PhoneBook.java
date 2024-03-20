// Andrew Robbins
// 2/9/2024
// CS 145
// Assingment 2: Phone Book

import java.util.*;
// This Program is designed to create a phone book filled with contacts,
// it is capable of adding, deleting, showing and editing any part of any contact,
// as well as searching for contacts by name or phone number.
public class PhoneBook {
    private static LinkedList<PhoneBookNode> contacts = new LinkedList<>();

    // Prints an intro menu
    public static void intro() {
        System.out.println("");
        System.out.println("Welcome, please choose an option");
        System.out.println("1 - Add a contact");
        System.out.println("2 - Delete a contact");
        System.out.println("3 - Show all contacts");
        System.out.println("4 - Search by name");
        System.out.println("5 - Search by phone number");
        System.out.println("6 - Edit a contacts city");
        System.out.println("7 - Edit a contact name");
        System.out.println("8 - Edit an address");
        System.out.println("9 - Edit a phone number");
        System.out.println("0 - Quit"); 
        System.out.println("m - Show the menu again");
        System.out.println(""); 
    }

    // Gives the intro menu function by calling the correct methods.
    public static void scanner(Scanner scanner) {
        String intro = scanner.nextLine();
        if (intro != null && intro.length() > 0) {
            intro = intro.substring(0, 1);
        } else {
            intro = "";
        }
        if (intro.equals ("1") || (intro.equals("a"))) {
            System.out.println(""); 
            System.out.println("Adding a new contact..");
            System.out.println(""); 
            addContact(scanner);
        } else if (intro.equals ("2") || (intro.equals("d"))) {
            deleteContact(scanner);
        } else if (intro.equals ("3") || (intro.equals("s"))) {
            System.out.println(""); 
            showAllContacts(scanner);
        } else if (intro.equals ("4")) {
            searchByName(scanner);
        } else if (intro.equals ("5")) {
            searchByPhoneNumber(scanner);
        } else if (intro.equals ("6")) {
            System.out.println("");
            System.out.println("Editing a contacts city");
            editContactCity(scanner);
        } else if (intro.equals ("7")) {
            System.out.println(""); 
            System.out.println("Editing a contact"); 
            editContactName(scanner);
        } else if (intro.equals ("8")) {
            System.out.println(""); 
            System.out.println("Editing an address"); 
            editContactAddress(scanner);
        } else if (intro.equals ("9")) {
            System.out.println(""); 
            System.out.println("Editing a phone number"); 
            editContactPhoneNumber(scanner);
        } else if (intro.equals ("m") || (intro.equals("M"))) {
            System.out.println("");
            intro();
            scanner(scanner);
        } else if (intro.equals ("0") || (intro.equals("q")) 
        || (intro.equals("Q"))) {
            System.out.println("Shutting down...");
            System.out.println("");
            System.exit(0);
        } else {
            scanner(scanner);
        }
    }

    // Adds a single contact to the list
    public static void addContact(Scanner scanner) {
        System.out.print("Please input first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please input last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please input address: ");
        String address = scanner.nextLine();

        System.out.print("Please input city: ");
        String city = scanner.nextLine();

        System.out.print("Please input phone number: ");
        String phoneNumber = scanner.nextLine();

        // Saves the contact to PhoneBookNode
        PhoneBookNode newContact = new PhoneBookNode(firstName, 
        lastName, address, city, phoneNumber);
        contacts.add(newContact);

        intro();
        scanner(scanner);
    }

    // Shows our contact list.
    public static void showAllContacts(Scanner scanner) {
        int num = 1; 
        System.out.println("Your contacts:"); 
        System.out.println(""); 
        for (PhoneBookNode contact : contacts) {
            System.out.println("Contact Number: " + num);
            System.out.println(contact);
            num ++;
        }
        System.out.println("Enter m to see the menu again");
        System.out.println(""); 
        scanner(scanner);
    }
    
    // Enables user to edit the name of any contact
    public static void editContactName(Scanner scanner) {
        System.out.print("Enter the contact number you want to edit: ");
        
        // Solves issues with errors on non integer input
        if (!scanner.hasNextInt()) {
            System.out.println();
            System.out.println("Please enter a numeric value");
            System.out.println();
            scanner.next();
            editContactName(scanner);
        }else {
            int contactNumber = scanner.nextInt();
            System.out.println("");
            scanner.nextLine(); // Eats the false input

            if (contactNumber >= 1 && contactNumber <= contacts.size()) {

                // Retrieve the contact and update the name
                PhoneBookNode contactToEdit = contacts.get(contactNumber - 1);
                System.out.print("Enter a new first name: ");
                String newFirstName = scanner.nextLine();

                // Use the correct setter method to update the name
                contactToEdit.setFirstName(newFirstName);
                System.out.print("Enter a new last name: "); 
                String newLastName = scanner.nextLine();
                contactToEdit.setLastName(newLastName);
                System.out.println("Contact name updated successfully!");
                intro();
                scanner(scanner);
            // Only allows you to use a contact number you have.
            } else {
                System.out.println();
                System.out.println("Invalid contact number. Please try again.");
                System.out.println();
                editContactName(scanner);
            }
        }
    }


    // Lets the user edit a contacts phone number
    public static void editContactPhoneNumber(Scanner scanner) {
        System.out.print("Enter the contact number you want to edit: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println();
            System.out.println("Please enter a numeric value");
            System.out.println();
            scanner.next();
            editContactPhoneNumber(scanner);
        }else {
            int contactNumber = scanner.nextInt();
            scanner.nextLine();

            if (contactNumber >= 1 && contactNumber <= contacts.size()) {
                PhoneBookNode contactToEdit = contacts.get(contactNumber - 1);
                System.out.println();
                System.out.print("Enter the new phone number: ");
                String newNumber = scanner.nextLine();

                contactToEdit.setPhoneNumber(newNumber);
                System.out.println("Contact phone number updated successfully!");
                intro();
                scanner(scanner);
            } else {
                System.out.println();
                System.out.println("Invalid contact number. Please try again.");
                System.out.println();
                editContactPhoneNumber(scanner);
            }
        }
    }
    
    // Allows the user to edit a contact address
    public static void editContactAddress(Scanner scanner) {
        System.out.print("Enter the contact number you want to edit: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println();
            System.out.println("Please enter a numeric value");
            System.out.println();
            scanner.next();
            editContactAddress(scanner);
        }else {
            int contactNumber = scanner.nextInt();
            scanner.nextLine();

            if (contactNumber >= 1 && contactNumber <= contacts.size()) {
                PhoneBookNode contactToEdit = contacts.get(contactNumber - 1);
                System.out.println();
                System.out.print("Enter the new address: ");
                String newAddress = scanner.nextLine();
                contactToEdit.setAddress(newAddress);
                System.out.println("Contact address updated successfully!");
                intro();
                scanner(scanner);
            } else {
                System.out.println();
                System.out.println("Invalid contact number. Please try again.");
                System.out.println();
                editContactAddress(scanner);
            }
        }
    }

    // Allows the user to edit a contacts city
    public static void editContactCity(Scanner scanner) {
        System.out.print("Enter the contact number you want to edit: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println();
            System.out.println("Please enter a numeric value");
            System.out.println();
            scanner.next();
            editContactCity(scanner);
        }else {
            int contactNumber = scanner.nextInt();
            scanner.nextLine();

            if (contactNumber >= 1 && contactNumber <= contacts.size()) {
                PhoneBookNode contactToEdit = contacts.get(contactNumber - 1);
                System.out.println();
                System.out.print("Enter the new city: ");
                String newCity = scanner.nextLine();
                contactToEdit.setCity(newCity);
                System.out.println();
                System.out.println("Contact city updated successfully!");
                intro();
                scanner(scanner);
            } else {
                System.out.println();
                System.out.println("Invalid contact number. Please try again.");
                System.out.println();
                editContactCity(scanner);
            }
        }
    }

    // Deletes a contact, this simply removes the contact from the list
    // all other contacts will move up the list to fill in
    public static void deleteContact(Scanner scanner) {
        System.out.print("Enter the contact number you want to delete: ");


        if (!scanner.hasNextInt()) {
            System.out.println("");
            System.out.println("Please enter a numeric value");
            System.out.println("");
            scanner.next();
            deleteContact(scanner);
        } else {
            int contactNumber = scanner.nextInt();
            if (contactNumber >= 1 && contactNumber <= contacts.size()) {

                // Remorves the contact
                PhoneBookNode deletedContact = contacts.remove(contactNumber - 1);
                System.out.println("Contact deleted successfully:");
                System.out.println(deletedContact);
                intro();
                scanner(scanner);
            } else {
                System.out.println("Invalid contact number. Please try again.");
                System.out.println();
                deleteContact(scanner);
            }
        }
    }

    // Search by name
    public static void searchByName(Scanner scanner) {
        System.out.print("Enter the first name to search: ");
        String searchFirstName = scanner.nextLine();
        System.out.print("Enter the last name to search: ");
        String searchLastName = scanner.nextLine();
        boolean found = false;

        // Searches the list for the name given
        for (PhoneBookNode contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(searchFirstName) &&
                contact.getLastName().equalsIgnoreCase(searchLastName)) {
                System.out.println("Contact found:\n" + contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
        System.out.println("");
        System.out.println("Enter m to see the menu again");
        System.out.println(""); 
        scanner(scanner);
    }
    
    // Search contacts by phone number
    public static void searchByPhoneNumber(Scanner scanner) {
        System.out.print("Enter the phone number to search: ");
        String searchPhoneNumber = scanner.nextLine();
        boolean found = false;

        for (PhoneBookNode contact : contacts) {
            if (contact.getPhoneNumber().equals(searchPhoneNumber)) {
                System.out.println("Contact found:\n" + contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
        System.out.println(""); 
        System.out.println("Enter m to see the menu again");
        System.out.println("");
        scanner(scanner);
    }
}