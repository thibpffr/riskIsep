import edu.princeton.cs.introcs.StdDraw;

public class Interface {
	public Interface(int xMax,int yMax){
		StdDraw.setXscale(0,xMax);
		StdDraw.setYscale(0,yMax);
}
	public static void ecranUnit() {
	StdDraw.picture(0.5, 0.5, "image/riskUnit.jpg");
}
	
	public void ecranCarte()
	{
		StdDraw.clear();
		StdDraw.setCanvasSize(1193,675);
		StdDraw.picture(0.5,0.5,"image/CarteRiskContinents.jpg");
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
	public static void territoryChoice() {
		while(!clique()) {
		double sourisX = StdDraw.mouseX();
		double sourisY = StdDraw.mouseY();
		cliqueTerritoires(sourisX,sourisY);
		}
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
		if((sourisX > 0.22 && sourisX < 0.40) && (sourisY > 0.35 && sourisY < 0.65))//Cavalier
		{
			return 0;
		}
		else if((sourisX > 0.44 && sourisX < 0.62) && (sourisY > 0.35 && sourisY < 0.65))//Canon
		{
			return 1;
		}
		else if((sourisX > 0.67 && sourisX < 0.75) && (sourisY > 0.35 && sourisY < 0.65))//Soldat
		{
			return 2;
		}
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
	
	 public static void cliqueTerritoires(double sourisX, double sourisY)
	{
			if((sourisX > 0.34 && sourisX < 0.38) && (sourisY > 0.77 && sourisY < 0.82))//Island
			{
				System.out.println("ceci est le territoire 14");
			}
			else if((sourisX > 0.4 && sourisX < 0.47) && (sourisY > 0.74 && sourisY < 0.87))//Scandinavie
			{
				System.out.println("ceci est le territoire 15");
			}
			else if((sourisX > 0.3 && sourisX < 0.37) && (sourisY > 0.63 && sourisY < 0.76))//Grande-Bretagne
			{
				System.out.println("ceci est le territoire 16");
			}
			else if((sourisX > 0.32 && sourisX < 0.39) && (sourisY > 0.47 && sourisY < 0.62))//Europe de l'Ouest
			{
				System.out.println("ceci est le territoire 19");
			}
			else if((sourisX > 0.39 && sourisX < 0.47) && (sourisY > 0.49 && sourisY < 0.67))//Europe du Sud
			{
				System.out.println("ceci est le territoire 20");
			}
			else if((sourisX > 0.38 && sourisX < 0.46) && (sourisY > 0.67 && sourisY < 0.76))//Europe du Nord
			{
				System.out.println("ceci est le territoire 18");
			}
			else if((sourisX > 0.46 && sourisX < 0.51) && (sourisY > 0.64 && sourisY < 0.79))
			{
				System.out.println("ceci est le territoire 17");
			}
			else if((sourisX > 0.42 && sourisX < 0.49) && (sourisY > 0.36 && sourisY < 0.45))//Egypte
			{
				System.out.println("ceci est le territoire 41");
			}
			else if((sourisX > 0.33 && sourisX < 0.44) && (sourisY > 0.27 && sourisY < 0.48))//Afrique du Nord
			{
				System.out.println("ceci est le territoire 42");
			}
			else if((sourisX > 0.46 && sourisX < 0.55) && (sourisY > 0.16 && sourisY < 0.37))//Afrique de l'Est
			{
				System.out.println("ceci est le territoire 40");
			}
			else if((sourisX > 0.41 && sourisX < 0.49) && (sourisY > 0.17 && sourisY < 0.3))//Congo
			{
				System.out.println("ceci est le territoire 39");
			}
			else if((sourisX > 0.43 && sourisX < 0.49) && (sourisY > 0.05 && sourisY < 0.17))//Afrique du Sud
			{
				System.out.println("ceci est le territoire 38");
			}
			else if((sourisX > 0.52 && sourisX < 0.56) && (sourisY > 0.03 && sourisY < 0.16))//Madagascar
			{
				System.out.println("ceci est le territoire 37");
			}
			else if((sourisX > 0.48 && sourisX < 0.56) && (sourisY > 0.35 && sourisY < 0.55))//Moyen Orient
			{
				System.out.println("ceci est le territoire 21");
			}
			else if((sourisX > 0.58 && sourisX < 0.66) && (sourisY > 0.32 && sourisY < 0.51))//Inde
			{
				System.out.println("ceci est le territoire 30");
			}
			else if((sourisX > 0.54 && sourisX < 0.6) && (sourisY > 0.57 && sourisY < 0.7))//Afganistan
			{
				System.out.println("ceci est le territoire 22");
			}
			else if((sourisX > 0.56 && sourisX < 0.6) && (sourisY > 0.7 && sourisY < 0.85))//Oural
			{
				System.out.println("ceci est le territoire 23");
			}
			else if((sourisX > 0.59 && sourisX < 0.66) && (sourisY > 0.75 && sourisY < 0.94))//Siberie
			{
				System.out.println("ceci est le territoire 24");
			}
			else if((sourisX > 0.67 && sourisX < 0.7) && (sourisY > 0.71 && sourisY < 0.8))
			{
				System.out.println("ceci est le territoire 27");
			}
			else if((sourisX > 0.62 && sourisX < 0.73) && (sourisY > 0.50 && sourisY < 0.61))//Chine
			{
				System.out.println("ceci est le territoire 29");
			}
			else if((sourisX > 0.67 && sourisX < 0.71) && (sourisY > 0.85 && sourisY < 0.892))
			{
				System.out.println("ceci est le territoire 25");
			}
			else if((sourisX > 0.73 && sourisX < 0.8) && (sourisY > 0.84 && sourisY < 0.92))
			{
				System.out.println("ceci est le territoire 26");
			}
			else if((sourisX > 0.77 && sourisX < 0.79) && (sourisY > 0.60 && sourisY < 0.71))//Japon
			{
				System.out.println("ceci est le territoire 32");
			}
			else if((sourisX > 0.65 && sourisX < 0.73) && (sourisY > 0.62 && sourisY < 0.7))
			{
				System.out.println("ceci est le territoire 28");
			}
			else if((sourisX > 0.67 && sourisX < 0.7) && (sourisY > 0.39 && sourisY < 0.47))//Irkutsk
			{
				System.out.println("ceci est le territoire 31");
			}
			else if((sourisX > 0.025 && sourisX < 0.072) && (sourisY > 0.8 && sourisY < 0.89))//Alaska
			{
				System.out.println("ceci est le territoire 12");
			}
			else if((sourisX > 0.073 && sourisX < 0.2) && (sourisY > 0.82 && sourisY < 0.88))//Territoires du Nord
			{
				System.out.println("ceci est le territoire 11");
			}
			else if((sourisX > 0.09 && sourisX < 0.15) && (sourisY > 0.72 && sourisY < 0.81))//Alberta
			{
				System.out.println("ceci est le territoire 10");
			}
			else if((sourisX > 0.15 && sourisX < 0.20) && (sourisY > 0.71 && sourisY < 0.8))//Ontario
			{
				System.out.println("ceci est le territoire 9");
			}
			else if((sourisX > 0.25 && sourisX < 0.32) && (sourisY > 0.84 && sourisY < 0.98))//Groenland
			{
				System.out.println("ceci est le territoire 13");
			}
			else if((sourisX > 0.2 && sourisX < 0.26) && (sourisY > 0.70 && sourisY < 0.8))//Quebec
			{
				System.out.println("ceci est le territoire 8");
			}
			else if((sourisX > 0.08 && sourisX < 0.14) && (sourisY > 0.60 && sourisY < 0.70))//Etats de l'Ouest
			{
				System.out.println("ceci est le territoire 6");
			}
			else if((sourisX > 0.17 && sourisX < 0.22) && (sourisY > 0.56 && sourisY < 0.67))//Etats de l'Est
			{
				System.out.println("ceci est le territoire 7");
			}
			else if((sourisX > 0.12 && sourisX < 0.15) && (sourisY > 0.45 && sourisY < 0.54))//Amerique Centrale
			{
				System.out.println("ceci est le territoire 5");
			}
			else if((sourisX > 0.16 && sourisX < 0.23) && (sourisY > 0.39 && sourisY < 0.45))//Venezuela
			{
				System.out.println("ceci est le territoire 3");
			}
			else if((sourisX > 0.23 && sourisX < 0.29) && (sourisY > 0.24 && sourisY < 0.39))//Bresil
			{
				System.out.println("ceci est le territoire 1");
			}
			else if((sourisX > 0.16 && sourisX < 0.18) && (sourisY > 0.28 && sourisY < 0.36))//Perou
			{
				System.out.println("ceci est le territoire 4");
			}
			else if((sourisX > 0.18 && sourisX < 0.24) && (sourisY > 0.09 && sourisY < 0.25))//Argentine
			{
				System.out.println("ceci est le territoire 2");
			}
			else if((sourisX > 0.66 && sourisX < 0.72) && (sourisY > 0.2 && sourisY < 0.29))//Indonesie
			{
				System.out.println("ceci est le territoire 33");
			}
			else if((sourisX > 0.75 && sourisX < 0.79) && (sourisY > 0.26 && sourisY < 0.33))//Nouvelle Guinnee
			{
				System.out.println("ceci est le territoire 34");
			}
			else if((sourisX > 0.70 && sourisX < 0.75) && (sourisY > 0.05 && sourisY < 0.17))//Australie de l'Ouest
			{
				System.out.println("ceci est le territoire 36");
			}
			else if((sourisX > 0.79 && sourisX < 0.83) && (sourisY > 0.03 && sourisY < 0.2))//Australie de l'Est
			{
				System.out.println("ceci est le territoire 35");
			}
			/*else if((sourisX > 0.89 && sourisX < 0.94) && (sourisY > 0.03 && sourisY < 0.15))//Annuler
			{
				reset(1);//Choix

				couche = 4;//Choix

				return false;
			}*/
			else
			{
				System.out.println("ceci n'est pas un territoire");
			}
		}
}
