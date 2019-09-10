import java.util.Scanner;

public class Three_Piles_of_Candies {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		long q = t.nextLong();

		while (q-- > 0) {
			long a = t.nextLong();
			long b = t.nextLong();
			long c = t.nextLong();

			System.out.println((a + b + c) / 2);
		}

	}

}
