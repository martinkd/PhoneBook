package contacts;

public class BSTNode {

	private Contact contact;

	private BSTNode left;
	private BSTNode right;

	public BSTNode(Contact contact) {
		this.contact = contact;
	}

	public boolean add(Contact contact) {

		String name = contact.getName();

		if (exists(contact)) {

			return false;

		} else if (isLess(name)) {

			if (left == null) {
				left = new BSTNode(contact);
				return true;
			} else {
				return left.add(contact);
			}

		} else if (isGreater(name)) {

			if (right == null) {
				right = new BSTNode(contact);
				return true;
			} else {
				return right.add(contact);
			}
		}

		return false;

	}

	public Contact search(String name) {

		if (name.equalsIgnoreCase(this.contact.getName())) {

			return this.contact;

		} else if (isLess(name)) {

			if (left == null) {
				return null;
			} else {
				return left.search(name);
			}

		} else if (isGreater(name)) {

			if (right == null) {
				return null;
			} else {
				return right.search(name);
			}
		}

		return null;

	}

	public boolean remove(Contact contact, BSTNode parent) {

		String name = contact.getName();

		if (isLess(name)) {

			if (left != null) {
				return left.remove(contact, this);
			} else {
				return false;
			}

		} else if (isGreater(name)) {

			if (right != null) {
				return right.remove(contact, this);
			} else {
				return false;
			}

		} else {

			if (left != null && right != null) {
				this.contact = right.minValue();
				right.remove(this.contact, this);
			} else if (parent.left == this) {
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}

	private Contact minValue() {
		
		if (left == null) {
			return this.contact;
		} else {
			return left.minValue();
		}
	}

	private boolean exists(Contact contact) {
		return this.contact.getName().equals(contact.getName()) || this.contact.getNumber() == contact.getNumber();
	}

	private boolean isLess(String name) {
		return name.compareToIgnoreCase(this.contact.getName()) < 0;
	}

	private boolean isGreater(String name) {
		return name.compareToIgnoreCase(this.contact.getName()) > 0;
	}

	public Contact getContact() {
		return contact;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

}