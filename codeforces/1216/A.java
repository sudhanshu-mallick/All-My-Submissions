import java.util.Scanner;

public class Prefixes {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s = "";
		s = t.next();
		StringBuilder ans = new StringBuilder();
		int count = 0;

		for (int i = 0; i <= n - 2; i += 2) {
			if (s.substring(i, i + 2).equals("aa") || s.substring(i, i + 2).equals("bb")) {
				ans.append("ab");
				count++;
			} else {
				ans.append(s.substring(i, i + 2));
			}
		}

		System.out.println(count + "\n" + ans);

	}

}
