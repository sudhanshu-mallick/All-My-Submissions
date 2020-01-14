import java.util.Scanner;

public class Mike_And_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		String s = "";
		s = t.next();
		int count = 0;

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				count++;
		}

		if (count > 1)
			System.out.println("NO");
		else if (count == 1)
			System.out.println("YES");
		else {
			if (s.length() % 2 == 0)
				System.out.println("NO");
			else
				System.out.println("YES");

		}
	}

}
