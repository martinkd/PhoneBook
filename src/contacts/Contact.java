package contacts;

public class Contact {

	private String name;
	private long number;

	public Contact(String name, long number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Contact [name=" + name + ", number=" + number + "]";
	}

}
