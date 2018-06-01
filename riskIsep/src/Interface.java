import edu.princeton.cs.introcs.StdDraw;

public class Interface {
	public Interface(int xMax,int yMax){
		StdDraw.setXscale(0,xMax);
		StdDraw.setYscale(0,yMax);
}
	public static void ecranUnit() {
	StdDraw.picture(0.5, 0.5, "image/riskUnit.jpg");
}
	
	public void ecranCarte(Territory[] territoryList)
	{
		StdDraw.clear();
		StdDraw.setCanvasSize(1193,675);	
		StdDraw.picture(0.5,0.5,"image/CarteRiskContinents.jpg");
		for (int i=0;i<territoryList.length;i++){
			if ((territoryList[i].getPlayerWhoControlls()).getPlayerNumber()==0){
				StdDraw.setPenColor(StdDraw.RED);
			}
			else if ((territoryList[i].getPlayerWhoControlls()).getPlayerNumber()==1){
				StdDraw.setPenColor(StdDraw.BLUE);
			}
			else if ((territoryList[i].getPlayerWhoControlls()).getPlayerNumber()==2){
				StdDraw.setPenColor(StdDraw.GREEN);
			}
			else if ((territoryList[i].getPlayerWhoControlls()).getPlayerNumber()==3){
				StdDraw.setPenColor(StdDraw.YELLOW);
			}
			else if ((territoryList[i].getPlayerWhoControlls()).getPlayerNumber()==4){
				StdDraw.setPenColor(StdDraw.BLACK);
			}
			else {
				StdDraw.setPenColor(StdDraw.WHITE);
			}
			StdDraw.filledCircle((territoryList[i].getxMin()+territoryList[i].getxMax())*0.5,(territoryList[i].getyMin()+territoryList[i].getyMax())*0.5,0.03);
			
		}
	}
	
	
	public void ecranNbJoueurs(){
	StdDraw.clear();
	StdDraw.setCanvasSize(500,500);
	//lignes horizontale
	StdDraw.line(0,0.33,1,0.33);
	StdDraw.line(0,0.66,1,0.66);
	// ligne verticale
	StdDraw.line(0.5,0,0.5,1);

	// texte 
	StdDraw.text(0.25, 0.9,"Choisissez le nombre de joueurs");
	// nb joueurs
	StdDraw.text(0.75, 0.8,"2");
	StdDraw.text(0.25, 0.5,"3");
	StdDraw.text(0.75, 0.5,"4");
	StdDraw.text(0.25, 0.2,"5");
	StdDraw.text(0.75, 0.2,"6");

	}
	
	public static int posThib(){
		double sourisX, sourisY;
		while(true){
		if(StdDraw.mousePressed()){
			//System.out.println("x= "+StdDraw.mouseX() + " y= "+StdDraw.mouseY());
			sourisX = StdDraw.mouseX();
			sourisY = StdDraw.mouseY();
			//System.out.println("x="+sourisX+" y="+sourisY);
			if (sourisX<0.5){
				if (sourisY<0.33)
					return 5;
				else if (sourisY<0.66)
					return 3;
				
			}
			else{
				if (sourisY<0.33)
					return 6;
				else if (sourisY<0.66)
					return 4;
				else
					return 2;
				
			}
			
		}

		}
		}
	
	
	public static void positionSouris() {
	while(!clique()) {
		System.out.println("x= "+StdDraw.mouseX() + " y= "+StdDraw.mouseY());
		}
	}
	public static void unitChoice() {
		ecranUnit();
		while(!clique()) {
		double sourisX = StdDraw.mouseX();
		double sourisY = StdDraw.mouseY();
		cliqueUnit(sourisX,sourisY);
		}
	}
	public static int territoryChoice() {
		while(!clique()) {
		double sourisX = StdDraw.mouseX();
		double sourisY = StdDraw.mouseY();
		int territoryChoice = cliqueTerritoires(sourisX,sourisY);
		return territoryChoice;
		}
		return -1;
	}
	
	public static int actionChoice() {
		while(!clique()) {
			double sourisX = StdDraw.mouseX();
			double sourisY = StdDraw.mouseY();
			int action = cliqueActions(sourisX,sourisY);
			return action;
		}
		return -1;
	}
	
	public static boolean numberOfClique(int number) {
		int i=0;
		while(i<number) {
			if(clique()==true) {
				i++;
			}
		}
		return false;
	}
	
