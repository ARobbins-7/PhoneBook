// Andrew Robbins
// 2/9/2024
// CS 145
// Assingment 2: Phone Book'

// This class holds the information for the phonebook, as well as having methods for 
// editing parts of contacts. Also has the method for the formatting of printing 
// the list.
class PhoneBookNode {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phoneNumber;

    // Used to initalize variables
    public PhoneBookNode(String firstName, String lastName, 
    String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    // This method helps editing a contacts first name, I need two methods for 
    // first and last name because I am storing the first and last names seperatly.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // This method helps editing a contacts last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // This method helps editing a contacts address
    public void setAddress(String address) {
        this.address = address;
    }

    // This method helps editing a contacts city
    public void setCity(String city) {
        this.city = city;
    }

    // This method helps editing a contacts phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Gets a first name
    public String getFirstName() {
        return firstName;
    }

    // Gets last name
   public String getLastName() {
        return lastName;
    }

    // Gets a phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // Holds the formatting for printing the list. Not sure if this was the
    // prettiest way to print, but it seemed decent.
    @Override
    public String toString() {
        return "Full name: " + firstName + " " + lastName + "\n"
                + "Address: " + address + "\n"
                + "City: " + city + "\n"
                + "Phone Number: " + phoneNumber + "\n\n";
    }
}