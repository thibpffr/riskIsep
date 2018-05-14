
public class Territory {
	private int territoryNumber;
	private Region territoryRegion;
	private int [] borderTerritories={}; //string list
	
	private Player playerWhoControlls=null;
	private int nSoldiers=0;
	private int nCavalry=0;
	private int nGuns=0;
	
	
	public static boolean attackTerritoryCheck(Territory terOrigine, Territory terCible,int nGunsAttaquant, int nCavalryAttaquant,int nSoldiersAttaquant ){
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
	
	public static void territoryWins(){
		// nsoldiers, cavaliers canons sont posés sur le nouveau territoire
		// regarder s'il reste ou non des unités sur le ter cible 
		// si oui -> return false
		// sinon change of owner
	}
	public void isABorderTerritory(){
		
	}
	
	public void moveArmy(){
		
	}
	public void territoryChangeOfOwner(){
		
	}
	public void attackTerritory(){
		
	}
	
			
	
	
	public void addABorderTerritory(Territory ter){
	Territory T=this.borderTerritories;
	while (T.next!=null){
		T=T.next;
	}
	T.next=ter;
	}
	
	public int Length(){
		Territory T=this ;
		int i=0;
		while (T!=null){
			i++;
			T=T.next;
		}
		return i;
	}
	
	
	public Territory RemoveBorderTerritory(Territory ter){
		Territory T=this;//ListeEntier RI = this;
		Territory debutListe=T;//ListeEntier debutListe=RI;
		if (debutListe==ter)
			return T.next;
		
		int len=T.Length();//int len = RI.Longueur();
		
			for (int i=0;i<len-1;i++){
				if (T.next==ter){
					T.next=T.next.next;
					return debutListe;
				}
				T=T.next;
			}
			
			System.out.println("Le territoire demandé n'a pas pu être enlevé car il n'appartient pas a la liste");// cas ou on a pas trouvé ter
			return debutListe;
	}
	
	public void deplacerArmees(Territory terCible,int nSol,int nCal, int nGuns){
		if((this.nSoldiers-nSol<0)&&(this.nCavalry-nCal<0)&&(this.nGuns-nGuns<0)){
			System.out.println("Action impossible");
		}
		//il faut laisser au moins 1 unité armée sur chaque territoire
		if (!this.isABorderTerritory(terCible))
		{
			//Errors102.displayErrors();
		}
		else{
		terCible.setnSoldiers(terCible.getnSoldiers()+nSol);
		this.setnSoldiers(this.getnSoldiers()-nSol);
		terCible.setnCavalry (terCible.getnCavalry()+nCal);
		this.setnCavalry(this.getnCavalry()-nCal);
		terCible.setnGuns(terCible.getnGuns()+nGuns);
		this.setnGuns(this.getnGuns()-nGuns);
		}
			
	}
	
	public boolean territoryAttacksATerritory(Territory terCible){
		if(!this.isABorderTerritory(terCible)){
			//Error102.displayError();
			return false;
		}
		else if (this.playerWhoControlls==terCible.playerWhoControlls){
			//Error101.displayError();
			return false;
		}
		else{
			while (terOrigine.nCavalry!=0)
		}
	}
	public void territoryChangeOfOwner(Player pWhoLose,Player pWhoWon){
		// Cette fonction met le joueur gagnant comme propritaire du territoire et l'ajoute a la liste des 
		//territoires controlés par le gagnant
		// il enleve aussi le territoire de la liste des territoires controlés du perdant
		pWhoLose.RemoveControlledTerritory( this);
		this.setPlayerWhoControlls(pWhoWon);
		pWhoWon.addAControlledTerritory(this);
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
