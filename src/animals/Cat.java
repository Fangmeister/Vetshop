package animals;

import java.util.Random;


public class Cat extends Animal {

	//CatBreed enum catBreed is defined for the Cat Class. It is used in the Cat constructor.
	public CatBreed catBreed;
	//catName is a string array which contains the list of possible names for cats.	
	public static String[] catName = {
			"Oliver", 
			"Leo", 
			"Charlie", 
			"Milo", 
			"Max", 
			"Jack", 
			"George", 
			"Simon", 
			"Loki", 
			"Simba",
			"Luna", 
			"Chloe", 
			"Bella", 
			"Lucy", 
			"Lily", 
			"Sophie", 
			"Lola", 
			"Zoe", 
			"Cleo", 
			"Nala",
	};
	
	
	/**
	 * Creates an instance of the Cat class, which is a subclass of the Animal class. Cat has one additional parameter to Animal: Cat Breed.
	 * @param catNameIn				The name of the cat
	 * @param ownerNameIn			The name of the owner
	 * @param weightIn				The weight of the cat
	 * @param heightIn				The height of the cat
	 * @param stayDurationIn	The stay duration of the cat
	 * @param furTypeIn				The fur type of the cat
	 * @param catBreedIn			The breed of the cat (enum)
	 */
	public Cat(String catNameIn, String ownerNameIn, float weightIn, float heightIn, int stayDurationIn, FurType furTypeIn, CatBreed catBreedIn) {
		super(catNameIn, ownerNameIn, weightIn, heightIn, stayDurationIn, furTypeIn);
		catBreed = catBreedIn;
	}
		
	/**
	 * Generates a random cat name from the string array catName. A random index of the array is generated.
	 * @return The catName list variable at the random index generated
	 */
	public static String getRandomCatName() {
		Random random = new Random();
		int size = catName.length;
		return catName[random.nextInt(size)];
	}
}
