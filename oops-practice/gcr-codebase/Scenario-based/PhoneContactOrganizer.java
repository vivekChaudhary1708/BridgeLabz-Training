import java.util.ArrayList;
import java.util.List;

class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class PhoneContactOrganizer {

    static List<Contact> contacts = new ArrayList<>();

    static void addContact(String name, String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be 10 digits");
        }

        for (Contact c : contacts) {
            if (c.phone.equals(phone)) {
                System.out.println("Duplicate contact not allowed");
                return;
            }
        }

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added");
    }

    static void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.println(c.name + " : " + c.phone);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public static void main(String[] args) throws Exception {
        addContact("Vivek", "9876543210");
        addContact("Rahul", "9876543210");
        searchContact("Vivek");
    }
}
