package veterinary;

public class Employee {
	protected String name;
	protected String surname;
	private int employeeID;
	
	/**
	 * Creates a new Employee instance. The Employee Class is a super class of the sub classes Vet and Clerk.
	 * @param nameIn				The name of the employee
	 * @param surnameIn			The surname of the employee
	 * @param employeeIDIn	The employeeID; currently not used in the main method, but needed to be included in this class as per the software specification
	 */
	public Employee (String nameIn, String surnameIn, int employeeIDIn) {
		this.name = nameIn;
		this.surname = surnameIn;
		this.employeeID = employeeIDIn;
	}
	
	/**
	 * Public function to return the protected string name
	 * @return the name of the employee
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Public function to return the protected string surname
	 * @return the surname of the employee
	 */
	public String getSurname() {
		return surname;
	}

}
