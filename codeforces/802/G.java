import java.util.Scanner;

public class Fake_News {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		String s = new String();
		s = t.next();
		int i = 0;
		String heidi = "heidi";

		for (int j = 0; j < s.length(); j++) {
			if (i == 5)
				break;
			if (s.charAt(j) == heidi.charAt(i))
				i++;
		}

		if (i == 5)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
