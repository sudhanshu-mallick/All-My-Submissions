import java.util.Scanner;

public class Hulk {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s1 = "I hate ";
		String s2 = "I love ";
		String that = "that ";
		String it = "it ";
		String ans = "";

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				if (i == n - 1)
					ans += s1 + it;
				else
					ans += s1 + that;
			} else {
				if (i == n - 1)
					ans += s2 + it;
				else
					ans += s2 + that;
			}
		}

		System.out.println(ans);

	}

}
