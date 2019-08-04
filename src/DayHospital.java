import java.util.Scanner;
import animals.Animal;
import animals.CatBreed;
import animals.Dog;
import animals.Cat;
import animals.DogBreed;
import animals.FurType;
import veterinary.VetShop;
import java.util.Random;

public class DayHospital {

	public static void main(String[] args) {
		String temp = "";
		String newDay = "r";
		String quit = "q";
		String audit = "a";
		int dayNo = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your input please: ");
		
		//A new instance of VetShop, petInterCare, is created
		VetShop petInterCare = new VetShop ();
		
		//A while loop that runs as long as the console input is not equal to q or Q
		while (!temp.equalsIgnoreCase(quit)) { //With the while loop, if input is equal to q or Q, then the program will only run until "You have quit the vet" and terminated the main program since there are no other lines of program after that
			temp = input.next();
			
			/*
			 * If the console input is equal to r/R, then a new day is simulated in the VetShop instance.
			 * The current day number starts at 0 at the first day simulated.
			 * There is a text output stating the name and surname of the Clerk on duty, after the getClerk() function is invoked to determine the Clerk on duty.
			 * A random number of animals (between 1 and 10) are generated. 
			 * There is a text output of the number of new animals generated.
			 * Each animal is then processed as follows:
			 * 	- the species of the animal is randomly generated via a boolean (if true, animal is a new Dog; if false, animal is a new Cat).
			 *  - a new instance of Dog or Cat is created, with the parameters Dog/Cat Name, Owner name, Weight, Height, Stay Duration, Fur Type and Breed randomly generated with functions in the constructor
			 *  - There is a text output of the animal name, owner name, animal breed and stay duration.
			 *  - the addAnimal(animal) function is invoked to loop through the kennel arrays for availability.
			 *  - if the animal is assigned to a kennel, then the boolean addedDog/Cat is true and the animal is assigned to a vet via the getVet() function, and the animal is given a check in Clerk via the getClerk() and setClerk() functions.
			 *  - if the animal is not assigned to a kennel due to no space, then the boolean addedDog/Cat is false and the animal is not assigned to a vet.
			 * When the animals have been assigned or rejected, then the following happens:
			 *  - animals currently in the kennels have their stay durations decrease by 1 integer (one day).
			 *  - if any animals have their stay durations at 0 (zero days), then they are discharged and removed from the kennel array and vet they were assigned to.
			 *  The current day number increases by 1.
			 */
			if(temp.equalsIgnoreCase(newDay)) {
				petInterCare.setCurrentDay(dayNo); 
				System.out.println("Clerk on Duty: " + petInterCare.getClerk().getName() + " " + petInterCare.getClerk().getSurname());
					
				int newPatient = (int)(Math.random()* 10 + 1); 
				System.out.println("No. of new animals = " + newPatient);
				
				for (int b = 0; b < newPatient; ++ b) {
					
					Random species = new Random();
					boolean speciesRand = species.nextBoolean();
					
					if(speciesRand == true) {
						Dog newDog = new Dog (Dog.getRandomDogName(), Animal.getRandomOwnerName(), getRandomWeight(), getRandomHeight(), getRandomStayDuration(), FurType.getRandomFurType(), DogBreed.getRandomDogBreed());
						System.out.println("Dog Name: " + newDog.name + "; Owner: " + newDog.getOwnerName() + "; Breed: " + newDog.dogBreed + "; Stay Duration: " + newDog.stayDuration);
						boolean addedDog = petInterCare.addAnimal(newDog);
						if(addedDog == false) {
						}
						if(addedDog == true) {
							petInterCare.getVet(newDog);
							newDog.setClerkIn(petInterCare.getClerk());
						}
					}
					
					if(speciesRand == false) {
						Cat newCat = new Cat (Cat.getRandomCatName(), Animal.getRandomOwnerName(), getRandomWeight(), getRandomHeight(), getRandomStayDuration(), FurType.getRandomFurType(), CatBreed.getRandomCatBreed());
						System.out.println("Cat Name: " + newCat.name + "; Owner: " + newCat.getOwnerName() + "; Breed: " + newCat.catBreed + "; Stay Duration: " + newCat.stayDuration);
						boolean addedCat = petInterCare.addAnimal(newCat);
						if(addedCat == false) {
						}
						if(addedCat == true) {
							petInterCare.getVet(newCat);
						}
						newCat.setClerkIn(petInterCare.getClerk());
					}
				}
				
				petInterCare.decrementAnimalStayDuration();
				petInterCare.dischargePatients();
				++dayNo;
			}
			
			/*
			 * If the input is equal to a/A, an audit simulation is run on the current kennel status and vet status.
			 * The function auditKennels() is invoked.
			 * The system displays the animals for the Dog Kennels, General Kennels and Cat Kennels with the following information:
			 *  - Name
			 *  - Breed
			 *  - Stay Duration
			 *  - Assigned Vet
			 *  - Check in Clerk
			 * The system displays the animals for each of the vets with the following information:
			 *  - Name
			 *  - Breed
			 *  - Fur Type
			 *  - Weight
			 * The animals contained in the kennel arrays should be the same as what is assigned to the vets assigned animals array list.
			 * Note that vets are assigned animals based on how many animals they have currently assigned to them. 
			 * Thus the animals will not appear in the same order in the kennel arrays as they would appear in the vet array lists.
			 */
			if(temp.equalsIgnoreCase(audit)) {
				petInterCare.auditKennels();
			}
			
			//If the input is equal to q/R, the main program is terminated.
			if(temp.equalsIgnoreCase(quit)) { //should end application
				System.out.println("You have left the Vet");
				input.close();
				//System.exit(0); this is not required with the while loop implemented
			}
		}
	}

	/**
	 * Returns a random float between the integers 3 and 20
	 * @return	A random float, weight
	 */
	public static float getRandomWeight() {
		float weight = (float)(Math.random()*17+3);
		return weight;
	}
	
	/**
	 * Returns a random float between the floats 0.2 and 1.3
	 * @return	A random float, height
	 */
	public static float getRandomHeight() {
		float height = (float)(Math.random()*1.1f+0.2f);
		return height;
	}
	
	/**
	 * Returns a random integer between the integers 1 and 4
	 * @return	A random integer, stay duration
	 */
	public static int getRandomStayDuration() {
		int stayDuration = (int)(Math.random()*3+1);
		return stayDuration;
	}	
}



