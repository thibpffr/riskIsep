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
	static Territory Islande = new Territory(14, Adj14);
	static Territory Scandinavie = new Territory(15, Adj15);
	static Territory UK = new Territory(16, Adj16);
	static Territory Russie = new Territory(17, Adj17);
	static Territory Allemagne = new Territory(18, Adj18);
	static Territory France = new Territory(19, Adj19);
	static Territory Italie = new Territory(20, Adj20);
	static Territory Arabie = new Territory(21, Adj21);
	static Territory Asia22 = new Territory(22, Adj22);
	static Territory Asia23 = new Territory(23, Adj23);
	static Territory Asia24 = new Territory(24, Adj24);
	static Territory Asia25 = new Territory(25, Adj25);
	static Territory Asia26 = new Territory(26, Adj26);
	static Territory Asia27 = new Territory(27, Adj27);
	static Territory Asia28 = new Territory(28, Adj28);
	static Territory Chine = new Territory(29, Adj29);
	static Territory Inde = new Territory(30, Adj30);
	static Territory Asia31 = new Territory(31, Adj31);
	static Territory Japon = new Territory(32, Adj32);
	static Territory Oceania33 = new Territory(33, Adj33);
	static Territory NewZeland = new Territory(34, Adj34);
	static Territory EAustralia = new Territory(35, Adj35);
	static Territory WAustralia = new Territory(36, Adj36);
	static Territory Madagascar = new Territory(37, Adj37);
	static Territory SAfrica = new Territory(38, Adj38);
	static Territory Congo = new Territory(39, Adj39);
	static Territory Somalie = new Territory(40, Adj40);
	static Territory Egypt = new Territory(41, Adj41);
	static Territory Maghreb = new Territory(42, Adj42);
	static Territory[] territoryList = {Bresil,Argentine,Venezuela,Perou,Mexique,WUS,EUS,Quebec,Ontario,Alberta,NCanada,Alaska,Groenland,Islande,Scandinavie,UK,Russie,Allemagne,France,Italie,Arabie,Asia22,Asia23,Asia24,Asia25,Asia26,Asia27,Asia28,Chine,Inde,Asia31,Japon,Oceania33,NewZeland,EAustralia,WAustralia,Madagascar,SAfrica,Congo,Somalie,Egypt,Maghreb};
	
	
	
	
	
	public static void main(String[] args) {
		
		// -----------------declaration des variables---------------
		
		int nbJoueurs=0; 
		int choix=-1; // choix du joueur (d�placer des arm�es, passser son tour ou attaquer)
		int terOrigine; //numero du territoire origine renvoy� par la fonction territoryChoice 
		Territory terOrigin;// territoire lui meme identifi� par son numero par la variable juste au dessus
		int terCible;// de meme qu'au dessus
		Territory terCibl;//pareil
		
			// variables interm�diaires pour effectuer les d�placements
		int nGuns=0;
		int nCavalry=0;
		int nSoldiers=0;
		
		// demander de rentrer le nombre de joueurs qui jouent
		String[] choices = {"2", "3", "4", "5", "6"};
		nbJoueurs= Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Combien de joueurs ?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choices, "2"));
		System.out.println("nbjoueurs="+nbJoueurs);
		// tableau des jouerus
				Player[] tableauJoueurs=new Player[nbJoueurs];
		// creation des diff�rents joueurs 
				for (int i=0;i<nbJoueurs;i++){
					//Missions m = Missions.giveAMission(nbJoueurs, Missions.missionTab);
					
					Player p= new Player ();
					
					tableauJoueurs[i]=p;
					
				}
				
		// attribution al�atoire des territoires a chaque joueur
				
				
				
				
				
		// creation de la carte et de l'interface		
		interfMap = new Interface(1080,720);
		interfMap.ecranCarte();
		
		choix = Interface.actionChoice();
		System.out.println("choix="+choix);

		// s'il veut d�placer des troupes 
			if (choix==0)
				
			{
				// le joueur choisit le territoire origine depuis lequel il veut d�placer des arm�es
				terOrigine= Interface.territoryChoice();
				terOrigin = territoryList[terOrigine];
				
				// le joueur choisit le territoire cible
				terCible = Interface.territoryChoice();
				terCibl = territoryList[terCible];
					
				
				//Le joueur choisit le nombre d'arm�es � d�placer 
				
				
				// !!!!!! initialiser nguns,ncavalry et nsoldiers
				
				
				
				
				
				if (Territory.moveArmy(terOrigin,terCibl,nGuns,nCavalry,nSoldiers))
					{
						System.out.println("Le d�placement a �t� effectu�");
					}
				else
				{
					System.out.println("Echec du d�placement");
				}
			}

		
	
	}
	}
	

