package animals;

import java.util.Random;
import veterinary.Vet;

public class Cat extends Animal {
	
	public CatBreed catBreed;
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
	
	
	public Cat(String catNameIn, String ownerNameIn, float weightIn, float heightIn, int stayDurationIn, FurType furTypeIn, CatBreed catBreedIn) {
		super(catNameIn, ownerNameIn, weightIn, heightIn, stayDurationIn, furTypeIn);
		catBreed = catBreedIn;
	}
	
	public int getStayDuration () {
		return stayDuration;
	}
	
	public String getCatName() {
		return name;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public CatBreed getCatBreed() {
		return catBreed;
	}
	
	public static String getRandomCatName() {
	Random random = new Random();
	int size = catName.length;
	return catName[random.nextInt(size)];
	}
}
