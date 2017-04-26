package phoneBook;

import contacts.BSTNode;
import contacts.Contact;

public class BinarySearchTree {

	private BSTNode root;

	public boolean add(Contact newContact) {
		if (root == null) {
			root = new BSTNode(newContact);
			return true;
		} else
			return root.add(newContact);
	}

	public Contact search(String name) {
		if (root == null) {
			return null;
		} else {
			return root.search(name);
		}
	}

	public boolean remove(Contact contact) {
		if (root == null) {
			return false;
		} else {
			if (root.getContact() == contact) {
				BSTNode auxRoot = new BSTNode(new Contact(null, 0));
				auxRoot.setLeft(root);
				boolean result = root.remove(contact, auxRoot);
				root = auxRoot.getLeft();
				return result;
			} else {
				return root.remove(contact, null);
			}
		}
	}

	public void getAllContacts() {
		traverseBST(root);
	}

	private void traverseBST(BSTNode current) {

		if (current == null) {
			return;
		}

		traverseBST(current.getLeft());

		System.out.println(current.getContact());

		traverseBST(current.getRight());

	}

}