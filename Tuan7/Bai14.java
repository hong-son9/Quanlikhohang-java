package PGBT1;
import java.util.*;
import static java.lang.System.out;

class DemKiTu{
	public char kitu;
	public int dem;
	public DemKiTu(char kitu, int dem) {
		this.kitu = kitu;
		this.dem = dem;
	}
	public DemKiTu() {
		
	}
	public void show() {
		out.println(kitu+"-"+dem);
	}
}

public class Bai14 {
	static List<DemKiTu> result = new ArrayList<DemKiTu>();
	public static void addList(char addchar,int addnum) {
		DemKiTu temp = new DemKiTu(addchar, addnum);
		result.add(temp);
	}
	public static int dem(String str,char tim) {
		int dem=0;
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i) == tim) dem++;
		}
		return dem;
	}
	public static boolean checkKiTu(List<DemKiTu> result,char check) {
		for(DemKiTu item:result) {
			if(item.kitu == check) return true;
		}
		return false;
	}
	public static void demKiTu(String str, List<DemKiTu> result) {
		for(int i=0;i<str.length();i++) {
			if(!checkKiTu(result,str.charAt(i))) {
				addList(str.charAt(i), dem(str,str.charAt(i)));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str;
		out.print("Nhap chuoi: "); str = sc.next();
		demKiTu(str,result);
		for(DemKiTu item: result) {
			item.show();
		}
		sc.close();
	}
}
