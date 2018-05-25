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
	
	//creationJeu();
	public static void creationJeu() {
		int[] listSAmericaTerritory = {1,2,3,4};
		int[] listNAmericaTerritory = {5,6,7,8,9,10,11,12,13};
		int[] listEuropeTerritory = {14,15,16,17,18,19,20};
		int[] listAsiaTerritory = {21,22,23,24,25,26,27,28,29,30,31,32};
		int[] listOceaniaTerritory = {33,34,35,36};
		int[] listAfricaTerritory = {37,38,39,40,41,42};
		Region NAmerica = new Region(1,4,listSAmericaTerritory);
		Region SAmerica = new Region(2,9,listNAmericaTerritory);
		Region Europe = new Region(3,7,listEuropeTerritory);
		Region Asia = new Region(4,12,listAsiaTerritory);
		Region Oceania = new Region(5,4,listOceaniaTerritory);
		Region Africa = new Region(6,6,listAfricaTerritory);
	}
}
