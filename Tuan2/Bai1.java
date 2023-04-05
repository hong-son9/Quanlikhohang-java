package PGBT1;
import java.util.*;

public class Bai1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n = scan.nextInt();
		boolean check= true;
		for(int i=1 ; i<n/2; i++) {
			if( n % i == 0 ) {
				check = false;
				break;
			}
		}
		System.out.println((check==true)? "n la so nguyen to":"n ko phai la so nguyen to");
		scan.close();
	}

}
