import java.util.ArrayList;
import java.util.Scanner;

class ContactPerson {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;

    ContactPerson(String firstName, String lastName, String address,
                  String city, String state, String zip,
                  String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    void displayContact() {
        System.out.println("Name : " + firstName + " " + lastName);
        System.out.println("Address : " + address);
        System.out.println("City : " + city);
        System.out.println("State : " + state);
        System.out.println("Zip : " + zip);
        System.out.println("Phone : " + phoneNumber);
        System.out.println("Email : " + email);
        System.out.println("---------------------------");
    }
}

class AddressBook {

    ArrayList<ContactPerson> contacts = new ArrayList<>();

    void addContact(ContactPerson person) {
        contacts.add(person);
        System.out.println("Contact added successfully!");
    }

    void showContacts() {
        for (ContactPerson person : contacts) {
            person.displayContact();
        }
    }
}

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Zip: ");
        String zip = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        ContactPerson person = new ContactPerson(
                firstName, lastName, address,
                city, state, zip, phone, email
        );

        addressBook.addContact(person);
        addressBook.showContacts();
    }
}
