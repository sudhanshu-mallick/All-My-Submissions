import java.util.Scanner;

public class Scarboroug_Fair {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int m = t.nextInt();
		char[] s = new char[n];
		s = t.next().toCharArray();

		while (m-- > 0) {
			int l = t.nextInt();
			int r = t.nextInt();
			char L = t.next().charAt(0);
			char R = t.next().charAt(0);

			for (int i = l - 1; i <= r - 1; i++)
				if (s[i] == L)
					s[i] = R;
		}

		System.out.println(s);

	}

}
