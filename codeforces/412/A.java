import java.util.Scanner;

public class Poster {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int k = t.nextInt();
		String s = "";
		s = t.next();

		if (k <= n / 2) {
			for (int i = k; i > 1; i--)
				System.out.println("LEFT");

			for (int i = 1; i <= n; i++) {
				System.out.println("PRINT " + s.charAt(i - 1));

				if (i != n)
					System.out.println("RIGHT");
			}

		} else {
			for (int i = k; i < n; i++)
				System.out.println("RIGHT");

			for (int i = n; i > 0; i--) {
				System.out.println("PRINT " + s.charAt(i - 1));

				if (i != 1)
					System.out.println("LEFT");
			}
		}

	}

}