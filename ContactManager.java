//The Contact Management System is a classic beginner-friendly Java DSA + OOP project that uses:
// ✅ Arrays / ArrayList
// ✅ Strings
// ✅ Searching (by name, phone)
// ✅ Sorting (by name or number)
// ✅ Menu-driven interfac

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class ContactManager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n* Contact Management System *");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> updateContact();
                case 5 -> deleteContact();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
                // case 6 -> System.out.println("6. Sort by Name");
                // case 7 -> System.out.println("7. Sort by Phone");
                // case 8 ->System.out.println("8. Exit");
            }
        } while (choice != 6);
    }

    // 1. Add Contact
    public static void addContact() {
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added!");
    }

    // 2. View Contacts
    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No Contacts Added ");
        } else {
            System.out.println("\nAll Contacts: ");
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }

    // 3. Search Contact
    static void searchContact() {
        System.out.print("Enter Name or Phone to search: ");
        String query = sc.nextLine();
        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(query) || c.phone.equals(query)) {
                System.out.println("Found: " + c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found ");
        }
    }

    // 4. Update Contact
    static void updateContact() {
        System.out.print("Enter name of Contact to Update: ");
        String name = sc.nextLine();
        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.print("Enter New Number: ");
                c.phone = sc.nextLine();
                System.out.println("Contact Updated");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found ");
        }
    }

    // 5. Delete Contact
    static void deleteContact() {
        System.out.print("Enter name of Contact to Delete: ");
        String name = sc.nextLine();
        boolean removed = false;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(name)) {
                contacts.remove(i); // ✅ actually removes the contact
                removed = true;
                break; // remove only first match
            }
        }

        if (removed) {
            System.out.println("Contact deleted!");
        } else {
            System.out.println("Contact not found.");
        }

    }

    // 6. Sort by Name
    // static void sortByName() {
    // if (contacts.isEmpty()) {
    // System.out.println("No contacts to sort.");
    // return;
    // }

    // contacts.sort(Comparator.comparing(c -> c.name.toLowerCase()));
    // System.out.println("Contacts sorted by name!");
    // }

    // 7. Sort by PhoneNo.
    // static void sortByPhone() {
    // if (contacts.isEmpty()) {
    // System.out.println("No contacts to sort.");
    // return;
    // }

    // contacts.sort(Comparator.comparing(c -> c.phone));
    // System.out.println("Contacts sorted by phone!");
    // }

}

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone;
    }
}
