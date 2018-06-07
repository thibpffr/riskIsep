import java.util.ArrayList;

public class Player {
	public Missions playerMission;
	private int playerNumber;
	public Player(int playerName) {
		this.playerNumber = playerName;
	}
	private int nTroup=0;
	static ArrayList<Integer> controlledTerritories = new ArrayList<Integer>();
	static ArrayList<Integer> controlledRegions=new ArrayList<Integer>();




	/*public static boolean isControlledTerritory(int territoryNumber) {
		for(int i : controlledTerritories) {	
		if(i==territoryNumber){
			return true;
		}
		}
		return false;
	}*/
	
	

	public static int addRenfort(Player player) {
		int numberOfTroup=0;
		for (int i : player.controlledRegions) {
			numberOfTroup = numberOfTroup + Region.getNumberOfTerritory()/2;
		}
		numberOfTroup = numberOfTroup + player.controlledTerritories.size()/3;
		return numberOfTroup;
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
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerName) {
		this.playerNumber = playerName;
	}

	public int getnTroup() {
		return nTroup;
	}

	public void setnTroup(int nTroup) {
		this.nTroup = nTroup;
	}
	
	public ArrayList getControlledTerritories() {
		return controlledTerritories;
	}
	
	public ArrayList getControlledRegions() {
		return controlledRegions;
	}



	public Missions getPlayerMission() {
		return playerMission;
	}



	public void setPlayerMission(Missions playerMission) {
		this.playerMission = playerMission;
	}
	
		
	
}
