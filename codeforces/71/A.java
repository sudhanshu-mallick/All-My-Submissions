import java.util.Scanner;

public class Way_Too_Long_Words {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int q = t.nextInt();

		while (q-- > 0) {
			String s = new String();
			s = t.next();

			if (s.length() > 10)
				System.out.println(s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1));

			else
				System.out.println(s);
		}

	}

}
