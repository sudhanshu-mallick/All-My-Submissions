import java.util.Scanner;

public class Candies_Division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();

		while (n-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();
			int a1 = 0, b1 = 0, k = b / 2;
			b1 = a % b;
			a1 = b - b1;

			if (b1 > k) {
				a1 += b1 - k;
				b1 -= b1 - k;
			}

			a1 = a1 * (a / b);
			b1 = b1 * (a / b + 1);
			//System.out.println(a1+" "+b1);

			System.out.println(a1 + b1);

		}
	}

}