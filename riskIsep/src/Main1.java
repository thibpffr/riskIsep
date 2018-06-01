import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main1 {
	static Interface interfMap;
	static Territory terOrigin;
	static Territory terCibl;
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
	static int [] Adj1= {2,3,4,42};
	static int [] Adj2= {4,1};
	static int [] Adj3= {1,5};
	static int [] Adj4= {2,3,1};
	static int [] Adj5= {6,7,3};
	static int [] Adj6= {7,5,10,9};
	static int [] Adj7= {5,6,8,9};
	static int [] Adj8= {7,9,13};
	static int [] Adj9= {6,7,8,10,11,13};
	static int [] Adj10= {6,9,11,12};
	static int [] Adj11= {9,10,12,13};
	static int [] Adj12= {10,11,26};
	static int [] Adj13= {8,9,10,11,14};
	static int [] Adj14= {13,15,16};
	static int [] Adj15= {14,16,17};
	static int [] Adj16= {14,15,18,19};
	static int [] Adj17= {15,18,20,22,23,21};
	static int [] Adj18= {15,16,17,20,19};
	static int [] Adj19= {16,18,20};
	static int [] Adj20= {41,42,17,18,19,21};
	static int [] Adj21= {20,40,41,22,30};
	static int [] Adj22= {21,30,29,23,17};
	static int [] Adj23= {17,24,22,29};
	static int [] Adj24= {23,25,27,28,29};
	static int [] Adj25= {24,26,27};
	static int [] Adj26= {12,25,27,28,32};
	static int [] Adj27= {24,25,26,28};
	static int [] Adj28= {29,24,27,26,32};
	static int [] Adj29= {22,23,24,28,30,31};
	static int [] Adj30= {21,22,29,31};
	static int [] Adj31= {29,30,33,34};
	static int [] Adj32= {28,26};
	static int [] Adj33= {31,34,36};
	static int [] Adj34= {33,35,36};
	static int [] Adj35= {34,36};
	static int [] Adj36= {33,34,35};
	static int [] Adj37= {38,40};
	static int [] Adj38= {39,37,40};
	static int [] Adj39= {38,40,42};
	static int [] Adj40= {21,38,39,41};
	static int [] Adj41= {21,20,40,42};
	static int [] Adj42= {39,40,41,20,1};
	static Territory Bresil = new Territory(1, Adj1,0.23,0.29,0.24,0.39);
	static Territory Argentine = new Territory(2, Adj2,0.18,0.24,0.09,0.25);
	static Territory Venezuela = new Territory(3, Adj3,0.16,0.23,0.39,0.45);
	static Territory Perou = new Territory(4, Adj4,0.16,0.18,0.28,0.36);
	static Territory Mexique = new Territory(5, Adj5,0.12,0.15,0.45,0.54);
	static Territory WUS = new Territory(6, Adj6,0.08,0.14,0.60,0.70);
	static Territory EUS = new Territory(7, Adj7,0.17,0.22,0.56,0.67);
	static Territory Quebec = new Territory(8, Adj8,0.2,0.26,0.70,0.8);
	static Territory Ontario = new Territory(9, Adj9,0.15,0.2,0.71,0.8);
	static Territory Alberta = new Territory(10, Adj10,0.09,0.15,0.72,0.81);
	static Territory NCanada = new Territory(11, Adj11,0.073,0.2,0.82,0.88);
	static Territory Alaska = new Territory(12, Adj12,0.025,0.072,0.8,0.89);
	static Territory Groenland = new Territory(13, Adj13,0.25,0.32,0.84,0.98);
	static Territory Islande = new Territory(14, Adj14,0.34,0.38,0.77,0.82);
	static Territory Scandinavie = new Territory(15, Adj15,0.4,0.47,0.74,0.87);
	static Territory UK = new Territory(16, Adj16,0.3,0.37,0.63,0.76);
	static Territory Russie = new Territory(17, Adj17,0.46,0.51,0.64,0.79);
	static Territory Allemagne = new Territory(18, Adj18,0.38,0.46,0.67,0.76);
	static Territory France = new Territory(19, Adj19,0.32,0.39,0.47,0.62);
	static Territory Italie = new Territory(20, Adj20,0.39,0.47,0.49,0.67);
	static Territory Arabie = new Territory(21, Adj21,0.48,0.56,0.35,0.55);
	static Territory Asia22 = new Territory(22, Adj22,0.54,0.6,0.57,0.7);
	static Territory Asia23 = new Territory(23, Adj23,0.56,0.6,0.7,0.85);
	static Territory Asia24 = new Territory(24, Adj24,0.59,0.66,0.75,0.94);
	static Territory Asia25 = new Territory(25, Adj25,0.67,0.71,0.850,0.892);
	static Territory Asia26 = new Territory(26, Adj26,0.73,0.8,0.84,0.92);
	static Territory Asia27 = new Territory(27, Adj27,0.67,0.7,0.71,0.8);
	static Territory Asia28 = new Territory(28, Adj28,0.65,0.73,0.62,0.7);
	static Territory Chine = new Territory(29, Adj29,0.62,0.73,0.50,0.61);
	static Territory Inde = new Territory(30, Adj30,0.58,0.66,0.32,0.51);
	static Territory Asia31 = new Territory(31, Adj31,0.67,0.7,0.39,0.47);
	static Territory Japon = new Territory(32, Adj32,0.77,0.79,0.6,0.71);
	static Territory Oceania33 = new Territory(33, Adj33,0.66,0.72,0.2,0.29);
	static Territory NewZeland = new Territory(34, Adj34,0.75,0.79,0.26,0.33);
	static Territory EAustralia = new Territory(35, Adj35,0.79,0.83,0.03,0.2);
	static Territory WAustralia = new Territory(36, Adj36,0.52,0.56,0.03,0.16);
	static Territory Madagascar = new Territory(37, Adj37,0.70,0.075,0.05,0.17);
	static Territory SAfrica = new Territory(38, Adj38,0.43,0.49,0.05,0.17);
	static Territory Congo = new Territory(39, Adj39,0.41,0.49,0.17,0.3);
	static Territory Somalie = new Territory(40, Adj40,0.46,0.55,0.16,0.37);
	static Territory Egypt = new Territory(41, Adj41,0.42,0.49,0.36,0.45);
	static Territory Maghreb = new Territory(42, Adj42,0.33,0.44,0.27,0.48);
	static Territory[] territoryList = {Bresil,Argentine,Venezuela,Perou,Mexique,WUS,EUS,Quebec,Ontario,Alberta,NCanada,Alaska,Groenland,Islande,Scandinavie,UK,Russie,Allemagne,France,Italie,Arabie,Asia22,Asia23,Asia24,Asia25,Asia26,Asia27,Asia28,Chine,Inde,Asia31,Japon,Oceania33,NewZeland,EAustralia,WAustralia,Madagascar,SAfrica,Congo,Somalie,Egypt,Maghreb};
	static ArrayList<Player> tableauJoueurs = new ArrayList<Player>();
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// -----------------declaration des variables---------------
		
		int choix; // choix du joueur (d�placer des arm�es, passser son tour ou attaquer)
		int terOrigine; //numero du territoire origine renvoy� par la fonction territoryChoice 
		// territoire lui meme identifi� par son numero par la variable juste au dessus
		int terCible;// de meme qu'au dessus
		//pareil
		
		
		//variables pour les attaques
		int[][] tabAttaque;
		int[][]tabDefense;
		
			// variables interm�diaires pour effectuer les d�placements
		int nGuns=0;
		int nCavalry=0;
		int nSoldiers=0;
		
		// demander de rentrer le nombre de joueurs qui jouent
		String[] choices = {"2", "3", "4", "5", "6"};
		int nbJoueurs = Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Combien de joueurs ?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choices, "2"));
		//Player[] tableauJoueurs= new Player[nbJoueurs];
		for(int i=0;i<nbJoueurs;i++) {
			Player p = new Player(i+1);
			tableauJoueurs.add(p);
		}
				
		// attribution al�atoire des territoires a chaque joueur
				int j=0;
				for (int i=0; i<territoryList.length;i++) {
					territoryList[i].setPlayerWhoControlls(tableauJoueurs.get(j));
					tableauJoueurs.get(j).controlledTerritories.add(territoryList[i].getTerritoryNumber());//on rajoute le territoire � la liste des territoires controll�s par le joueur.
					territoryList[i].setnSoldiers(1);
					System.out.println("Le territoire "+territoryList[i].getTerritoryNumber()+" a ete associ� au joueur"+tableauJoueurs.get(j).getPlayerNumber());
					j++;
					if (j>=nbJoueurs) {
						j=0;
					}
				}		
				
				
				
				
		// creation de la carte et de l'interface		
		interfMap = new Interface(1080,720);
		interfMap.ecranCarte(territoryList);
		Player playerTurn=tableauJoueurs.get(0);
		int troupDepart=0;
		//Definition du nombre de Troupe de depart en fonction du nombre de joueur
		for (int i =0; i<tableauJoueurs.size();i++) {
			if (tableauJoueurs.size()==2) {
				troupDepart=40;
			}
			else if (tableauJoueurs.size()==3) {
				troupDepart=35;
			}
			else if (tableauJoueurs.size()==4) {
				troupDepart=30;
			}
			else if (tableauJoueurs.size()==5) {
				troupDepart=25;
			}
			else {
				troupDepart=20;
			}
			
		}
		//chaque joueur places ses troupes sur leur territoire
				int numberOfTroup=troupDepart+playerTurn.getnTroup();
				int troupUsed=0;
				for (int i =0; i<tableauJoueurs.size();i++) {
					while(numberOfTroup!=0) {
						System.out.println("Choisir o� placer des troupes");
						terCible= interfMap.territoryChoice();
						terCibl=territoryList[terCible];
						System.out.println("Territoire "+terCibl.getTerritoryNumber());
						if (terCibl.getPlayerWhoControlls()==playerTurn) {
								troupUsed=Territory.placerTroupe(numberOfTroup, terCibl);
						}
						numberOfTroup=numberOfTroup-troupUsed;
					}
				}
				for(int player=0;player<tableauJoueurs.size();player++) {
					playerTurn=tableauJoueurs.get(player);
					System.out.println("c'est le tour du Joueur "+playerTurn.getPlayerNumber());
		
					
					java.lang.Thread.sleep(300);
					//interfMap.positionSouris();
					System.out.println("que faire?");
					choix = interfMap.actionChoice();
					if (choix==-1) {
						while (choix==-1) {
							choix = interfMap.actionChoice();
						}
						}
					while(choix==0) {
		// s'il veut d�placer des troupes 
			
					if (choix==0)
				
			{
				// le joueur choisit le territoire origine depuis lequel il veut d�placer des arm�es
						System.out.println("choix = deplacement");
						java.lang.Thread. sleep(1000);
						System.out.println("choisir un territoire");
						terOrigine= interfMap.territoryChoice();
						terOrigin=territoryList[terOrigine];
						System.out.println("territoire "+terOrigin.getTerritoryNumber());
						
				
						System.out.println("choisir un territoire");
						
				// le joueur choisit le territoire cible
						if (terOrigin.getPlayerWhoControlls()==playerTurn) {
							terCible = interfMap.territoryChoice();
							terCibl=territoryList[terCible];
							System.out.println("territoire "+terCibl.getTerritoryNumber());
							
							int[] unitTable = Territory.chooseUnit(terOrigin);
							nGuns= unitTable[0];
							nCavalry= unitTable[1];
							nSoldiers= unitTable[2];
				
				//Le joueur choisit le nombre d'arm�es � d�placer 
				
				
				// !!!!!! initialiser nguns,ncavalry et nsoldiers
				
				
				
		
				
				
				if(Territory.moveArmy(terOrigin,terCibl,nGuns,nCavalry,nSoldiers))
					{
						System.out.println("Le d�placement a �t� effectu�");
					}
				
				else
				{
					System.out.println("Echec du d�placement");
				}
						}
						else {
							System.out.println("ce territoire n'es pas � toi");
						}
			}
					System.out.println("que faire?");
					choix = interfMap.actionChoice();
					if(choix==-1) {
						while(choix==-1) {
						choix = interfMap.actionChoice();
						}
					}
					}
			
			if (choix==1){
				// on est dans le cas ou le joueur choisit d'attaquer un territoire
				// le joueur choisit le territoire origine depuis lequel il veut attaquer
				System.out.println("choisissez le ter");
				terOrigine= interfMap.territoryChoice();
				System.out.println("terOrigine"+terOrigine+"choisi");
				terOrigin = territoryList[terOrigine];
				
				
				
				// le joueur choisit le territoire cible
				java.lang.Thread.sleep(500);
				terCible = interfMap.territoryChoice();
				System.out.println("ter"+terCible+"choisi");
				terCibl = territoryList[terCible];
				System.out.println("ok!");
				
				// on fait joueur les unit�s
				// chacune g�n�re les chiffres pour le match de d�s correspondant � sa capacit�
				
				if (Territory.attack(terOrigin,terCibl)){
					System.out.println("Territoire conquis");
				}
				else{
					System.out.println("Echec de la conquete");
				}
				
			}
			if(player==tableauJoueurs.size()) {
				player=-1;
			}
			}
	}
	}
	

