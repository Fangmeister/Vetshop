package animals;

import java.util.Random;

public enum CatBreed {
	
	BRITISHSHORTHAIR,
	PERSIAN,
	AMERICANSHORTHAIR,
	SCOTTISHFOLD,
	SPHYNX,
	DEVONREX,
	MAINECOON,
	ABYSSINIAN,
	BENGAL,
	BURMESE,
	MANX,
	SAVANNAH;
	
	/**
	 * Randomly generates a cat breed from the enum CatBreed, which contains a list of possible cat breeds for the Cat Class.
	 * @return The CatBreed variable at the random index generated by the Random() function
	 */
	public static CatBreed getRandomCatBreed() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}

}
