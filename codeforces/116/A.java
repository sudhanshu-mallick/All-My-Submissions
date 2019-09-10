import java.util.Scanner;

public class Tram {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int max = 0, pass = 0;

		while (n-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();
			pass += b - a;

			if (pass > max)
				max = pass;
		}

		System.out.println(max);

	}

}