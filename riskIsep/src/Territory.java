import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Territory {
	private int territoryNumber;
	private Region territoryRegion;
	private int [] borderTerritories={}; //string list
	
	private Player playerWhoControlls=null;
	private int nSoldiers=0;
	private int nCavalry=0;
	private int nGuns=0;
	private double xMin;
	private double xMax;
	private double yMin;
	private double yMax;
	
	
	public Territory(int territoryNumber, int[] borderTerritories,double xmin,double xmax, double ymin,double ymax) {
		this.territoryNumber = territoryNumber;
		this.borderTerritories = borderTerritories;
		this.xMax=xmax;
		this.xMin=xmin;
		this.yMin=ymin;
		this.yMax=ymax;
		
	}

	// Methodes
	
	public static int placerTroupe(int numberOfTroup,Territory terCible) {
		int troupUsed=0;
		String[] choiceTroup = {"Soldat (-1)","Cavalier(-3)","Canon(-7)","Arreter"};
		String choixTroupe = (String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Quelle troupe voulez vous placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choiceTroup, "0");
		if (choixTroupe==choiceTroup[0]) {
			//Il faut encore choisir le nombre de soldat que l'on veut placer
			
			String[] choicenbSoldat = new String[numberOfTroup+1];
			for (int i=0;i<=numberOfTroup;i++) {
				choicenbSoldat[i]= String.valueOf(i+1);
			}
			int choixnbSoldat = Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Quelle troupe voulez vous placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choicenbSoldat, "0"));
			
			
			terCible.setnSoldiers(terCible.getnSoldiers()+choixnbSoldat);
			numberOfTroup=numberOfTroup-choixnbSoldat;
			troupUsed=choixnbSoldat;
			System.out.println("Il y sur le territoire: "+ terCible.getnSoldiers()+" soldats "+terCible.getnCavalry()+" cavaliers "+ terCible.getnGuns()+"canons");
			System.out.println("il reste "+numberOfTroup+" troupe � placer");
		}
		else if (choixTroupe==choiceTroup[1]) {
			String[] choicenbCavalier = new String[numberOfTroup+1];
			for (int i=0;i<=numberOfTroup;i++) {
				choicenbCavalier[i]= String.valueOf(i+1);
			}
			int choixnbCavalier = Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Quelle troupe voulez vous placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choicenbCavalier, "0"));
			
			terCible.setnCavalry(terCible.getnCavalry()+choixnbCavalier);
			numberOfTroup=numberOfTroup-3*choixnbCavalier;
			troupUsed=choixnbCavalier*3;
			System.out.println("Il y sur le territoire: "+ terCible.getnSoldiers()+" soldats "+terCible.getnCavalry()+" cavaliers "+ terCible.getnGuns()+"canons");
			System.out.println("il reste "+numberOfTroup+" troupe � placer");
		}
		else if (choixTroupe==choiceTroup[2]) {
			String[] choicenbCanon = new String[numberOfTroup+1];
			for (int i=0;i<=numberOfTroup;i++) {
				choicenbCanon[i]= String.valueOf(i+1);
			}
			int choixnbCanon = Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Quelle troupe voulez vous placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choicenbCanon, "0"));
			
			terCible.setnGuns(terCible.getnGuns()+choixnbCanon);
			numberOfTroup=numberOfTroup-7*choixnbCanon;
			troupUsed=choixnbCanon*7;
			System.out.println("Il y sur le territoire: "+ terCible.getnSoldiers()+" soldats "+terCible.getnCavalry()+" cavaliers "+ terCible.getnGuns()+"canons");
			System.out.println("il reste "+numberOfTroup+" troupe � placer");
		
		}
		return troupUsed;
	}
	
	
	
	
	
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
		
		
		
	
		
	
	
	public static boolean moveArmy(Territory terOrigine, Territory terCible,int nGuns, int nCavalry,int nSoldiers){
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
			System.out.println("nguns"+nGuns+" ncaval"+nCavalry+" nsoldiers"+nSoldiers);
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
			System.out.println("succes");
			return true;
		}
		
	}
	
	public static ArrayList<Integer> attackTerritory(Territory terOrigine){
		System.out.println("Choisissez les 3 unit�s que vous souhaiter utiliser pour attaquer");
		int nGuns=terOrigine.getnGuns();
		int nSoldiers=terOrigine.getnSoldiers();
		int nCavalry=terOrigine.getnCavalry();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int n=0;// nombre d'unit�s affect�s au combat
		String[] choiceTroup={"Soldat : "+nSoldiers,"Cavalier"+nCavalry,"Canon"+nGuns,"Attaquer Maintenant"};
		String choixTroupe="";
		// tab[i] pour le type d'arm�e :1 pour le soldat, 2 pour le canon et 3 pour le cavalier
		while((n<2)||(choixTroupe!=choiceTroup[3])){
			
			choixTroupe = (String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Quelle troupe voulez vous placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choiceTroup, "0");
			if (choixTroupe!=choiceTroup[1]){
				result.add(n,(int)Math.random()*6+1);
				result.add(n+1,1);
				nSoldiers--;
				n++;
				
			}
			else if (choixTroupe!=choiceTroup[2]){
				result.add(n,(int)Math.random()*7+2);
				result.add(n+1,3);
				nCavalry--;
				n++;
				
			}
			else{
				result.add(n,(int)Math.random()*9+4);
				result.add(n+1,2);
				nGuns--;
				n++;
				
			}
			System.out.println("n="+n);
		}
		return result;
				
	}
	
	
