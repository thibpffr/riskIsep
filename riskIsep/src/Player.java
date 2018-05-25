import java.util.ArrayList;

public class Player {
	private int playerName;
	private int nSoldier=0;
	private int nCavalry=0;
	private int nCanon=0;
	static ArrayList<Integer> controlledTerritories = new ArrayList<Integer>();
	static ArrayList<Integer> controlledRegions=new ArrayList<Integer>();




	public static boolean isControlledTerritory(int territoryNumber) {
		for(int i : controlledTerritories) {	
		if(i==territoryNumber){
			return true;
		}
		}
		return false;
	}
	
	

	public void addRenfort(Player player) {
		int numberOfTroup=0;
		numberOfTroup = player.controlledTerritories.size()/3;
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
	public int getPlayerName() {
		return playerName;
	}

	public void setPlayerName(int playerName) {
		this.playerName = playerName;
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
	
	public ArrayList getControlledTerritories() {
		return controlledTerritories;
	}
	
	public ArrayList getControlledRegions() {
		return controlledRegions;
	}
		
	
}
