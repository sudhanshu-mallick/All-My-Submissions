import java.util.Scanner;

public class Football {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		String s = "";
		s = t.next();
		int cur = 1;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				cur++;

				if (cur == 7) {
					System.out.println("YES");
					return;
				}
			} else {
				cur = 1;
			}
		}

		System.out.println("NO");

	}

}
