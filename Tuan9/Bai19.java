package PGBT1;
import java.util.*;
import static java.lang.System.out;

public class Bai10 {
	/*public static void quick_Sort(int a[], int l , int r) {
		if(l<r) {
			int mid = (l+r)/2;
			int i=l,j=r;
			do {
				while(a[i]<a[mid]) i+=1;
				while(a[j]>a[mid]) j-=1;
				if(i<=j) {
					int tg=a[i];
					a[i] = a[j];
					a[j] = tg;
					i+=1;j-=1;
				}
			}while(i<=j);
			quick_Sort(a,l,j);
			quick_Sort(a,i,r);
		}
	}*/
	public static boolean check_SoNt(int x) {
		if(x==1) return false;
		for(int i=2;i<=x/2;i++) {
			if(x%i==0) return false;
		}
		return true;
	}
	public static void push_Up(int a[],int index){
		for(int i = index; i>0 ;i--) {
			a[i] = a[i-1];
		}
	}
	public static void bai_10(int a[]) {
		//quick_Sort(a,0,a.length-1);
		int []temp= new int[a.length];
		int count_SoNt = 0; // 0 1 2 3 4 5 c : index 5->6số nguyên tố==count
		for(int i=a.length-1;i>=0;i--){
			if(!check_SoNt(a[i])) continue;
			else {
				while(check_SoNt(a[i])==true) {
					temp[count_SoNt] = a[i];
					count_SoNt++;
					push_Up(a,i);
				}
			}
		}
		// vì a cho tăng dần sẵn nên temp nó sẽ ở giảm dần
		int j = count_SoNt-1;
		for(int i=0;i<count_SoNt;i++) {
			a[i]=temp[j];
			j--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		out.println("Tim so nguyen to trong mang va sap xep chung len dau");
		int []a = new int[9];
		out.print("Array:  ");
		for(int i=0;i<9;i++) {//cho a tăng dần sẵn cho đỡ phiền
			a[i] = i+1;
			out.print(a[i]+ " ");
		}
		out.println();
		bai_10(a);
		out.print("Result: ");
		for(int i=0;i<9;i++) out.print(a[i]+" ");
		out.println();
		sc.close();
	}

}
