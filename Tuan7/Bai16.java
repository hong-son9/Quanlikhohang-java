package PGBT1;
import java.util.*;
import static java.lang.System.out;

public class Bai16 {
	public static int countWords(String str) {
		if(str == null) return 0;
		int countw=0;
		if(str.charAt(0) != ' ') countw++;
		for(int i=0;i<str.length();i++) { 
			if(str.charAt(i)==' ' && str.charAt(i+1)!=' ' ||
			   str.charAt(i)==',' && str.charAt(i+1)!=',' ||
			   str.charAt(i)=='.' && str.charAt(i+1)!='.'  ) {
				countw++;
			}
		}
		return countw;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Hello World";
		out.println(str);
		out.println("So ki tu: "+countWords(str));
	}
}
