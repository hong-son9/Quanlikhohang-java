package PGBT1;
import java.util.*;
import static java.lang.System.out;

public class Bai8 {
	public static void add_Into_Arr(int arr[], int index, int add_Num) {
		for(int i = arr.length; i>index; i++) {
			arr[i] = arr[i-1];
		}
		arr[index] = add_Num;
	}
	public static int []add_Item(int arr[], int add_Num) {
		int[] temp = new int[arr.length];
		int i_arr = 0;
		boolean check = false;
		for(int i=0; i<temp.length; i++) {
			if(check==false && arr[i_arr] >= add_Num) {
				temp[i] = add_Num;
				check = true;
			}
			else{
				temp[i]= arr[i_arr];
				i_arr++;
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int []arr = new int[n+1];
		arr[0]= 10;
		arr[1]= 20;
		arr[2]= 30;
		arr[3]= 40;
		arr[4]= 50;
		out.print("arr: ");
		for(int i = 0 ;i<arr.length-1;i++) out.print(arr[i] + " ");
		out.println();
		
		out.print("Nhap so can them: ");int add_Num = sc.nextInt();
		arr = add_Item(arr,add_Num);
		out.print("Sau khi them: ");
		for(int item:arr) out.print(item+ " ");
		sc.close();
		
	}

}
