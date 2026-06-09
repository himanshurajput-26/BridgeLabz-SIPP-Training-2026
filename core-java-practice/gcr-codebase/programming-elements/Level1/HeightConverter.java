import java.util.*;
public class q9{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		double inch = (height/2.54);
		double feet = 12*inch;
		System.out.println("Your Height in cm is " + height + " while in feet is " + feet + "and inches is " + inch);
	}
	
}