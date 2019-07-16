package veterinary;

public class Employee {
	protected String name;
	protected String surname;
	private int employeeID;
	
	public Employee (String nameIn, String surnameIn, int employeeIDIn) {
		this.name = nameIn;
		this.surname = surnameIn;
		this.employeeID = employeeIDIn;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

}
