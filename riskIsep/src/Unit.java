import java.util.Random;

/*package riskIsep;*/

public class Unit {
	int nbDeplacements;
	int puissanceMax;
	int puissanceMin;
	int type;
	
	public static int unitPlays(Unit u){
			
		int num=0;
		num= u.getPuissanceMin() + (int)(Math.random() * u.getPuissanceMax());
		return num;
	}
	
	public static int []defense(Territory ter){
		int [][] tableauDef;
		int nbDef=0;
		int n;
		while (nbDef<2){
			
		}
	}
	
	public int getNbDeplacements() {
		return nbDeplacements;
	}

	public void setNbDeplacements(int nbDeplacements) {
		this.nbDeplacements = nbDeplacements;
	}

	public int getPuissanceMax() {
		return puissanceMax;
	}

	public void setPuissanceMax(int puissanceMax) {
		this.puissanceMax = puissanceMax;
	}

	public int getPuissanceMin() {
		return puissanceMin;
	}

	public void setPuissanceMin(int puissanceMin) {
		this.puissanceMin = puissanceMin;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
