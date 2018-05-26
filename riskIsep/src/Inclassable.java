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
		int [] Adj1= {2,3,4,42};
		int [] Adj2= {4,1};
		int [] Adj3= {1,5};
		int [] Adj4= {2,3,1};
		int [] Adj5= {6,7,3};
		int [] Adj6= {7,5,10,9};
		int [] Adj7= {5,6,8,9};
		int [] Adj8= {7,9,13};
		int [] Adj9= {6,7,8,10,11,13};
		int [] Adj10= {6,9,11,12};
		int [] Adj11= {9,10,12,13};
		int [] Adj12= {10,11,26};
		int [] Adj13= {8,9,10,11,14};
		int [] Adj14= {13,15,16};
		int [] Adj15= {14,16,17};
		int [] Adj16= {14,15,18,19};
		int [] Adj17= {15,18,20,22,23,21};
		int [] Adj18= {15,16,17,20,19};
		int [] Adj19= {16,18,20};
		int [] Adj20= {41,42,17,18,19,21};
		int [] Adj21= {20,40,41,22,30};
		int [] Adj22= {21,30,29,23,17};
		int [] Adj23= {17,24,22,29};
		int [] Adj24= {23,25,27,28,29};
		int [] Adj25= {24,26,27};
		int [] Adj26= {12,25,27,28,32};
		int [] Adj27= {24,25,26,28};
		int [] Adj28= {29,24,27,26,32};
		int [] Adj29= {22,23,24,28,30,31};
		int [] Adj30= {21,22,29,31};
		int [] Adj31= {29,30,33,34};
		int [] Adj32= {28,26};
		int [] Adj33= {31,34,36};
		int [] Adj34= {33,35,36};
		int [] Adj35= {34,36};
		int [] Adj36= {33,34,35};
		int [] Adj37= {38,40};
		int [] Adj38= {39,37,40};
		int [] Adj39= {38,40,42};
		int [] Adj40= {21,38,39,41};
		int [] Adj41= {21,20,40,42};
		int [] Adj42= {39,40,41,20,1};
		Territory France = new Territory(19, Adj19);
	}
}
