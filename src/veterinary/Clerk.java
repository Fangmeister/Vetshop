package veterinary;

public class Clerk extends Employee {
	
	/**
	 * Creates an instance of the Clerk Class, which is a sub class of the Employee Class. The parameters for Clerk and Employee are the same.
	 * @param nameIn				The name of the clerk
	 * @param surnameIn			The surname of the clerk
	 * @param employeeIDIn	The employee ID of the clerk
	 */
	public Clerk (String nameIn, String surnameIn, int employeeIDIn) {
		
		super(nameIn, surnameIn, employeeIDIn);
	}

}
