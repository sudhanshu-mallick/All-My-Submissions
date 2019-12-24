
import java.util.Scanner;

public class Theatre_Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		long n = t.nextLong();
		long m = t.nextLong();
		long a = t.nextLong();
		long p1 = 0l, p2 = 0l;

		if (n % a != 0)
			p1 = n / a + 1;
		else
			p1 = n / a;

		if (m % a != 0)
			p2 = m / a + 1;
		else
			p2 = m / a;

		System.out.println(p1 * p2);

	}

}