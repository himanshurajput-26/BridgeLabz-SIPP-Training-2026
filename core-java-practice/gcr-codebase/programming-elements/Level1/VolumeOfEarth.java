public class q7{
	public static void main(String args[]){
	int r = 6378;
	double pi = 3.14;
	double volume = ((4/3)*(pi)*(r^3));
	System.out.println("The volume of earth in cubic kilometeres is " + volume + " and cubic miles is " + (volume*r));	
	}
}