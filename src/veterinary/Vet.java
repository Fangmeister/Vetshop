package veterinary;

import java.util.ArrayList;
import animals.Animal;

public class Vet extends Employee {
	public ArrayList<Animal> assignedAnimals = new ArrayList<Animal>();
		
	public Vet (String nameIn, String surnameIn, int employeeIDIn) {
				super(nameIn, surnameIn, employeeIDIn);

	}
	
//	public void addAnimal(Animal animal) {
//			assignedAnimals.add(animal);
//		System.out.println(assignedAnimals);
//	}
//	
//	public void removeAnimal(Animal animal) {
//		assignedAnimals.remove(animal);
//	}

}
