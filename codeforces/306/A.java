import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int m = t.nextInt();
		int loop = m;

		for (int i = 0; i < loop; i++) {
			System.out.print(n / m + " ");
			n = n - n / m;
			m--;
		}

	}

}