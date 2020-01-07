import java.util.Scanner;
 
public class Chat_Room {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		String s = "";
		s = t.next();
		String p = "hello";
		int j = 0;
 
		for (int i = 0; i < s.length(); i++) {
			if (j < 5 && s.charAt(i) == p.charAt(j)) {
				j++;
			}
		}
 
		if (j == 5)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
 
}