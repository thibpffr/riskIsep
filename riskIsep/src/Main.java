import java.util.ArrayList;




public class Main {
	static Interface interfMap;
	static Interface interfNbJoueurs;
	
		 
	public static void main(String[] args) {
		
		
		
		
		interfNbJoueurs=new Interface(500,500);
		interfNbJoueurs.ecranNbJoueurs();
		int nbJoueurs;
		nbJoueurs=Interface.posThib();
		
		
		
		interfMap = new Interface(1080,720);
		interfMap.ecranCarte();
		
		Interface.positionSouris();
		
		
		ArrayList<Player> tableauJoueurs= new ArrayList<Player>();
		// demander de rentrer le nombre de joueurs qui jouent
		
		// creation des différents joueurs 
		for (int i=0;i<nbJoueurs;i++){
			Missions m = Missions.giveAMission(nbJoueurs, Missions.missionTab);
			
			
			Player p= new Player ();
			
			tableauJoueurs.add(p);
			
		}
		
		// phase d'initialisation : les joueurs posent leurs soldats sur des territoires tour à tour
		
		
		
		
		
		
		
		// phase réelle de jeu qui ne s'arrete pas tant que aucun joueur n'a pas gagné
		
		
		boolean victoire =false;
		int choix ;
		while (!victoire){
			for (int j=0;j<nbJoueurs;j++){
				// Etape de renforts
				
				
				choix=-1;
				
				while (choix!=2)
				{
				// le joueur décide s'il veut attaquer ou déplacer des troupes 
				//0 si déplacement 
				//1 si attaque 
				//2 si passer son tour
				
				

				// s'il veut déplacer des troupes 
					if (choix==0)
					{
				
					// il choisit le territoire duquel les soldats doivent partir
				
					// il choisit combien d'unités il veut déplacer
				
				
						if (moveArmy(terOrigine,terCible,nGuns,nCavalry,nSoldiers))
						{
							System.out.println("Le déplacement a été effectué");
						}

				
					}
				
					else if (choix==1)
					{
					// nous sommes dans le cas d'une attaque 
					
					
					// choix du territoire depuis lequel on attaque
					
					
					// choix du territoire a attaquer 
					
					
					// choix des unités attaquantes
					
					
						if (attackTerritoryCheck(terOrigine,terCible,nGunsAttaquant, nCavalryAttaquant,nSoldiersAttaquant ))
						{
						
						// les unités jouent
						
						
							if (territoryWins(terOrigine,  terCible, nGunsRestants,nCavalryRestants, nSoldiersRestants))
							{
								System.out.println("Le territoire est gagné");
							}
						}
					
					
					}
					
					else if (choix==2)
					{
						// on est dans le cas ou le joueur a fini son tour 
						// on vérifie qu'il n'a pas gagné
						if (isMissionSuceeded(tableauJoueurs.get(j)))
						{
							victoire=true;
						}
					}
				}
		
			}
	
		}
	}
	
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