public static ArrayList<Integer> defendTerritory(Territory terCible){
	int nGuns=terCible.getnGuns();
	int nSoldiers=terCible.getnSoldiers();
	int nCavalry=terCible.getnCavalry();
	ArrayList<Integer> result = new ArrayList<Integer>();
	int n=0;
	
	while ((n<3)||((nGuns==0)&&(nSoldiers==0)&&(nCavalry==0))){
		if (nSoldiers>0){
			result.add(n,(int)Math.random()*6+1);
			result.add(n+1,1);
			nSoldiers--;
			n++;
		}
		else if (nGuns>0){
			result.add(n,(int)Math.random()*9+4);
			result.add(n+1,2);
			nGuns--;
			n++;
		}
		else{
			result.add(n,(int)Math.random()*7+2);
			result.add(n+1,3);
			nCavalry--;
			n++;
		}
	}
	return result;
	
	
}
	
public static ArrayList<Integer> sortArrayList(ArrayList<Integer> array){
	int max=0,n=0;
	int index=0;
	ArrayList<Integer> result = new ArrayList<Integer>(); 
	
		for (int i=1;i<array.size();i=i+2){
			if (array.get(i)>max){
				max=array.get(i);
				index=i;
			}
		}
		result.add(array.get(index));
		result.add(array.get(index-1));
		array.remove(index);
		array.remove(index-1);
		max=0;
		n++;
	
	return result;
}
	


