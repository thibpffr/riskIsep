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
	static Territory Bresil = new Territory(1, Adj1);
	static Territory Argentine = new Territory(2, Adj2);
	static Territory Venezuela = new Territory(3, Adj3);
	static Territory Perou = new Territory(4, Adj4);
	static Territory Mexique = new Territory(5, Adj5);
	static Territory WUS = new Territory(6, Adj6);
	static Territory EUS = new Territory(7, Adj7);
	static Territory Quebec = new Territory(8, Adj8);
	static Territory Ontario = new Territory(9, Adj9);
	static Territory Alberta = new Territory(10, Adj10);
	static Territory NCanada = new Territory(11, Adj11);
	static Territory Alaska = new Territory(12, Adj12);
	static Territory Groenland = new Territory(13, Adj13);
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
	static Territory Asia28 = new Territory(28, Adj28);
	static Territory Chine = new Territory(29, Adj29,0.62,0.73,0.50,0.61);
	static Territory Inde = new Territory(30, Adj30,0.58,0.66,0.32,0.51);
	static Territory Asia31 = new Territory(31, Adj31);
	static Territory Japon = new Territory(32, Adj32,0.77,0.79,0.6,0.71);
	static Territory Oceania33 = new Territory(33, Adj33);
	static Territory NewZeland = new Territory(34, Adj34);
	static Territory EAustralia = new Territory(35, Adj35);
	static Territory WAustralia = new Territory(36, Adj36,0.52,0.56,0.03,0.16);
	static Territory Madagascar = new Territory(37, Adj37);
	static Territory SAfrica = new Territory(38, Adj38,0.43,0.49,0.05,0.17);
	static Territory Congo = new Territory(39, Adj39,0.41,0.49,0.17,0.3);
	static Territory Somalie = new Territory(40, Adj40,0.46,0.55,0.16,0.37);
	static Territory Egypt = new Territory(41, Adj41,0.42,0.49,0.36,0.45);
	static Territory Maghreb = new Territory(42, Adj42,0.33,0.44,0.27,0.48);
	static Territory[] territoryList = {Bresil,Argentine,Venezuela,Perou,Mexique,WUS,EUS,Quebec,Ontario,Alberta,NCanada,Alaska,Groenland,Islande,Scandinavie,UK,Russie,Allemagne,France,Italie,Arabie,Asia22,Asia23,Asia24,Asia25,Asia26,Asia27,Asia28,Chine,Inde,Asia31,Japon,Oceania33,NewZeland,EAustralia,WAustralia,Madagascar,SAfrica,Congo,Somalie,Egypt,Maghreb};
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// -----------------declaration des variables---------------
		
		int nbJoueurs=0; 
		int choix=-1; // choix du joueur (déplacer des armées, passser son tour ou attaquer)
		int terOrigine; //numero du territoire origine renvoyé par la fonction territoryChoice 
		Territory terOrigin;// territoire lui meme identifié par son numero par la variable juste au dessus
		int terCible;// de meme qu'au dessus
		Territory terCibl;//pareil
		
			// variables intermédiaires pour effectuer les déplacements
		int nGuns=0;
		int nCavalry=0;
		int nSoldiers=0;
		
		// demander de rentrer le nombre de joueurs qui jouent
		String[] choices = {"2", "3", "4", "5", "6"};
		nbJoueurs= Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Combien de joueurs ?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choices, "2"));
		System.out.println("nbjoueurs="+nbJoueurs);
		// tableau des jouerus
				Player[] tableauJoueurs=new Player[nbJoueurs];
		// creation des différents joueurs 
				for (int i=0;i<nbJoueurs;i++){
					//Missions m = Missions.giveAMission(nbJoueurs, Missions.missionTab);
					
					Player p= new Player ();
					
					tableauJoueurs[i]=p;
					
				}
				
		// attribution aléatoire des territoires a chaque joueur
				int j=0;
				for (int i=0; i<territoryList.length;i++) {
					territoryList[i].setPlayerWhoControlls(tableauJoueurs[j]);
					tableauJoueurs[j].controlledTerritories.add(territoryList[i].getTerritoryNumber());//on rajoute le territoire à la liste des territoires controllés par le joueur.
					j++;
					if (j>=nbJoueurs) {
						j=0;
					}
				}		
				
				
				
				
		// creation de la carte et de l'interface		
		interfMap = new Interface(1080,720);
		interfMap.ecranCarte();
		
		choix = Interface.actionChoice();
		System.out.println("choix="+choix);
		java.lang.Thread.sleep(500);
		// s'il veut déplacer des troupes 
			if (choix==0)
				
			{
				// le joueur choisit le territoire origine depuis lequel il veut déplacer des armées
				System.out.println("choisissez le ter");
				terOrigine= Interface.territoryChoice();
				System.out.println("terOrigine"+terOrigine+"choisi");
				terOrigin = territoryList[terOrigine];
				
				
				
				// le joueur choisit le territoire cible
				java.lang.Thread.sleep(500);
				terCible = Interface.territoryChoice();
				System.out.println("ter"+terCible+"choisi");
				terCibl = territoryList[terCible];
				System.out.println("ok!");
				
				//Le joueur choisit le nombre d'armées à déplacer 
				
				
				// !!!!!! initialiser nguns,ncavalry et nsoldiers
				
				
				
		
				
				
				if(Territory.moveArmy(terOrigin,terCibl,nGuns,nCavalry,nSoldiers))
					{
						System.out.println("Le déplacement a été effectué");
					}
				else
				{
					System.out.println("Echec du déplacement");
				}
			}

		
	
	}
	}
	

