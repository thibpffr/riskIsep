
public class Territory {
	private int territoryNumber;
	private Region territoryRegion;
	private int [] borderTerritories={}; //string list
	
	private Player playerWhoControlls=null;
	private int nSoldiers=0;
	private int nCavalry=0;
	private int nGuns=0;
	
	
	public static boolean attackTerritoryCheck(Territory terOrigine, Territory terCible,int nGunsAttaquant, int nCavalryAttaquant,int nSoldiersAttaquant ){
		// la fonction renvoie true si l'attaque est possible, 0 sinon
		int nAttaque=nGunsAttaquant+nSoldiersAttaquant+nCavalryAttaquant;
		int nPresent=terOrigine.getnCavalry()+terOrigine.getnGuns()+terOrigine.getnSoldiers();
		// verifier que les territoires sont voisins
			if (!isABorderTerritory(terOrigine,terCible)){
				System.out.println("Les territoires choisis ne sons pas voisins");
				return false;
			}

		// verifier que les territoires ne sont pas au meme player
			else if (terOrigine.getPlayerWhoControlls()==terCible.getPlayerWhoControlls()){
				System.out.println("Les territoires appartiennent au meme joueur");
				return false;
			}
		// Verifier qu'il y a max 3 troupes qui attaquent
			
			else if (nAttaque>3 || nAttaque<=0){
				System.out.println("Le nombre de troupes qui attaque est impossible");
				System.out.println("nombre négatif ou supérieur à 3");
				return false;
				
			}
		//Verifier qu'il reste au moins une troupe qui ne se bat pas
			else if (nAttaque>=nPresent+1){
				System.out.println("il faut laisser au moins une unité non combattante sur les territoire");
				return false;
				
			}

		// verifier que les troupes qui attaquent sont bien sur le territoire
			else if ((terOrigine.getnGuns()<nGunsAttaquant)||(terOrigine.getnSoldiers()<nSoldiersAttaquant)||(terOrigine.getnCavalry()<nCavalryAttaquant)){
				System.out.println("Il y a plus d'unité attaquantes que d'unités sur le territoire");
				return false;
			}
			else{
				return true;
			}
			
		
	}
	public static boolean isABorderTerritory(Territory terOrigine, Territory terCible){
		int[] listeVoisins={};
		int rep=0;
		listeVoisins=terOrigine.getBorderTerritories();
		for (int i=0;i<listeVoisins.length;i++){
			if (listeVoisins[i]==terCible.getTerritoryNumber())
				rep=1;
		}
		if (rep==0){
			
			return false;
		}
		return true;
	}
	
	public static boolean territoryWins(Territory terOrigine, Territory terCible,int nGunsRestants, int nCavalryRestants,int nSoldiersRestants){
		// cette fonction renvoie true si le territoire a gagné sur l'autre et change le propriétaire du territoire dans ce cas
		// sinon il renvoie false s'il reste des unités qui peuvent se défendre sur le territoire
		
		// regarder s'il reste ou non des unités sur le ter cible 
			if ((terCible.getnCavalry()==0)&&(terCible.getnGuns()==0)&&(terCible.getnSoldiers()==0)){
				// dans ce cas il ne reste plus aucune unité combattante sur le territoire
				// le combat est donc gagné 
				
				// on change le player qui possede le territoire 
				terCible.setPlayerWhoControlls(terOrigine.getPlayerWhoControlls());
				
				// on met les unités combattantes qui ont gagné sur le territoire cible
				terCible.setnCavalry(nCavalryRestants);
				terCible.setnGuns(nGunsRestants);
				terCible.setnSoldiers(nSoldiersRestants);
				
				// ajouter le territoire dans la liste des territoires controlés par le joueur
				removeControlledTerritory(terCible.getPlayerWhoControlls(),terCible);
				addControlledTerritory(terOrigine.getPlayerWhoControlls(),terCible);
				
				return true;
			}
				
			else{
				// le combat n'est pas gagné, il reste des unités combattantes sur le territoire attaqué
				return false;
			}
		}
		
		
		
	
		
	
	
	public boolean moveArmy(Territory terOrigine, Territory terCible,int nGuns, int nCavalry,int nSoldiers){
		// cette fonction bouge des armées d'un territoire à un autre 
		// si le déplacement est posssible, elle l'effectue et renvoie true, sinon elle renvoie false
		
		int nUnitesDeplacees=nGuns+nCavalry+nSoldiers;
		int nUnitePresentes=terOrigine.getnGuns()+terOrigine.getnSoldiers()+terOrigine.getnCavalry();
		
		// on verifie que les deux territoires appartiennent au meme player
		if (terOrigine.getPlayerWhoControlls()!=terCible.getPlayerWhoControlls()){
			System.out.println("Les deux territoires n'appartiennent pas au meme joueur");
			return false;
		}
		// on verifie que les territoires sont bien a coté
		else if (!isABorderTerritory(terOrigine,terCible)){
			System.out.println("Les deux territoires ne sont pas voisins");
			return false;
		}
		
		// on verifie que les unités qui doivent etre deplacees sont bien presentes sur le territoire origine
		else if ((terOrigine.getnGuns()<nGuns)||(terOrigine.getnCavalry()<nCavalry)||(terOrigine.getnSoldiers()<nSoldiers)){
			System.out.println("Le nombre d'unité à déplacer n'est pas cohérent par rapport au nombre d'unités présents sur le territoire Origine");
			return false;
			
		}
		// on verifie qu'il reste une unité sur le territoire origine avant d'effectuer le déplacement
		else if (nUnitesDeplacees>=nUnitePresentes){
			System.out.println("Il faut laisser une unité sur le territoire origine");
			return false;
		}
		
		else{
			// dans ce cas on peut effectuer le deplacement
			// ter Origine
			terOrigine.setnGuns(terOrigine.getnGuns()-nGuns);
			terOrigine.setnCavalry(terOrigine.getnCavalry()-nCavalry);
			terOrigine.setnSoldiers(terOrigine.getnSoldiers()-nSoldiers);
			
			//terCible
			terCible.setnCavalry(terCible.getnCavalry()+nCavalry);
			terCible.setnGuns(terCible.getnGuns()+nGuns);
			terCible.setnSoldiers(terCible.getnSoldiers()+nSoldiers);
			
			return true;
		}
		
	}
	
	public void attackTerritory(){
		
	}
	
			
	
	
	
	public int getTerritoryNumber() {
		return territoryNumber;
	}
	public void setTerritoryNumber(int territoryNumber) {
		this.territoryNumber = territoryNumber;
	}
	public Region getTerritoryRegion() {
		return territoryRegion;
	}
	public void setTerritoryRegion(Region territoryRegion) {
		this.territoryRegion = territoryRegion;
	}
	public int[] getBorderTerritories() {
		return borderTerritories;
	}
	public void setBorderTerritories(int[] borderTerritories) {
		this.borderTerritories = borderTerritories;
	}
	public Player getPlayerWhoControlls() {
		return playerWhoControlls;
	}
	public void setPlayerWhoControlls(Player playerWhoControlls) {
		this.playerWhoControlls = playerWhoControlls;
	}
	public int getnSoldiers() {
		return nSoldiers;
	}
	public void setnSoldiers(int nSoldiers) {
		this.nSoldiers = nSoldiers;
	}
	public int getnCavalry() {
		return nCavalry;
	}
	public void setnCavalry(int nCavalry) {
		this.nCavalry = nCavalry;
	}
	public int getnGuns() {
		return nGuns;
	}
	public void setnGuns(int nGuns) {
		this.nGuns = nGuns;
	}
	
	


	
	
	
	

}
