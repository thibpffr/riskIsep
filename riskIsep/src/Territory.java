
public class Territory {
	private int territoryNumber;
	private Region territoryRegion;
	private int [] borderTerritories={}; //string list
	
	private Player playerWhoControlls=null;
	private int nSoldiers=0;
	private int nCavalry=0;
	private int nGuns=0;
	
	
	public Territory(int territoryNumber, int[] borderTerritories) {
		this.territoryNumber = territoryNumber;
		this.borderTerritories = borderTerritories;
	}

	// Methodes
	public static void addControlledTerritory(Player player,Territory terCible) {
		player.controlledTerritories.add(terCible.getTerritoryNumber());
	}

	public static void removeControlledTerritory(Player player,Territory terCible) {
		player.controlledTerritories.remove(terCible.getTerritoryNumber());
	}

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
				System.out.println("nombre n�gatif ou sup�rieur � 3");
				return false;
				
			}
		//Verifier qu'il reste au moins une troupe qui ne se bat pas
			else if (nAttaque>=nPresent+1){
				System.out.println("il faut laisser au moins une unit� non combattante sur les territoire");
				return false;
				
			}

		// verifier que les troupes qui attaquent sont bien sur le territoire
			else if ((terOrigine.getnGuns()<nGunsAttaquant)||(terOrigine.getnSoldiers()<nSoldiersAttaquant)||(terOrigine.getnCavalry()<nCavalryAttaquant)){
				System.out.println("Il y a plus d'unit� attaquantes que d'unit�s sur le territoire");
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
		// cette fonction renvoie true si le territoire a gagn� sur l'autre et change le propri�taire du territoire dans ce cas
		// sinon il renvoie false s'il reste des unit�s qui peuvent se d�fendre sur le territoire
		
		// regarder s'il reste ou non des unit�s sur le ter cible 
			if ((terCible.getnCavalry()==0)&&(terCible.getnGuns()==0)&&(terCible.getnSoldiers()==0)){
				// dans ce cas il ne reste plus aucune unit� combattante sur le territoire
				// le combat est donc gagn� 
				
				// on change le player qui possede le territoire 
				terCible.setPlayerWhoControlls(terOrigine.getPlayerWhoControlls());
				
				// on met les unit�s combattantes qui ont gagn� sur le territoire cible
				terCible.setnCavalry(nCavalryRestants);
				terCible.setnGuns(nGunsRestants);
				terCible.setnSoldiers(nSoldiersRestants);
				
				// ajouter le territoire dans la liste des territoires control�s par le joueur
				removeControlledTerritory(terCible.getPlayerWhoControlls(),terCible);
				addControlledTerritory(terOrigine.getPlayerWhoControlls(),terCible);
				
				return true;
			}
				
			else{
				// le combat n'est pas gagn�, il reste des unit�s combattantes sur le territoire attaqu�
				return false;
			}
		}
		
		
		
	
		
	
	
	public boolean moveArmy(Territory terOrigine, Territory terCible,int nGuns, int nCavalry,int nSoldiers){
		// cette fonction bouge des arm�es d'un territoire � un autre 
		// si le d�placement est posssible, elle l'effectue et renvoie true, sinon elle renvoie false
		
		int nUnitesDeplacees=nGuns+nCavalry+nSoldiers;
		int nUnitePresentes=terOrigine.getnGuns()+terOrigine.getnSoldiers()+terOrigine.getnCavalry();
		
		// on verifie que les deux territoires appartiennent au meme player
		if (terOrigine.getPlayerWhoControlls()!=terCible.getPlayerWhoControlls()){
			System.out.println("Les deux territoires n'appartiennent pas au meme joueur");
			return false;
		}
		// on verifie que les territoires sont bien a cot�
		else if (!isABorderTerritory(terOrigine,terCible)){
			System.out.println("Les deux territoires ne sont pas voisins");
			return false;
		}
		
		// on verifie que les unit�s qui doivent etre deplacees sont bien presentes sur le territoire origine
		else if ((terOrigine.getnGuns()<nGuns)||(terOrigine.getnCavalry()<nCavalry)||(terOrigine.getnSoldiers()<nSoldiers)){
			System.out.println("Le nombre d'unit� � d�placer n'est pas coh�rent par rapport au nombre d'unit�s pr�sents sur le territoire Origine");
			return false;
			
		}
		// on verifie qu'il reste une unit� sur le territoire origine avant d'effectuer le d�placement
		else if (nUnitesDeplacees>=nUnitePresentes){
			System.out.println("Il faut laisser une unit� sur le territoire origine");
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
	
			
	
	// Getters & Setters
	
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
