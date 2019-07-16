package animals;

import java.util.Random;

public enum OwnerName {
	Emma,
	Olivia,
	Ava,
	Isabella,
	Sophia,
	Charlotte,
	Mia,
	Amelia,
	Harper,
	Evelyn,
	Abigail,
	Emily,
	Liam,
	Noah,
	William,
	James,
	Oliver,
	Benjamin,
	Elijah,
	Lucas,
	Mason,
	Logan,
	Alexander,
	Ethan;
	
	public static OwnerName getRandomOwnerName() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}
