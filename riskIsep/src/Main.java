import java.util.ArrayList;

public class Main {
	
		 
	public static void main(String[] args) {
		int nbJoueurs=5;
		ArrayList<Player> tableauJoueurs= new ArrayList<Player>();
		// demander de rentrer le nombre de joueurs qui jouent
		
		// creation des diff�rents joueurs 
		for (int i=0;i<nbJoueurs;i++){
			Missions m = Missions.giveAMission(nbJoueurs, Missions.missionTab);
			
			
			Player p= new Player ();
			
			tableauJoueurs.add(p);
			
		}
		
		// phase d'initialisation : les joueurs posent leurs soldats sur des territoires tour � tour
		
		
		
		
		
		
		
		// phase r�elle de jeu qui ne s'arrete pas tant que aucun joueur n'a pas gagn�
		
		
		boolean victoire =false;
		int choix ;
		while (!victoire){
			for (int j=0;j<nbJoueurs;j++){
				// Etape de renforts
				choix=-1;
				
				while (choix!=2)
				{
				// le joueur d�cide s'il veut attaquer ou d�placer des troupes 
				//0 si d�placement 
				//1 si attaque 
				//2 si passer son tour
				
				

				// s'il veut d�placer des troupes 
					if (choix==0)
					{
				
					// il choisit le territoire duquel les soldats doivent partir
				
					// il choisit combien d'unit�s il veut d�placer
				
				
						if (moveArmy(terOrigine,terCible,nGuns,nCavalry,nSoldiers))
						{
							System.out.println("Le d�placement a �t� effectu�");
						}

				
					}
				
					else if (choix==1)
					{
					// nous sommes dans le cas d'une attaque 
					
					
					// choix du territoire depuis lequel on attaque
					
					
					// choix du territoire a attaquer 
					
					
					// choix des unit�s attaquantes
					
					
						if (attackTerritoryCheck(terOrigine,terCible,nGunsAttaquant, nCavalryAttaquant,nSoldiersAttaquant ))
						{
						
						// les unit�s jouent
						
						
							if (territoryWins(terOrigine,  terCible, nGunsRestants,nCavalryRestants, nSoldiersRestants))
							{
								System.out.println("Le territoire est gagn�");
							}
						}
					
					
					}
					
					else if (choix==2)
					{
						// on est dans le cas ou le joueur a fini son tour 
						// on v�rifie qu'il n'a pas gagn�
						if (isMissionSuceeded(tableauJoueurs.get(j)))
						{
							victoire=true;
						}
					}
				}
		
			}
	
		}
	}
}
