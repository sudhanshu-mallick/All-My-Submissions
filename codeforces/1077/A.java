import java.util.Scanner;

public class Frog_Jump {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		long test = t.nextInt();

		while (test-- > 0) {
			long a = t.nextInt();
			long b = t.nextInt();
			long k = t.nextInt();

			System.out.println(a * ((k + 1) / 2) - b * (k / 2));
		}

	}

}