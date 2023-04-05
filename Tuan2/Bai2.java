package PGBT1;
import java.util.Scanner;

class Sophuc{
	private double a;
	private double b;
	
	public Sophuc(){
		
	}
	public Sophuc(double a, double b) {
		this.a = a;
		this.b = b;
	}
	public void show(){
		if (b < 0) System.out.println(a + " - " + Math.abs(b) + "*i");
        else System.out.println(a + " + " + b + "*i");
	}
}

public class Bai2 {
	public static void Giai_pt_bac2(double a, double b,double c) {
		if(a == 0) {
			if(b==0)System.out.println("Phuong trinh vo nghiem");
			else System.out.println("Phuong trinh co 1 nghiem: x = "+ (-c/b));
		}
		else {
			double delta = b/b-4*a*c;
			double x1 , x2;
			if(delta > 0) {
				x1 = (double)((-b + Math.sqrt(delta)) / (2*a));
				x2 = (double)((-b - Math.sqrt(delta)) / (2*a));
				System.out.println("Phuong trinh co 2 nghiem: x1 = "+x1+" x2 = "+x2);
			}
			else if(delta == 0) {
				x1 = (-b / (2 * a));
	            System.out.println("Phương trình có nghiệm kép: x1 = x2 = " + x1);
			}
			else {
				double thuc1 = -b/2*a;
				double ao1 = Math.sqrt(Math.abs(delta));
				double thuc2 = -b/2*a;
				double ao2 = -Math.sqrt(Math.abs(delta));
				Sophuc x_1 = new Sophuc(thuc1,ao1);
				Sophuc x_2 = new Sophuc(thuc2,ao2);
				System.out.println("Phuong trinh co 2 nghiem phuc: ");
				System.out.print("x1 = ");x_1.show();
				System.out.print("x2 = ");x_2.show();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap du lieu cho pt bac 2: ");
		System.out.print("a = "); double a = sc.nextDouble();
		System.out.print("b = "); double b = sc.nextDouble();
		System.out.print("c = "); double c = sc.nextDouble();
		Giai_pt_bac2(a,b,c);
		sc.close();
	}

}
