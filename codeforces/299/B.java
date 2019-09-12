import java.util.Scanner;

public class Ksusha {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int k = t.nextInt();
		String s = "";
		s = t.next();

		boolean ans = possible(s, k, 0);

		if (ans)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	private static boolean possible(String s, int k, int idx) {
		if (idx == s.length() - 1)
			return true;

		for (int i = idx + 1; i <= idx + k; i++) {
			if (s.charAt(i) == '.')
				return possible(s, k, i);
		}

		return false;
	}
}
