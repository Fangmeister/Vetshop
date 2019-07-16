package animals;

import java.util.Random;
import veterinary.Vet;
import veterinary.Clerk;

public class Animal {
	
	public String name;
	protected String ownerName;
	protected float weight; //give max/min value for cat or dog
	protected float height; //give max/min valve for cat or dog
	public int stayDuration; //max = 4 days, min = 1 days
	public Vet assignedVet; 
	public Clerk checkinClerk;
	public Clerk checkoutClerk;
	public FurType furType;
	
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
	
	
	public Animal(String nameIn, String ownerNameIn, float weightIn, float heightIn, int stayDurationIn, FurType furTypeIn) {
		name = nameIn;
		ownerName = ownerNameIn;
		weight = weightIn;
		height = heightIn;
		stayDuration = stayDurationIn;
		furType = furTypeIn;
		
	}
	
	public static String getRandomOwnerName() {
		Random random = new Random();
		int size = ownerNameList.length;
		return ownerNameList[random.nextInt(size)];
		
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public float getWeight() {
		return weight;
	}

	public float getHeight() {
		return height;
	}

	public FurType getFurType() {
		return furType;
	}
	
	public void setVet(Vet vet) {
		assignedVet = vet;
	}
	
	public void setClerkIn (Clerk clerkIn) {
		checkinClerk = clerkIn;
	}
	
	public void setClerkOut (Clerk clerkOut) {
		checkoutClerk = clerkOut;
	}
}