	public static boolean clique()
	{
		return StdDraw.isMousePressed();
	}
	public static int cliqueActions(double sourisX, double sourisY) {
		if((sourisX > 0 && sourisX < 1) && (sourisY > 0 && sourisY < 1))//Cavalier
		{
			return 0;
		}
		/*else if((sourisX > 0.44 && sourisX < 0.62) && (sourisY > 0.35 && sourisY < 0.65))//Canon
		{
			return 1;
		}
		else if((sourisX > 0.67 && sourisX < 0.75) && (sourisY > 0.35 && sourisY < 0.65))//Soldat
		{
			return 2;
		}*/
		else {
			return -1;
		}
	}
	public static void cliqueUnit(double sourisX, double sourisY) {
		if((sourisX > 0.22 && sourisX < 0.40) && (sourisY > 0.35 && sourisY < 0.65))//Cavalier
		{
			System.out.println("ceci est un cavalier");
		}
		else if((sourisX > 0.44 && sourisX < 0.62) && (sourisY > 0.35 && sourisY < 0.65))//Canon
		{
			System.out.println("ceci est un canon");
		}
		else if((sourisX > 0.67 && sourisX < 0.75) && (sourisY > 0.35 && sourisY < 0.65))//Soldat
		{
			System.out.println("ceci est un soldat");
		}
		else {
			System.out.println("ceci n'est pas une troupe");
		}
		}
	
