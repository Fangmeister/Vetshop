package veterinary;
import animals.Dog;
import animals.FurType;
import animals.Animal;
import animals.Cat;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Random;

public class VetShop {
	Dog[] dogKennels = new Dog[10];
	Cat[] catKennels = new Cat[8];
	Animal[] generalKennels = new Animal[6];
	public Vet [] vets = new Vet[4];
	public Clerk [] clerks = new Clerk [3];
	protected int currentDayNo;
	int min;
	
	public VetShop () {
		vets[0] = new Vet ("Jose", "Porter", 1401);
		vets[1] = new Vet ("Melanie", "Hill", 1021);
		vets[2] = new Vet ("Annabelle", "Flemming", 1102);
		vets[3] = new Vet ("Charlie", "Abbot", 1063);
		clerks[0] = new Clerk ("Velma", "Griffin", 2804);
		clerks[1] = new Clerk ("Serena", "Singh", 3042);
		clerks[2] = new Clerk ("Lee", "Levy", 2042);
		
	}
	
	public boolean addAnimal(Animal animal) {
		if(animal instanceof Dog) {
			boolean dogFoundKennel = false;
			for (int i = 0; i < dogKennels.length; ++ i) {
				if(dogKennels[i] == null) {
					dogKennels[i] = (Dog) animal;
//					System.out.println(dogKennels[i].getWeight());
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
	
	public void getVet(Animal animal) {
		int index = 0;
		ArrayList <Integer> vetAssignNumber = new ArrayList<Integer>();

		for (int j = 0; j < vets.length; ++j) { //first rotation through vets when int min has nothing assigned
			if (vets[j].assignedAnimals.size() <= min) { //need to compare this with other vets[x] to get random between same size
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
			
//		System.out.println(index);
		System.out.println("Pet assigned to: " + vets[index].name + " " + vets[index].surname);
		vets[index].assignedAnimals.add(animal);
		animal.setVet(vets[index]);
		min = vets[index].assignedAnimals.size();

	}
	
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
	
	public void auditKennels() {
		System.out.println("Dog Kennels Have the Following Animals: ");
		
		for (int dlength = 0; dlength < dogKennels.length; ++dlength) {
			if(dogKennels[dlength] != null) {
				System.out.println("\t [Name: " + dogKennels[dlength].name + "; Breed: " + dogKennels[dlength].getDogBreed() + "; Stay Duration: " + dogKennels[dlength].stayDuration + "; Assigned Vet: " +dogKennels[dlength].assignedVet.name + " " +dogKennels[dlength].assignedVet.surname + "; Checkin Clerk: " + dogKennels[dlength].checkinClerk.name + " " + dogKennels[dlength].checkinClerk.surname + "]");
			}
		}
		
		System.out.println("General Kennels Have the Following Animals: ");

		for (int glength = 0; glength < generalKennels.length; ++glength) {
			if(generalKennels[glength] != null) {
				if(generalKennels[glength] instanceof Dog) {
				System.out.println("\t [Name: " + generalKennels[glength].name + "; Breed: " + ((Dog)generalKennels[glength]).getDogBreed() + "; Stay Duration: " + generalKennels[glength].stayDuration + "; Assigned Vet: " +generalKennels[glength].assignedVet.name + " " +generalKennels[glength].assignedVet.surname + "; Checkin Clerk: " + generalKennels[glength].checkinClerk.name + " " + generalKennels[glength].checkinClerk.surname + "]");
				}
				if(generalKennels[glength] instanceof Cat) {
				System.out.println("\t [Name: " + generalKennels[glength].name + "; Breed: " + ((Cat)generalKennels[glength]).getCatBreed() + "; Stay Duration: " + generalKennels[glength].stayDuration + "; Assigned Vet: " +generalKennels[glength].assignedVet.name + " " +generalKennels[glength].assignedVet.surname + "; Checkin Clerk: " + generalKennels[glength].checkinClerk.name + " " + generalKennels[glength].checkinClerk.surname + "]");
				}
			}
		}
		
		System.out.println("Cat Kennels Have the Following Animals: ");

		for (int clength = 0; clength < catKennels.length; ++clength) {
			if(catKennels[clength] != null) {
				System.out.println("\t [Name: " + catKennels[clength].name + "; Breed: " + catKennels[clength].getCatBreed() + "; Stay Duration: " + catKennels[clength].stayDuration + "; Assigned Vet: " +catKennels[clength].assignedVet.name + " " +catKennels[clength].assignedVet.surname + "; Checkin Clerk: " + catKennels[clength].checkinClerk.name + " " + catKennels[clength].checkinClerk.surname + "]");
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
					System.out.println("\t[Patient Name: " + animalList.get(animalInt).name + "; Breed: " + ((Dog)animalList.get(animalInt)).getDogBreed() + "; Fur Type: " + (animalList.get(animalInt)).getFurType() + "; Weight: " + (animalList.get(animalInt)).getWeight() + "]");
				}
				
				if(animalList.get(animalInt) instanceof Cat) {
					System.out.println("\t[Patient Name: " + animalList.get(animalInt).name + "; Breed: " + ((Cat)animalList.get(animalInt)).getCatBreed() + "; Fur Type: " + (animalList.get(animalInt)).getFurType() + "; Weight: " + (animalList.get(animalInt)).getWeight() + "]");
				}
			}
		}
	}
	
	public void dischargePatients() {
		for (int dsize = 0; dsize < dogKennels.length; ++dsize) {
			if(dogKennels[dsize] != null && dogKennels[dsize].stayDuration == 0) {
				dogKennels[dsize].setClerkOut(getClerk());
				System.out.println("Discharged Patient [Name: " + dogKennels[dsize].name + "; Breed: " + dogKennels[dsize].getDogBreed() + "; Checkout Clerk: " + dogKennels[dsize].checkoutClerk.name + " " + dogKennels[dsize].checkoutClerk.surname + "Vet: " + dogKennels[dsize].assignedVet.name + " " + dogKennels[dsize].assignedVet.surname + "]");
				removeVet(dogKennels[dsize]);
				dogKennels[dsize] = null;
			}
		}
		
		for (int gsize = 0; gsize < generalKennels.length; ++gsize) {
			if(generalKennels[gsize] != null && generalKennels[gsize].stayDuration == 0) {
				generalKennels[gsize].setClerkOut(getClerk());
				if(generalKennels[gsize] instanceof Dog) {
					System.out.println("Discharged Patient [Name: " + generalKennels[gsize].name + "; Breed: " + ((Dog)generalKennels[gsize]).getDogBreed() + "; Checkout Clerk: " + generalKennels[gsize].checkoutClerk.name + " " + generalKennels[gsize].checkoutClerk.surname + "Vet: " + generalKennels[gsize].assignedVet.name + " " + generalKennels[gsize].assignedVet.surname + "]");

				}
				
				if(generalKennels[gsize] instanceof Cat) {
					System.out.println("Discharged Patient [Name: " + generalKennels[gsize].name + "; Breed: " + ((Cat)generalKennels[gsize]).getCatBreed() + "; Checkout Clerk: " + generalKennels[gsize].checkoutClerk.name + " " + generalKennels[gsize].checkoutClerk.surname + "Vet: " + generalKennels[gsize].assignedVet.name + " " + generalKennels[gsize].assignedVet.surname + "]");
				}
				removeVet(generalKennels[gsize]);
				generalKennels[gsize] = null;
			}
		}
		
		for (int csize = 0; csize < catKennels.length; ++csize) {
			if(catKennels[csize] != null && catKennels[csize].stayDuration == 0) {
				catKennels[csize].setClerkOut(getClerk());
				System.out.println("Discharged Patient [Name: " + catKennels[csize].name + "; Breed: " + catKennels[csize].getCatBreed() + "; Checkout Clerk: " + catKennels[csize].checkoutClerk.name + " " + catKennels[csize].checkoutClerk.surname  + "Vet: " + catKennels[csize].assignedVet.name + " " + catKennels[csize].assignedVet.surname + "]");
				removeVet(catKennels[csize]);
				catKennels[csize] = null;
			}
		}
	}
	
	private void removeVet(Animal animal) {
		for (int vetNo = 0; vetNo < vets.length; ++vetNo) {
			for (int vetName = 0; vetName < vets[vetNo].assignedAnimals.size(); ++vetName) {
				if (vets[vetNo].assignedAnimals.get(vetName).equals(animal)) {
					vets[vetNo].assignedAnimals.remove(vetName);
				}
			}
		}
	}
	
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
	
	public void setCurrentDay(int dayNo) {
		currentDayNo = dayNo;
	}
		

}
