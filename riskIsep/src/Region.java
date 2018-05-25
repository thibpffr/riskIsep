
public class Region {

	private int regionNumber;
	private int numberOfTerritory;
	private int[] territoryInRegion;




/*public int Length(){
	Region T=this ;
	int i=0;
	while (T!=null){
		i++;
		T=T.next;
	}
	return i;
}*/



public void addControlledRegion(Player player, Region regCible) {
	player.controlledRegions.add(regCible.getRegionNumber());
}

public void removeControlledRegion(Player player, Region regCible) {
	player.controlledRegions.remove(regCible.getRegionNumber());
}

//Getters & Setters

public int getRegionNumber() {
	return regionNumber;
}

public int getNumberOfTerritory() {
	return numberOfTerritory;
}

public void setNumberOfTerritory(int numberOfTerritory) {
	this.numberOfTerritory = numberOfTerritory;
}

public int[] getTerritoryInRegion() {
	return territoryInRegion;
}

public void setTerritoryInRegion(int[] territoryInRegion) {
	this.territoryInRegion = territoryInRegion;
}
}