	 public static int cliqueTerritoires(double sourisX, double sourisY)
	{
			if((sourisX > 0.34 && sourisX < 0.38) && (sourisY > 0.77 && sourisY < 0.82))//Island
			{
				return 14;
			}
			else if((sourisX > 0.4 && sourisX < 0.47) && (sourisY > 0.74 && sourisY < 0.87))//Scandinavie
			{
				return 15;
			}
			else if((sourisX > 0.3 && sourisX < 0.37) && (sourisY > 0.63 && sourisY < 0.76))//Grande-Bretagne
			{
				return 16;
			}
			else if((sourisX > 0.32 && sourisX < 0.39) && (sourisY > 0.47 && sourisY < 0.62))//Europe de l'Ouest
			{
				return 19;
			}
			else if((sourisX > 0.39 && sourisX < 0.47) && (sourisY > 0.49 && sourisY < 0.67))//Europe du Sud
			{
				return 20;
			}
			else if((sourisX > 0.38 && sourisX < 0.46) && (sourisY > 0.67 && sourisY < 0.76))//Europe du Nord
			{
				return 18;
			}
			else if((sourisX > 0.46 && sourisX < 0.51) && (sourisY > 0.64 && sourisY < 0.79))
			{
				return 17;
			}
			else if((sourisX > 0.42 && sourisX < 0.49) && (sourisY > 0.36 && sourisY < 0.45))//Egypte
			{
				return 41;
			}
			else if((sourisX > 0.33 && sourisX < 0.44) && (sourisY > 0.27 && sourisY < 0.48))//Afrique du Nord
			{
				return 42;
			}
			else if((sourisX > 0.46 && sourisX < 0.55) && (sourisY > 0.16 && sourisY < 0.37))//Afrique de l'Est
			{
				return 40;
			}
			else if((sourisX > 0.41 && sourisX < 0.49) && (sourisY > 0.17 && sourisY < 0.3))//Congo
			{
				return 39;
			}
			else if((sourisX > 0.43 && sourisX < 0.49) && (sourisY > 0.05 && sourisY < 0.17))//Afrique du Sud
			{
				return 38;
			}
			else if((sourisX > 0.52 && sourisX < 0.56) && (sourisY > 0.03 && sourisY < 0.16))//Madagascar
			{
				return 36;
			}
			else if((sourisX > 0.48 && sourisX < 0.56) && (sourisY > 0.35 && sourisY < 0.55))//Moyen Orient
			{
				return 21;
			}
			else if((sourisX > 0.58 && sourisX < 0.66) && (sourisY > 0.32 && sourisY < 0.51))//Inde
			{
				return 30;
			}
			else if((sourisX > 0.54 && sourisX < 0.6) && (sourisY > 0.57 && sourisY < 0.7))//Afganistan
			{
				return 22;
			}
			else if((sourisX > 0.56 && sourisX < 0.6) && (sourisY > 0.7 && sourisY < 0.85))//Oural
			{
				return 23;
			}
			else if((sourisX > 0.59 && sourisX < 0.66) && (sourisY > 0.75 && sourisY < 0.94))//Siberie
			{
				return 24;
			}
			else if((sourisX > 0.67 && sourisX < 0.7) && (sourisY > 0.71 && sourisY < 0.8))
			{
				return 27;
			}
			else if((sourisX > 0.62 && sourisX < 0.73) && (sourisY > 0.50 && sourisY < 0.61))//Chine
			{
				return 29;
			}
			else if((sourisX > 0.67 && sourisX < 0.71) && (sourisY > 0.85 && sourisY < 0.892))
			{
				return 25;
			}
			else if((sourisX > 0.73 && sourisX < 0.8) && (sourisY > 0.84 && sourisY < 0.92))
			{
				return 26;
			}
			else if((sourisX > 0.77 && sourisX < 0.79) && (sourisY > 0.60 && sourisY < 0.71))//Japon
			{
				return 32;
			}
			else if((sourisX > 0.65 && sourisX < 0.73) && (sourisY > 0.62 && sourisY < 0.7))
			{
				return 28;
			}
			else if((sourisX > 0.67 && sourisX < 0.7) && (sourisY > 0.39 && sourisY < 0.47))//Irkutsk
			{
				return 31;
			}
			else if((sourisX > 0.025 && sourisX < 0.072) && (sourisY > 0.8 && sourisY < 0.89))//Alaska
			{
				return 12;
			}
			else if((sourisX > 0.073 && sourisX < 0.2) && (sourisY > 0.82 && sourisY < 0.88))//Territoires du Nord
			{
				return 11;
			}
			else if((sourisX > 0.09 && sourisX < 0.15) && (sourisY > 0.72 && sourisY < 0.81))//Alberta
			{
				return 10;
			}
			else if((sourisX > 0.15 && sourisX < 0.20) && (sourisY > 0.71 && sourisY < 0.8))//Ontario
			{
				return 9;
			}
			else if((sourisX > 0.25 && sourisX < 0.32) && (sourisY > 0.84 && sourisY < 0.98))//Groenland
			{
				return 13;
			}
			else if((sourisX > 0.2 && sourisX < 0.26) && (sourisY > 0.70 && sourisY < 0.8))//Quebec
			{
				return 8;
			}
			else if((sourisX > 0.08 && sourisX < 0.14) && (sourisY > 0.60 && sourisY < 0.70))//Etats de l'Ouest
			{
				return 6;
			}
			else if((sourisX > 0.17 && sourisX < 0.22) && (sourisY > 0.56 && sourisY < 0.67))//Etats de l'Est
			{
				return 7;
			}
			else if((sourisX > 0.12 && sourisX < 0.15) && (sourisY > 0.45 && sourisY < 0.54))//Amerique Centrale
			{
				return 5;
			}
			else if((sourisX > 0.16 && sourisX < 0.23) && (sourisY > 0.39 && sourisY < 0.45))//Venezuela
			{
				return 3;
			}
			else if((sourisX > 0.23 && sourisX < 0.29) && (sourisY > 0.24 && sourisY < 0.39))//Bresil
			{
				return 1;
			}
			else if((sourisX > 0.16 && sourisX < 0.18) && (sourisY > 0.28 && sourisY < 0.36))//Perou
			{
				return 4;
			}
			else if((sourisX > 0.18 && sourisX < 0.24) && (sourisY > 0.09 && sourisY < 0.25))//Argentine
			{
				return 2;
			}
			else if((sourisX > 0.66 && sourisX < 0.72) && (sourisY > 0.2 && sourisY < 0.29))//Indonesie
			{
				return 33;
			}
			else if((sourisX > 0.75 && sourisX < 0.79) && (sourisY > 0.26 && sourisY < 0.33))//Nouvelle Guinnee
			{
				return 34;
			}
			else if((sourisX > 0.70 && sourisX < 0.75) && (sourisY > 0.05 && sourisY < 0.17))//Australie de l'Ouest
			{
				return 36;
			}
			else if((sourisX > 0.79 && sourisX < 0.83) && (sourisY > 0.03 && sourisY < 0.2))//Australie de l'Est
			{
				return 35;
			}
			/*else if((sourisX > 0.89 && sourisX < 0.94) && (sourisY > 0.03 && sourisY < 0.15))//Annuler
			{
				reset(1);//Choix

				couche = 4;//Choix

				return false;
			}*/
			else
			{
				return -1;
			}
		}
}
