package animals;

import java.util.Random;

public enum DogBreed {
	
	BULLDOG,
	POODLE,
	BEAGLE,
	BOXER,
	GOLDENRETRIEVER,
	CHIHUAHUA,
	GERMANSHEPERD,
	DACHSHUND,
	LABRETRIEVER,
	BORDERCOLLIE,
	ROTTWEILER,
	DALMATIAN;
	
	public static DogBreed getRandomDogBreed() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
	
}
