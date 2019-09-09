import java.util.Scanner;

public class System_Administrator {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int a = 0, b = 0, pa = 0, pb = 0;

		while (n-- > 0) {
			int p = t.nextInt();
			int x = t.nextInt();
			int y = t.nextInt();

			if (p == 1) {
				pa += 10;
				a += x;
			} else {
				pb += 10;
				b += x;
			}

		}

		if (2 * a >= pa)
			System.out.println("LIVE");
		else
			System.out.println("DEAD");
		if (2 * b >= pb)
			System.out.println("LIVE");
		else
			System.out.println("DEAD");
	}

}
