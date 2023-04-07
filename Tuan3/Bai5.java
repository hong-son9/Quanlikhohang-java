package PGBT1;
import java.util.*;

public class Bai5 {
	//thuật toán ơ clit tìm ước chung lớn nhất
	public static int GCD(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		while(b>0) {
			int mod = a%b;
			a = b; 
			b = mod;
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a ,b;
		do {
			System.out.println("Bai toan tim uoc chung lon nhat");
			System.out.print("Nhap a: "); a = sc.nextInt();
			System.out.print("Nhap b: "); b = sc.nextInt();
			if(a<0||b<0) System.out.println("Vui long nhap so nguyen duong");
		}while (a<0||b<0);
		System.out.println("GCD(a,b) = " + GCD(a,b));
		sc.close();
	}

}
