public class q6{
	public static void main(String args[]){
	int fee = 125000;
	int discountPercent = 10;
	int x = (fee * discountPercent)/100;
	int newFee = fee - x;
	System.out.println(" The discount amount is INR " + x + " and final discounted fee is INR " + newFee); 
	}
}