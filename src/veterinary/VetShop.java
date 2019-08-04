package veterinary;
import animals.Dog;
import animals.Animal;
import animals.Cat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VetShop {
	//Dog Kennel Array is reserved for Dog Class instances and has a length of 10
	Dog[] dogKennels = new Dog[10];
	//Cat Kennel Array is reserved for Cat Class instances and has a length of 8
	Cat[] catKennels = new Cat[8];
	//General Kennel Array can be used for either dogs or cats (Animal) and has a length of 6
	Animal[] generalKennels = new Animal[6];
	//There are a total of 4 vets in the vets Array
	public Vet [] vets = new Vet[4];
	//There are a total of 3 clerks in the clerks Array
	public Clerk [] clerks = new Clerk [3];
	//Integer currentDayNo is used to keep track of the Day number every time the main method is executed and a new day is simulated (text input = r/R)
	protected int currentDayNo;
	//Integer min is used as a initial parameter for the getVet() function to determine the least number of animal assigned to a vet
	int min;
	
	/**
	 * Creates an instance of the VetShop, which has no parameters in the constructor.
	 * Defines each element of the vets array by creating a new Vet instance for each element
	 * Defines each element of the clerks array by creating a new Clerk instance for each element
	 */
	public VetShop () {
		vets[0] = new Vet ("Jose", "Porter", 1401);
		vets[1] = new Vet ("Melanie", "Hill", 1021);
		vets[2] = new Vet ("Annabelle", "Flemming", 1102);
		vets[3] = new Vet ("Charlie", "Abbot", 1063);
		clerks[0] = new Clerk ("Velma", "Griffin", 2804);
		clerks[1] = new Clerk ("Serena", "Singh", 3042);
		clerks[2] = new Clerk ("Lee", "Levy", 2042);
	}
	
	/**
	 * Assigns dogs to the dog kennels, cats to the cat kennels, and dogs or cats to the general kennels once respective (dog or cat) kennels are full.
	 * The animals are assigned once if the kennel array element is null.
	 * The animals are rejected if both the specific (cat or dog) kennel array and the general kennels are full.
	 * The system outputs text if the animal was accepted into a kennel e.g. "Dog put in General Kennels"
	 * The system outputs text if the animal was rejected e.g. "Dog rejected"
	 * @param animal	The Animal instance to be assigned to a kennel
	 * @return				boolean of whether the animal has been assigned a kennel. If false, the text output will be "Dog/Cat rejected"
	 */
	public boolean addAnimal(Animal animal) {
		if(animal instanceof Dog) {
			boolean dogFoundKennel = false;
			for (int i = 0; i < dogKennels.length; ++ i) {
				if(dogKennels[i] == null) {
					dogKennels[i] = (Dog) animal;
					i = dogKennels.length; //breaks the if loop once dog is assigned to dogKennels[i], otherwise the first dog will be assigned to the entire dogKennels.length
					System.out.println("Dog put in Dog Kennels");
					dogFoundKennel = true;
					return true;
				}
			}
			// if dog not find kennel, put dog in general kennels
			if(dogFoundKennel == false) {
				for(int c = 0; c < generalKennels.length; ++ c) {
					if(generalKennels[c] == null) {
						generalKennels[c] = (Dog) animal;
						c = generalKennels.length; //breaks the if loop once dog is assigned to dogKennels[i], otherwise the second dog will be assigned to the entire generalKennels.length
						System.out.println("Dog put in General Kennels");
						dogFoundKennel = true;
						return true;
					}
				}
			}
			// if dog still not find kennel, dog rejected
			if(dogFoundKennel == false) {
				System.out.println("Dog rejected");
				return false;
			}
		}
		
		if (animal instanceof Cat) {
			boolean catFoundKennel = false;
				for (int b = 0; b < catKennels.length; ++ b) {
					if(catKennels[b] == null) {
						catKennels[b] = (Cat) animal;
						b = catKennels.length;
						System.out.println("Cat put in Cat Kennels");
						catFoundKennel = true;
						return true;
					}
				}
			
			if(catFoundKennel == false) {
			for (int n = 0; n < generalKennels.length; ++ n) {
				if(generalKennels[n] == null) {
					generalKennels[n] = (Cat) animal;
					n = generalKennels.length;
					System.out.println("Cat put in General Kennels");
					catFoundKennel = true;
					return true;
					}
				}

			if (catFoundKennel == false) {
				System.out.println("Cat rejected");
				return false;
				}
			}
		}
		throw new java.lang.Error("Unrecognized Species");
	}
	
	/**
	 * Assigns the animal to the vet based on how many animals the vet currently has assigned to them.
	 * The vet with the least number of animals assigned will have the new animal assigned to him or her.
	 * If one or more vets have the minimum number of animals assigned, a vet is randomly chosen.
	 * Each vet has an ArrayList assignedAnimals which the animal is assigned to.
	 * @param animal	The animal to be assigned to the vet
	 */
	public void getVet(Animal animal) {
		int index = 0;
		ArrayList <Integer> vetAssignNumber = new ArrayList<Integer>();

		for (int j = 0; j < vets.length; ++j) {
			if (vets[j].assignedAnimals.size() <= min) {
				min = vets[j].assignedAnimals.size();
			}
		}
			
		for (int vetsNum = 0; vetsNum < vets.length; ++vetsNum) {
			if (vets[vetsNum].assignedAnimals.size() == min) {
				vetAssignNumber.add(vetsNum);
			}
		}

		Random vetSelection = new Random();
		int vetNo = vetSelection.nextInt(vetAssignNumber.size()); //size does not correlate to actual values of vetAssigneNumber. e.g. if [2, 3] is used as the vetAssignNumber, vetNo generated will be between 0 and 1
		index = vetAssignNumber.get(vetNo);
			
		System.out.println("Pet assigned to: " + vets[index].name + " " + vets[index].surname);
		vets[index].assignedAnimals.add(animal);
		animal.setVet(vets[index]);
		min = vets[index].assignedAnimals.size();
	}
	
	/**
	 * Decreases the stay duration of all the animals in the kennels by an integer of one.
	 */
	public void decrementAnimalStayDuration() {
		for (int a = 0; a < dogKennels.length; ++a) {
			if(dogKennels[a] != null) {
				--dogKennels[a].stayDuration;
			}
		}
		
		for (int d = 0; d < catKennels.length; ++d) {
			if(catKennels[d] != null) {
				--catKennels[d].stayDuration;
			}
		}
		
		for (int e = 0; e < generalKennels.length; ++e) {
			if(generalKennels[e] != null) {
				--generalKennels[e].stayDuration;
			}
		}
	}
	
	/**
	 * Displays information on the animals currently assigned to the kennels. The Name, Breed, Stay Duration, Assigned Vet and Check in Clerk
	 * are displayed per animal for each kennel: first Dog Kennels, Then General Kennels, and finally Cat Kennels.
	 * The function also displays the information on the animals currently to the vets. The animals assigned to the vets and to the kennels are the same.
	 * The Name, Breed, Fur Type and Weight are displayed per animal for each vet.
	 */
	public void auditKennels() {
		System.out.println("Dog Kennels Have the Following Animals: ");
		
		for (int dlength = 0; dlength < dogKennels.length; ++dlength) {
			if(dogKennels[dlength] != null) {
				System.out.println("\t [Name: " + dogKennels[dlength].name + "; Breed: " + dogKennels[dlength].dogBreed + "; Stay Duration: " + dogKennels[dlength].stayDuration + "; Assigned Vet: " +dogKennels[dlength].assignedVet.name + " " +dogKennels[dlength].assignedVet.surname + "; Checkin Clerk: " + dogKennels[dlength].checkinClerk.name + " " + dogKennels[dlength].checkinClerk.surname + "]");
			}
		}
		
		System.out.println("General Kennels Have the Following Animals: ");

		for (int glength = 0; glength < generalKennels.length; ++glength) {
			if(generalKennels[glength] != null) {
				if(generalKennels[glength] instanceof Dog) {
				System.out.println("\t [Name: " + generalKennels[glength].name + "; Breed: " + ((Dog)generalKennels[glength]).dogBreed + "; Stay Duration: " + generalKennels[glength].stayDuration + "; Assigned Vet: " +generalKennels[glength].assignedVet.name + " " +generalKennels[glength].assignedVet.surname + "; Checkin Clerk: " + generalKennels[glength].checkinClerk.name + " " + generalKennels[glength].checkinClerk.surname + "]");
				}
				if(generalKennels[glength] instanceof Cat) {
				System.out.println("\t [Name: " + generalKennels[glength].name + "; Breed: " + ((Cat)generalKennels[glength]).catBreed + "; Stay Duration: " + generalKennels[glength].stayDuration + "; Assigned Vet: " +generalKennels[glength].assignedVet.name + " " +generalKennels[glength].assignedVet.surname + "; Checkin Clerk: " + generalKennels[glength].checkinClerk.name + " " + generalKennels[glength].checkinClerk.surname + "]");
				}
			}
		}
		
		System.out.println("Cat Kennels Have the Following Animals: ");

		for (int clength = 0; clength < catKennels.length; ++clength) {
			if(catKennels[clength] != null) {
				System.out.println("\t [Name: " + catKennels[clength].name + "; Breed: " + catKennels[clength].catBreed + "; Stay Duration: " + catKennels[clength].stayDuration + "; Assigned Vet: " +catKennels[clength].assignedVet.name + " " +catKennels[clength].assignedVet.surname + "; Checkin Clerk: " + catKennels[clength].checkinClerk.name + " " + catKennels[clength].checkinClerk.surname + "]");
			}
		}
		
		
		System.out.println("Vets have the following animals assigned: ");
		for (int g = 0; g < vets.length; ++g) {
			List<Animal> animalList = vets[g].assignedAnimals;
			Vet currentVet = vets[g];
			System.out.println(currentVet.name + " " + currentVet.surname + ": ");
			if(animalList.size() == 0) {
				System.out.println("\tThis Vet has no animal assigned");
			}
			for (int animalInt = 0; animalInt < animalList.size(); ++animalInt) {
				if(animalList.get(animalInt) instanceof Dog) {
					System.out.println("\t[Patient Name: " + animalList.get(animalInt).name + "; Dog Breed: " + ((Dog)animalList.get(animalInt)).dogBreed + "; Fur Type: " + (animalList.get(animalInt)).furType + "; Weight: " + (animalList.get(animalInt)).getWeight() + "]");
				}
				
				if(animalList.get(animalInt) instanceof Cat) {
					System.out.println("\t[Patient Name: " + animalList.get(animalInt).name + "; Cat Breed: " + ((Cat)animalList.get(animalInt)).catBreed + "; Fur Type: " + (animalList.get(animalInt)).furType + "; Weight: " + (animalList.get(animalInt)).getWeight() + "]");
				}
			}
		}
	}
	
	/**
	 * Removes the animal from the kennels based on the animal's remaining stay duration. If the integer stay duration for the animal is 0, then the animal is removed from the kennel array.
	 * The function loops through the dog kennels, general kennels and cat kennels. 
	 * Once the animal is removed from the kennel array element, there will be a text output to display the Name, Breed, Checkout Clerk and Vet of the animal that was removed.
	 * The function removeVet is also invoked to remove the animal that was removed from the kennel array, from the vet's assignedAnimals array list.
	 * Once the animal is removed from eht kennel array and the removeVet function is invoked, then the kennel element from where the animal was removed becomes null.
	 */
	public void dischargePatients() {
		for (int dsize = 0; dsize < dogKennels.length; ++dsize) {
			if(dogKennels[dsize] != null && dogKennels[dsize].stayDuration == 0) {
				dogKennels[dsize].setClerkOut(getClerk());
				System.out.println("Discharged Patient [Name: " + dogKennels[dsize].name + "; Breed: " + dogKennels[dsize].dogBreed + "; Checkout Clerk: " + dogKennels[dsize].checkoutClerk.name + " " + dogKennels[dsize].checkoutClerk.surname + "; Vet: " + dogKennels[dsize].assignedVet.name + " " + dogKennels[dsize].assignedVet.surname + "]");
				removeVet(dogKennels[dsize]);
				dogKennels[dsize] = null;
			}
		}
		
		for (int gsize = 0; gsize < generalKennels.length; ++gsize) {
			if(generalKennels[gsize] != null && generalKennels[gsize].stayDuration == 0) {
				generalKennels[gsize].setClerkOut(getClerk());
				if(generalKennels[gsize] instanceof Dog) {
					System.out.println("Discharged Patient [Name: " + generalKennels[gsize].name + "; Breed: " + ((Dog)generalKennels[gsize]).dogBreed + "; Checkout Clerk: " + generalKennels[gsize].checkoutClerk.name + " " + generalKennels[gsize].checkoutClerk.surname + "; Vet: " + generalKennels[gsize].assignedVet.name + " " + generalKennels[gsize].assignedVet.surname + "]");

				}
				
				if(generalKennels[gsize] instanceof Cat) {
					System.out.println("Discharged Patient [Name: " + generalKennels[gsize].name + "; Breed: " + ((Cat)generalKennels[gsize]).catBreed + "; Checkout Clerk: " + generalKennels[gsize].checkoutClerk.name + " " + generalKennels[gsize].checkoutClerk.surname + "; Vet: " + generalKennels[gsize].assignedVet.name + " " + generalKennels[gsize].assignedVet.surname + "]");
				}
				removeVet(generalKennels[gsize]);
				generalKennels[gsize] = null;
			}
		}
		
		for (int csize = 0; csize < catKennels.length; ++csize) {
			if(catKennels[csize] != null && catKennels[csize].stayDuration == 0) {
				catKennels[csize].setClerkOut(getClerk());
				System.out.println("Discharged Patient [Name: " + catKennels[csize].name + "; Breed: " + catKennels[csize].catBreed + "; Checkout Clerk: " + catKennels[csize].checkoutClerk.name + " " + catKennels[csize].checkoutClerk.surname  + "; Vet: " + catKennels[csize].assignedVet.name + " " + catKennels[csize].assignedVet.surname + "]");
				removeVet(catKennels[csize]);
				catKennels[csize] = null;
			}
		}
	}
	
	/**
	 * Removes the animal from the vet assignedAnimals array list, by matching the animal parameter with all the animals in the vet's assignedAnimals array list.
	 * This function loops through all the vets to match the input parameter animal to the vets' array lists.
	 * @param animal	the animal to be removed from the vet's assignedAnimal array list.
	 */
	private void removeVet(Animal animal) {
		for (int vetNo = 0; vetNo < vets.length; ++vetNo) {
			for (int vetName = 0; vetName < vets[vetNo].assignedAnimals.size(); ++vetName) {
				if (vets[vetNo].assignedAnimals.get(vetName).equals(animal)) {
					vets[vetNo].assignedAnimals.remove(vetName);
				}
			}
		}
	}
	
	/**
	 * Sets the clerk that is on duty at day currentDayNo.
	 * The three clerks from the clerks [] are on set rotation every day.
	 * Since there are three clerks, each clerk appears every three days.
	 * The modulus operator is used as the currentDayNo % 3 will be equal to the index of the clerk in the []
	 * @return	the clerk that is on duty
	 */
	public Clerk getClerk() {
		Clerk clerkOnDuty;
		for (int clerkNo = 0; clerkNo < clerks.length; ++clerkNo) {
			if (currentDayNo % 3 == clerkNo) {
				clerkOnDuty = clerks[clerkNo];
				return clerkOnDuty;
			}
		}
		throw new java.lang.Error("Our Clerk Maths is bad");
	}
	
	/**
	 * Sets the integer currentDayNo to be the same as the input parameter dayNo
	 * @param dayNo	integer day number; an additional day number signifies a new day
	 */
	public void setCurrentDay(int dayNo) {
		currentDayNo = dayNo;
	}
}
