package PGBT1;
import java.util.*;
import static java.lang.System.out;

public class Bai11 {
	public static boolean check_SoNt(int x) {
		if(x==1) return false;
		for(int i=2;i<=x/2;i++) {
			if (x % i ==0) return false; 
		}
		return true;
	}
	
	public static int max_SoNt(int arr[][]) {
		int max = 0;
		for(int list_item[]:arr) {
			for(int item:list_item) {
				if(check_SoNt(item)) {
					if(max < item) max = item;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[5][5];
		out.println("Mang arr:");
		for(int i=0;i<5;i++) {
			out.print("\t");
			for(int j=0;j<5;j++) {
				arr[i][j]=(int)(Math.random()*100+1);
				// Returns a random int between 1 (inclusive) & 101 (exclusive)
				//int randomInt = ThreadLocalRandom.current().nextInt(1, 101)
				out.printf("%3s",arr[i][j]+" ");
			}
			out.println();
		}
		//out.print(arr.length+" "+arr[0].length);
		//cách xem độ dài của mảng 2 chiều
		out.println("So nguyen to lon nhat trong mang: "+max_SoNt(arr));
		sc.close();
	}
}
