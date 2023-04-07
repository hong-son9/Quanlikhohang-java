package PGBT1;
import java.util.*;

public class Bai7 {
	public static int binary_Search(int arr[], int l ,int r, int x) {
		if (r<l) return -1;
		else {
			int mid = (l+r)/2;
			if (arr[mid] == x) return mid;
			else if (arr[mid] < x) return binary_Search(arr,mid+1,r,x);
			else  return binary_Search(arr,l,mid-1,x);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] arr = {0,1,2,3,4,5,6,7,8,9,10};
		System.out.print("arr: ");
		for(int item:arr) {
			System.out.print(item+ " ");
		}
		System.out.println();
		int x;
		System.out.print("Nhap so can tim x: "); x= sc.nextInt();
		System.out.print(x+ " o vi tri thu " + (binary_Search(arr,0,arr.length-1,x)+1) );
		sc.close();
	}

}
