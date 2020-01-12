import java.util.Scanner;

public class Dreamoon_And_Stars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int m = t.nextInt();
		int n = t.nextInt();
		int two = m / 2, one = m - 2 * (m / 2);

		for (int i = 0; i <= m / 2; i++) {

			if (two < 0)
				break;

			if ((one + two) % n == 0) {
				System.out.println(one + two);
				return;
			}

			two--;
			one += 2;
		}

		System.out.println(-1);
	}

}
