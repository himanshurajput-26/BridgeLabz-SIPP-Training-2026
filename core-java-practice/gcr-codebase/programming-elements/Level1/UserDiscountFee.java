import java.util.*;
public class discounting{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int fee = sc.nextInt();
		int discountPercent = sc.nextInt();
		int discount = (fee*discountPercent)/100;
		int newFee = fee - discount;
		System.out.println("The discount amount is INR " + discount + "and final discounted fee is INR " + (newFee));
	}
	
}