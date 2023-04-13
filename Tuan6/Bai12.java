package PGBT1;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.System.out;

public class Bai12 {
	public static void showMaTran(int a[][]) {
		for(int list[]:a) {
			out.print("\t");
			for(int item:list) {
				out.printf("%4s",item + " ");
			}
			out.println();
		}
	}
	public static int[][] nhanMaTran(int a[][], int b[][]) {
		int m = a.length;
		int p = b[0].length;
		int n = a[0].length; //(=b.length)
		int[][] result = new int[m][p];
		for(int i=0; i<m ; i++) {
			for(int j=0 ; j<p; j++) {
				int sum = 0;
				for(int e=0; e<n ; e++)
					sum += ( a[i][e] + b[e][j] );
				result[i][j] = sum;
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		out.println("Nhan 2 mang 2 chieu");
		int a[][] = new int[5][3];
		int b[][] = new int[3][4];
		
		out.println("Mang A:");
		for(int i=0;i<a.length;i++) {
			out.print("\t");
			for(int j=0;j<a[i].length;j++) {
				a[i][j] = ThreadLocalRandom.current().nextInt(1,15);
				out.printf("%4s",a[i][j] + " ");
			}
			out.println();
		}
		out.println("Mang B:");
		for(int i=0;i<b.length;i++) {
			out.print("\t");
			for(int j=0;j<b[i].length;j++) {
				b[i][j] = ThreadLocalRandom.current().nextInt(1,15);
				out.printf("%4s",b[i][j] + " ");
			}
			out.println();
		}
		//Lưu ý : foreach chỉ cho duyệt mảng chứ ko cho lưu
		//nên khi khởi tạo thì nên dùng for còn show thì foreach cho ngắn cũng được
		
		if(a[0].length == b.length) {
			out.println("A*B:");
			showMaTran(nhanMaTran(a,b));
		}
		else if(a.length == b[0].length) {
			out.println("A*B:");
			showMaTran(nhanMaTran(b,a));
		}
		else out.println("Ko the thuc hien phep nhan 2 ma tran");		
	}
}
