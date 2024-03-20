// Andrew Robbins
// 2/9/2024
// CS 145
// Assingment 2: Phone Book
import java.util.*;
// This class houses the main method
public class TestClass {
    // main method for the program, calls the appropriate methods to start the program
    public static void main(String[] args) {
        // Adding this universal scanner was a huge upgrade to my program, although it 
        // took quite a bit of editing, it replaced probably 10 seperate scanners.
        Scanner scanner = new Scanner(System.in);
        PhoneBook.intro();
        PhoneBook.scanner(scanner);
        scanner.close();
    }
}