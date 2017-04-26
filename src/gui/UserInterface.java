package gui;

import java.util.Scanner;

import contacts.Contact;
import phoneBook.BinarySearchTree;

public class UserInterface {

	private BinarySearchTree bst;

	public UserInterface() {
		bst = new BinarySearchTree();
	}

	public static void main(String[] args) {
		
		UserInterface gui = new UserInterface();
		Scanner input = new Scanner(System.in);
		gui.operation(input);

	}

	public void operation(Scanner input) {
		
		String message = "Write command: all, add, remove, search or exit:";
		System.out.println(message);
		String command = input.nextLine();
		
		switch (command) {
		case "all":
			showAllContacts();
			operation(input);
			break;
		case "add":
			add(input);
			operation(input);
			break;
		case "remove":
			remove(input);
			operation(input);
			break;
		case "search":
			System.out.println(search(input));
			operation(input);
			break;
		case "exit":
			System.out.println("Exit application! Bye! :)");
			input.close();
			break;
		default:
			System.out.println("Invalid command");
			operation(input);
			break;
		}
	}

	public void showAllContacts() {
		bst.getAllContacts();
	}

	public void add(Scanner input) {
		
		System.out.println("Write name: ");
		String name = input.nextLine();
		System.out.println("Write number: ");
		long number = validateNumber(input);
		if (number != 0) {
			Contact newContact = new Contact(name, number);
			if (bst.add(newContact)) {
				System.out.println(newContact + " added!");
			} else {
				System.err.println("contact with such name or number already exists!");
			}
		} else {
			System.out.println("0 cannot be phone number!");
		}
	}

	private long validateNumber(Scanner input) {
		try {
			return Long.parseLong(input.nextLine());
		} catch (NumberFormatException ex) {
			System.err.println("Invalid number!");
			return 0;
		}
	}
	
	public Contact search(Scanner input) {
		
		System.out.println("Enter name: ");
		String name = input.nextLine();
		Contact found = bst.search(name);
		if (found == null) {
			System.out.println("Contact with name: " + name + " not found!");
			return null;
		} else {
			return found;
		}
	}
	
	public void remove(Scanner input) {
		
		Contact toRemove = search(input);
		if (toRemove != null) {
			System.out.println(toRemove + " deleted successfully!");
			bst.remove(toRemove);
		}
	}
}
