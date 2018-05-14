
public class Region {

	private int number;
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
}