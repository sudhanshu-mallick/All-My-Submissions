import java.util.Scanner;

public class Gennady_And_Card_Game {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		String s1 = "";
		String[] s2 = new String[5];
		s1 = t.next();
		boolean res = false;
		
		for (int i = 0; i < 5; i++) {
			s2[i] = t.next();
			if (s2[i].charAt(0) == s1.charAt(0) || s2[i].charAt(1) == s1.charAt(1))
				res = true;
		}

		if (res)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}