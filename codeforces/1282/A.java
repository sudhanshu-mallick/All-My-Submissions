import java.util.Scanner;

public class Temporarily_Unavailable {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			long a = t.nextLong();
			long b = t.nextLong();
			long c = t.nextLong();
			long r = t.nextLong();

			if (a > b) {
				long p = a;
				a = b;
				b = p;
			}

			if (b - a == 0)
				System.out.println(0);
			else {
				long r1 = c - r;
				long r2 = c + r;

				if ((r1 > b && r2 > b) || (r1 < a && r2 < a))
					System.out.println(b - a);
				else {
					if (r1 <= a && r2 >= a && r2 <= b) {
						System.out.println(b - r2);
					} else if (r1 >= a && r1 <= b && r2 >= b) {
						System.out.println(- a + r1);
					} else if (r1 >= a && r2 <= b)
						System.out.println(r1 - a + b - r2);
					else
						System.out.println(0);
				}
			}
		}

	}

}
