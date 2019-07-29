package animals;

import java.util.Random;
import veterinary.Vet;
import veterinary.Clerk;

public class Animal {
	
	/*
	 * assignedVet, checkinClerk and checkoutClerk are not part of the Animal constructor. This is because when a new Animal instance is created, 
	 * the Vet, Check in Clerk and the Check out Clerk are not assigned yet. The new animal needs to be checked against kennel availability before
	 * it is assigned the above. 
	 * Once the animal is allocated a kennel, the Vet, Check in Clerk and Check out Clerk will be assigned via the use of animal.setVet(), animal.setClerkIn() and animal.setClerkOut()
	 */
	public String name;
	protected String ownerName;
	protected float weight; 
	protected float height; 
	public int stayDuration; 
	public Vet assignedVet; 
	public Clerk checkinClerk;
	public Clerk checkoutClerk;
	public FurType furType;
	
	//ownerNameList is a string array that contains a list of possible names of owners for the animals. 
	public static String[] ownerNameList = {
			"Emma",
			"Olivia",
			"Ava",
			"Isabella",
			"Sophia",
			"Charlotte",
			"Mia",
			"Amelia",
			"Harper",
			"Evelyn",
			"Abigail",
			"Emily",
			"Liam",
			"Noah",
			"William",
			"James",
			"Oliver",
			"Benjamin",
			"Elijah",
			"Lucas",
			"Mason",
			"Logan",
			"Alexander",
			"Ethan",
	};
	
	/**
	 * Create a new Animal instance. The Animal class is a super class of the sub classes Cat and Dog.
	 * @param nameIn 					the name of the animal
	 * @param ownerNameIn 		the name of the owner of the animal
	 * @param weightIn 				float of the weight of the animal
	 * @param heightIn				float of the height of the animal
	 * @param stayDurationIn  integer of the number of stay duration
	 * @param furTypeIn				the fur type of the animal (enum)
	 */
	public Animal(String nameIn, String ownerNameIn, float weightIn, float heightIn, int stayDurationIn, FurType furTypeIn) {
		name = nameIn;
		ownerName = ownerNameIn;
		weight = weightIn;
		height = heightIn;
		stayDuration = stayDurationIn;
		furType = furTypeIn;
	}
		
	/**
	 * Randomly choose an owner name from the public string array OwnerNameList using java.util.random to generate a random integer which is between 0 and the length of the string array.
	 * The random integer is then used as the index for the return of this function.
	 * @return the OwnerNameList variable at the random index generated
	 */
	public static String getRandomOwnerName() {
		Random random = new Random();
		int size = ownerNameList.length;
		return ownerNameList[random.nextInt(size)];
	}
	
	/**
	 * Returns the Owner Name of the animal, which is required as owner name is protected and therefore requires a public function for a super class to access the owner name.
	 * @return the owner name of the animal
	 */
	public String getOwnerName() {
		return ownerName;
	}
	
	/**
	 * Public function to return the protected integer weight of the animal.
	 * @return the weight of the animal
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * Public function to return the protected integer height of the animal.
	 * @return the height of the animal
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Sets the vet of the animal. The vet is not used in the Animal constructor.
	 * @param vet has to be of the Vet Class
	 */
	public void setVet(Vet vet) {
		assignedVet = vet;
	}
	
	/**
	 * Sets the check in clerk of the animal. The check in clerk is not used in the Animal constructor.
	 * @param clerkIn has to be of the Clerk Class
	 */
	public void setClerkIn (Clerk clerkIn) {
		checkinClerk = clerkIn;
	}
	
	/**
	 * Sets the check out clerk of the animal. The check out clerk is not used in the Animal Constructor.
	 * @param clerkOut has to be of the Clerk Class
	 */
	public void setClerkOut (Clerk clerkOut) {
		checkoutClerk = clerkOut;
	}
}
