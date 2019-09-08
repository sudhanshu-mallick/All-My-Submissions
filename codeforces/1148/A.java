import java.util.Scanner;

public class Another_One_Bites_The_Dust {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		long a = t.nextLong();
		long b = t.nextLong();
		long ab = t.nextLong();
		a = a + ab;
		b = b + ab;

		if (Math.abs(a - b) <= 1)
			System.out.println(a + b);
		else
			System.out.println(2 * Math.min(a, b) + 1);

	}

}