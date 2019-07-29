package veterinary;

import java.util.ArrayList;
import animals.Animal;

public class Vet extends Employee {
	/*
	 * Since each instance of the veterinary is to have a number of animals assigned and discharged based on kennel availability and remaining stay duration,
	 * the number and instance of animals that each veterinary has been assigned will change daily. The ArrayList assignedAnimals is defined for the Vet Class to manage
	 * the assigned animals.
	 * The ArrayList is not part of the Vet constructor, since the Vet will not know the animals assigned until the main method is run with the pre-defined text inputs.
	 */
	public ArrayList<Animal> assignedAnimals = new ArrayList<Animal>();
		
	/**
	 * Creates a new Vet instance. Vet is a subclass of the Clerk Class. 
	 * @param nameIn				the name of the veterinary
	 * @param surnameIn			the surname of the veterinary
	 * @param employeeIDIn	the employeeiD of the veterinary
	 */
	public Vet (String nameIn, String surnameIn, int employeeIDIn) {
				super(nameIn, surnameIn, employeeIDIn);
	}
}
	