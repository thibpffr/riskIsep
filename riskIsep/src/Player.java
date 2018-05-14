
public class Player {
	private int playerNumber;
	private int nSoldiers=0;
	private int nCavalry=0;
	private int nGun=0;
	private Territory controlledTerritories=null;
	private Region controlledRegions=null;
	
	public void Player(int num){
		this.playerNumber=num;
	}
	
	public void addAControlledTerritory(Territory ter){
		//Ajoute un territoire a la liste des territoires controles par le joueur
		Territory T=this.controlledTerritories;
		while (T.getNext()!=null){
			T=T.getNext();
		}
		T.setNext(ter);
	}
	
	
		
	public Territory RemoveControlledTerritory(Territory ter){
		// enleve le territoire de la liste des territoires controlés du joueur
		Territory T=this.controlledTerritories;//ListeEntier RI = this;
		Territory debutListe=T;//ListeEntier debutListe=RI;
		if (debutListe==ter)
			return T.getNext();
		int len=T.Length();//int len = RI.Longueur();
			
			for (int i=0;i<len-1;i++){
				if (T.getNext()==ter){
					T.setNext(T.getNext().getNext());
					return debutListe;
					}
					T.setNext(T.getNext());
				}
				
				System.out.println("Le territoire demandé n'a pas pu être enlevé car il n'appartient pas a la liste");// cas ou on a pas trouvé ter
				return debutListe;
		}

	//------------------- Initialisation ---------------------------------------
	
	
	public void nouveauxSoldatsACeTour(){
		// cette fonction compte le nombre de territoires et regions 
		//controlés pour donner de nouveaux soldats au joueur
		int length=this.controlledTerritories.Length();
		int l2=this.controlledRegions.Length();
		this.setnSoldiers(this.getnSoldiers()+(int)(Math.floor(length/3)));
		this.setnSoldiers(this.getnSoldiers()+(int)(Math.floor(l2/2)));
	}
	//-------------------  Macro fonctionnalités JEU  -------------------------------------
	
	
	
	
	//-------------------  Getters & Setters  ----------------------------------------

	public int getPlayerNumber() {
		return playerNumber;
	}



	public void setPlayerNumber(int number) {
		this.playerNumber = number;
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



	public int getnGun() {
		return nGun;
	}



	public void setnGun(int nGun) {
		this.nGun = nGun;
	}



	public Territory getControlledTerritories() {
		return controlledTerritories;
	}



	public void setControlledTerritories(Territory controlledTerritories) {
		this.controlledTerritories = controlledTerritories;
	}



	public Region getControlledRegions() {
		return controlledRegions;
	}



	public void setControlledRegions(Region controlledRegions) {
		this.controlledRegions = controlledRegions;
	}
		
	
}
