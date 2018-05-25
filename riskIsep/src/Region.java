
public class Region {

	private int regionNumber;
	private Region next;


public int Length(){
	Region T=this ;
	int i=0;
	while (T!=null){
		i++;
		T=T.next;
	}
	return i;
}

public void addControlledRegion(Player player, Region regCible) {
	player.controlledRegions.add(regCible.getRegionNumber());
}

public void removeControlledRegion(Player player, Region regCible) {
	player.controlledRegions.remove(regCible.getRegionNumber());
}

public int getRegionNumber() {
	return regionNumber;
}
}