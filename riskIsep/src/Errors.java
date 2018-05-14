
public class Errors {
	int errorNumber;
	String text;
	
	public Errors(int num, String txt){
		this.errorNumber=num;
		this.text=txt;
	}
	
	public void displayError(){
		System.out.println("Error"+this.getErrorNumber());
		System.out.println(this.getText());
	}
	
	
	
	// Creation des erreurs
	//-------------------------- 1 : Territories ------------------------------
		Errors Error101 =new Errors(101,"les 2 Territoires sont contrôlés par le même Joueur");
		Errors Error102=new Errors(102,"Les territoires ne sont pas voisins");
	

	public int getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
	
}