public static boolean attack(Territory terOrigine,Territory terCible){
	ArrayList<Integer> tabAttaque = new ArrayList<Integer>(); 
	tabAttaque=attackTerritory(terOrigine);
	ArrayList<Integer> tabDefense = new ArrayList<Integer>(); 
	tabDefense=defendTerritory(terCible);
	
	tabAttaque=sortArrayList(tabAttaque);
	tabDefense=sortArrayList(tabDefense);
	
	
	
	// comparaison
	for (int i=1;i<Math.min(tabAttaque.size(),tabDefense.size());i=i+2){
		if (tabAttaque.get(i)>tabDefense.get(i)){
			tuerUnite(terCible,tabDefense.get(i-1));
			tabDefense.remove(i);
			tabDefense.remove(i-1);
		}
		
		else if (tabAttaque.get(i)<tabDefense.get(i)){
			
			tuerUnite(terOrigine,tabAttaque.get(i-1));
			tabAttaque.remove(i);
			tabAttaque.remove(i-1);
		}
		else{// dans le cas d'une egalit� on regarde les priorit�s d'attaque
			if (tabDefense.get(i-1)>tabAttaque.get(i-1)){
				
				tuerUnite(terOrigine,tabAttaque.get(i-1));
				tabAttaque.remove(i);
				tabAttaque.remove(i-1);
			}
			else  if (tabDefense.get(i-1)<tabAttaque.get(i-1)){
				tuerUnite(terCible,tabDefense.get(i-1));
				tabDefense.remove(i);
				tabDefense.remove(i-1);
			}
			else{// priorit� � l'attaque si toutes �galit�s
				
				tuerUnite(terCible,tabDefense.get(i-1));
				tabDefense.remove(i);
				tabDefense.remove(i-1);
			}
			
		}
	}
		// a partir de ce momment il faut compter les zeros pour savoir qui a gagn� et agir en csq (enlever les morts)
		if (terCible.getTerritoryUnits()==0){
			// dans ce cas le territoire est conquis
			// on change le propri�taire 
			terCible.setPlayerWhoControlls(terOrigine.getPlayerWhoControlls());
			// on met les unit�s qu'il reste sur le nouveau ter
			for ( int i=0;i<tabAttaque.size();i++){
				for (int j=0;j<tabAttaque.size();j++){
					ajouterUnite(terCible, tabAttaque.get(j));
					tuerUnite(terOrigine,tabAttaque.get(j));
					tabAttaque.remove(j);
					tabAttaque.remove(j+1);
				}
			}
			return true;
		}
		return false;	
}


	public static void tuerUnite(Territory ter,int num){
		if (num==1){
			ter.setnCavalry(ter.getnCavalry()-1);
			
		}
		else if (num==2){
			ter.setnSoldiers(ter.getnGuns()-1);
		}
		else{
			ter.setnGuns(ter.getnGuns()-1);
		}
		System.out.println("un"+num+" a �t� tu� !"+ "du territoire"+ter.getTerritoryNumber());
	}
	
	
	
	
	public static int[] chooseUnit(Territory terOrigin){
		int nGuns;
		int nCavalry;
		int nSoldiers;
		//On verifie qu'il y ait des canons sur le territoire; s'il n'y en a pas, on ne propose pas de choisir le nombre.
		if (terOrigin.getnGuns()==0) {
			nGuns = 0;
		}
		else { // s'il y en a on fait une fen�tre pop up pour choisir le nombre que l'on veut d�placer
		//On cr�e un tableau contenant les choix que l'on dans le choix du nombre de canon pour pouvoir l'utiliser dans OptionPane
			String[] choiceGun = new String[terOrigin.getnGuns()];
		for (int i=0;i<=terOrigin.getnGuns();i++) {
			choiceGun[i]= String.valueOf(i+1);
		}
		nGuns = Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Combien de Canons voulez-vous d�placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choiceGun, "0"));
		}
		
		//On verifie qu'il y ait des cavaliers sur le territoire; s'il n'y en a pas, on ne propose pas de choisir le nombre.
		if (terOrigin.getnCavalry()==0) {
			nCavalry=0;
		}
		else { // s'il y en a on fait une fen�tre pop up pour choisir le nombre que l'on veut d�placer
			//On cr�e un tableau contenant les choix que l'on dans le choix du nombre de cavalier pour pouvoir l'utiliser dans OptionPane
			String[] choiceCavalry = new String[terOrigin.getnCavalry()];
		for (int i=0;i<=terOrigin.getnCavalry();i++) {
			choiceCavalry[i]= String.valueOf(i+1);
		}
		nCavalry = Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Combien de Cavaliers voulez-vous d�placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choiceCavalry, "0"));
		}
		
		//On verifie qu'il y ait des soldats sur le territoire; s'il n'y en a pas, on ne propose pas de choisir le nombre.
		if (terOrigin.getnSoldiers()==0) {
			nSoldiers=0;
		}
		else { // s'il y en a on fait une fen�tre pop up pour choisir le nombre que l'on veut d�placer
			//On cr�e un tableau contenant les choix que l'on dans le choix du nombre de soldat pour pouvoir l'utiliser dans OptionPane
			String[] choiceSoldier = new String[terOrigin.getnSoldiers()];
		for (int i=0;i<terOrigin.getnSoldiers();i++) {
			choiceSoldier[i]= String.valueOf(i+1);
		}
		nSoldiers = Integer.parseInt((String)JOptionPane.showInputDialog(JOptionPane.getRootFrame(), "Combien de Soldats voulez-vous d�placer?", "Initialisation", JOptionPane.PLAIN_MESSAGE, null, choiceSoldier, "0"));
		}
		
		int Table[]= {nSoldiers,nCavalry,nGuns};
		return Table;
	}
	
	
	
	
	// Getters & Setters
	public static void ajouterUnite(Territory ter,int num){
		if (num==1){
			ter.setnCavalry(ter.getnCavalry()+1);
			
		}
		else if (num==2){
			ter.setnSoldiers(ter.getnGuns()+1);
		}
		else{
			ter.setnGuns(ter.getnGuns()+1);
		}
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

	public double getxMin() {
		return xMin;
	}

	public void setxMin(double xMin) {
		this.xMin = xMin;
	}

	public double getxMax() {
		return xMax;
	}

	public void setxMax(double xMax) {
		this.xMax = xMax;
	}

	public double getyMin() {
		return yMin;
	}

	public void setyMin(double yMin) {
		this.yMin = yMin;
	}

	public double getyMax() {
		return yMax;
	}

	public void setyMax(double yMax) {
		this.yMax = yMax;
	}
	public int getTerritoryUnits(){
		return this.getnGuns()+this.getnCavalry()+this.getnSoldiers();
	}
	
	


	
	
	
	

}
