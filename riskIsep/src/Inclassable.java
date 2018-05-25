import java.util.Random;

public class Inclassable {
	public int cavalryPlays(){
		Random r = new Random();
		int valeur = 2 + r.nextInt(5);
		return valeur;
	}
	
	public int soldierPlays(){
		Random r = new Random();
		int valeur =  1+r.nextInt(5);
		return valeur;
	}
	public int gunsPlays(){
		Random r = new Random();
		int valeur = 2+r.nextInt(7);
		return valeur;
	}
	
	
}
