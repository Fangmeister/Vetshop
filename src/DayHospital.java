//package veterinary;
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
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your input please: ");
		
		VetShop petInterCare = new VetShop ();
		
		while (!temp.equalsIgnoreCase(quit)) { //With the while loop, if input is equal to q or Q, then the program will only run until "You have quit the vet" and terminated the main program since there are no other lines of program after that
			temp = input.next();
			
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
						}
						newDog.setClerkIn(petInterCare.getClerk());
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
			
			if(temp.equalsIgnoreCase(audit)) {
				petInterCare.auditKennels();
			}
			
			if(temp.equalsIgnoreCase(quit)) { //should end application
				System.out.println("You have left the Vet");
	//			System.exit(0); this is not required with the while loop implemented
			}
		}
	}

	public static float getRandomWeight() {
		float weight = (float)(Math.random()*20+3);
		return weight;
		
	}
	
	public static float getRandomHeight() {
		float height = (float)(Math.random()*1.1f+0.2f);
		return height;
		
	}
	
	public static int getRandomStayDuration() {
		int stayDuration = (int)(Math.random()*4+1);
		return stayDuration;
	}

	

	
}



