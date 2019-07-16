package animals;

import java.util.Random;

public enum FurType {
	
	LONGHAIR,
	MEDIUMHAIR,
	SHORTHAIR,
	CURLY,
	SILKY,
	WIRY,
	SMOOTH,
	HAIRLESS;
	
	public static FurType getRandomFurType() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
	
}
