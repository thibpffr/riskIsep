
import java.util.Random;

public class Missions {
	// rajouter le numero du joueur si joueur a detruire
// creer un lien entre mission et joueur
	private int missionNumber;
	private int nbJoueurMinimum=1;
	private int nbJoueurMax;
	private int nbTerritoriesControlled=0;
	private int nbRegionControlled=0;
	private String nameOfControlledRegion="";
	private boolean mission2Armies;
	public static Missions [] missionTab;

	
	
public boolean isMissionSuceeded(Missions m,Player p){
		
}

public boolean missionDeletePlayer(Missions m, Player pAttaquant, Player pDefendant){
	if (pDefendant.getControlledTerritories().length==0){
		System.out.println("La mission du Player"+pAttaquant.getPlayerName()+" est reussie");
		return true;
	}
	return false;
}

public boolean missionNbTerritories(Missions m,Player p){
	int listLength=p.getControlledTerritories().length;
	if (listLength>=m.getNbTerritoriesControlled()){
		System.out.println("La mission du Player"+p.getPlayerName()+" est reussie");
		return true;
	}
	else {
		return false;
	}
	
}
public boolean missionTerritoriesAndRegions(Missions m,Player p){
	int [] listeTer=p.getControlledTerritories();
	int [] listeReg=p.getControlledRegions();
	if((m.getNbTerritoriesControlled()<=listeTer.length)&&(m.getNbRegionControlled()<=listeReg.length)){
		System.out.println("La mission du Player"+p.getPlayerName()+" est reussie");
		return true;
	
	}
	return false;
	
}
public boolean mission2Armies(Missions m, Player p){
	int nbTerControlesAvec2Armees=0;
	int [] listeTer=p.getControlledTerritories();
	Territory ter;
	int unites=0;
	 for (int i=0;i<listeTer.length;i++){
		 // on parcourt toute la liste des endroits controlles par le joueurs
		 ter=listeTer[i];
		 unites=ter.getNCavalry()+ter.getNSoldiers()+ter.getNGuns();
		 if (unites>2){
			 nbTerControlesAvec2Armees++;
			 
		 }
	 }
	 if (nbTerControlesAvec2Armees>18){
		 System.out.println("La mission du Player"+p.getPlayerName()+" est reussie");
		 return true;
	 }
	 return false;
}


public static Missions giveAMission(int nbJoueurs,Missions[] tab){
	int nb=0;
	
	Random rand = new Random(); 
	
	while (true){
		nb = rand.nextInt(tab.length - 1);
		if ((nbJoueurs>=tab[nb].getNbJoueurMinimum())&&(nbJoueurs>=tab[nb].getNbJoueurMax())){
			return tab[nb];
		}
	}
}



	

public int getMissionNumber() {
	return missionNumber;
}

public void setMissionNumber(int missionNumber) {
	this.missionNumber = missionNumber;
}

public int getNbJoueurMinimum() {
	return nbJoueurMinimum;
}

public void setNbJoueurMinimum(int nbJoueurMinimum) {
	this.nbJoueurMinimum = nbJoueurMinimum;
}

public int getNbJoueurMax() {
	return nbJoueurMax;
}

public void setNbJoueurMax(int nbJoueurMax) {
	this.nbJoueurMax = nbJoueurMax;
}

public int getNbTerritoriesControlled() {
	return nbTerritoriesControlled;
}

public void setNbTerritoriesControlled(int nbTerritoriesControlled) {
	this.nbTerritoriesControlled = nbTerritoriesControlled;
}

public int getNbRegionControlled() {
	return nbRegionControlled;
}

public void setNbRegionControlled(int nbRegionControlled) {
	this.nbRegionControlled = nbRegionControlled;
}

public String getNameOfControlledRegion() {
	return nameOfControlledRegion;
}

public void setNameOfControlledRegion(String nameOfControlledRegion) {
	this.nameOfControlledRegion = nameOfControlledRegion;
}
	
	

}
