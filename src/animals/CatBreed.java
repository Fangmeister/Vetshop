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
	
	public static CatBreed getRandomCatBreed() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}

}
