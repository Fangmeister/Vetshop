package animals;

import java.util.Random;
import veterinary.Vet;

public class Dog extends Animal {
	
    public DogBreed dogbreed;
	public static String[] dogName = {
    		"Charlie", 
    		"Max", 
    		"Buddy", 
    		"Oscar", 
    		"Milo", 
    		"Archie", 
    		"Ollie", 
    		"Toby", 
    		"Jack", 
    		"Teddy",
    		"Bella", 
    		"Molly", 
    		"Coco", 
    		"Ruby", 
    		"Lucy", 
    		"Bailey", 
    		"Daisy", 
    		"Rosie", 
    		"Lola", 
    		"Frankie",
    };

	public Dog(String dogNameIn, String ownerNameIn, float weightIn, float heightIn, int stayDurationIn, FurType furTypeIn, DogBreed dogBreedIn) {
		super(dogNameIn, ownerNameIn, weightIn, heightIn, stayDurationIn, furTypeIn);
		dogbreed = dogBreedIn;
	}
	
	
	public int getStayDuration () {
		return stayDuration;
	}
	
//	public void setDogName(DogName dogNameIn) {
//		this.dogName = dogNameIn;
//	} only need this function if you want to change the dog's name multiple times
	
	public String getDogName() {
		return name;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public DogBreed getDogBreed() {
		return dogbreed;
	}
	
	public static String getRandomDogName() {
	Random random = new Random();
	int size = dogName.length;
	return dogName[random.nextInt(size)];
	}
	
}
