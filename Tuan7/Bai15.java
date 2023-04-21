package PGBT1;
import java.util.*;
import static java.lang.System.out;

public class Bai15 {
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
	public static void kiTuMax(List<DemKiTu> result) {
		int maxdem = result.get(0).dem;
		for(int i=1;i<result.size();i++) {
			if(result.get(i).dem > maxdem) maxdem = result.get(i).dem;
		}
		out.print("Ki tu lap nhieu nhat: ");
		for(int i=0;i<result.size();i++) {
			if(result.get(i).dem == maxdem) out.print(result.get(i).kitu + ", ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str="everybody";
		out.println("Chuoi: "+str);
		demKiTu(str,result);
		kiTuMax(result);
		sc.close();
	}
}
