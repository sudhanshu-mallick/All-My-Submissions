import java.util.Scanner;

public class Word {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		String s = new String();
		s = t.next();

		int upper = 0;

		for (int i = 0; i < s.length(); i++)
			if (Character.isUpperCase(s.charAt(i)))
				upper++;

		if (2 * upper <= s.length())
			System.out.println(s.toLowerCase());
		else
			System.out.println(s.toUpperCase());

	}

}