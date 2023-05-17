package PGBT1;
import java.util.*;

public class Bai3 {
	public static int Luythua(int n) {
		if(n==1) return 1;
		return n*Luythua(n-1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n: "); int n = sc.nextInt();
		System.out.println("n! = "+ Luythua(n));
		sc.close();
	}

}
