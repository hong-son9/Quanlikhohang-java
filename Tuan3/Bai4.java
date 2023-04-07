package PGBT1;
import java.util.*;

public class Bai4 {
	public static int Luythua(int n) {
		if(n==1) return 1;
		return n*Luythua(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,k;
		do {
			System.out.println("Tinh to hop chap k cua n: ");
			System.out.print("Nhap n: "); n = sc.nextInt();
			System.out.print("Nhap k: "); k = sc.nextInt();
			if (k>n) System.out.println("Vui long nhap lai voi k < n");
		}while(k>n);
		System.out.print("C(k,n) = " + (Luythua(n)/(Luythua(k)*Luythua(n-k))));
		sc.close();
	}

}
