import java.util.ArrayList;

public class Player {
	private int playerName;
	private int nSoldier=0;
	private int nCavalry=0;
	private int nCanon=0;
	ArrayList<Integer> controlledTerritories = new ArrayList<Integer>();
	ArrayList<Integer> controlledRegions=new ArrayList<Integer>();


	/*public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;*/
	}

	public int getnSoldier() {
		return nSoldier;
	}

	public void setnSoldier(int nSoldier) {
		this.nSoldier = nSoldier;
	}

	public int getnCavalry() {
		return nCavalry;
	}

	public void setnCavalry(int nCavalry) {
		this.nCavalry = nCavalry;
	}

	public int getnCanon() {
		return nCanon;
	}

	public void setnCanon(int nCanon) {
		this.nCanon = nCanon;
	}

	public void addControlledTerritory(int territoryNumber) {
		this.controlledTerritories.add(territoryNumber);
	}

	public void removeControlledTerritory(int territoryNumber) {
		this.controlledTerritories.remove(territoryNumber);
	}

	public void addControlledRegion(int regionNumber) {
		this.controlledRegions.add(regionNumber);
	}

	public void removeControlledRegion(int regionNumber) {
		this.controlledRegions.remove(regionNumber);
	}



	//------------------- Initialisation ---------------------------------------
	
	
	/*public void nouveauxSoldatsACeTour(){
		// cette fonction compte le nombre de territoires et regions 
		//controlés pour donner de nouveaux soldats au joueur
		int length=this.controlledTerritories.Length();
		int l2=this.controlledRegions.Length();
		this.setnSoldiers(this.getnSoldiers()+(int)(Math.floor(length/3)));
		this.setnSoldiers(this.getnSoldiers()+(int)(Math.floor(l2/2)));
	}*/
	//-------------------  Macro fonctionnalités JEU  -------------------------------------
	
	
	
	
	//-------------------  Getters & Setters  ----------------------------------------

	
		
	
}
