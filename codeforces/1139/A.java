import java.util.Scanner;

public class Even_Substrings {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s = new String("");
		s = t.next();
		int even = 0;

		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(s.substring(i, i + 1)) % 2 == 0)
				even += i + 1;
		}

		System.out.println(even);

	}

}
