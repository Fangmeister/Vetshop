package animals;

import java.util.Random;

public class Dog extends Animal {
	
  /**
   * DogBreed enum dogBreed is defined for the Dog Class. It is used in the Dog constructor.
   * dogName is a string array which contains the list of possible names for dogs.
   */
  public DogBreed dogBreed;
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

	/**
	 * Creates an instance of the Dog class, which is a subclass of the Animal class. Dog has one additional parameter to Animal: Dog Breed.
	 * @param dogNameIn      The name of the dog
	 * @param ownerNameIn    The name of the owner
	 * @param weightIn			 The weight of the dog
	 * @param heightIn			 The height of the dog
	 * @param stayDurationIn The stay duration of the dog
	 * @param furTypeIn			 The fur type of the dog
	 * @param dogBreedIn		 The breed of the dog (enum)
	 */
	public Dog(String dogNameIn, String ownerNameIn, float weightIn, float heightIn, int stayDurationIn, FurType furTypeIn, DogBreed dogBreedIn) {
		super(dogNameIn, ownerNameIn, weightIn, heightIn, stayDurationIn, furTypeIn);
		dogBreed = dogBreedIn;
	}

	/**
	 * Randomly generates a dog name from the string array dogName. A random index of the string array is generated.
	 * @return the dogName list variable at the random index generated
	 */
	public static String getRandomDogName() {
	Random random = new Random();
	int size = dogName.length;
	return dogName[random.nextInt(size)];
	}
}
