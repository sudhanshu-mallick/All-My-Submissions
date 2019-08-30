import java.util.Scanner;

public class Book_Reading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);

		int q = t.nextInt();

		while (q-- > 0) {
			String n1 = t.next();
			String m1 = t.next();
			long sum = 0;

			long n = Long.parseLong(n1);
			long m = Long.parseLong(m1);

			if (m * 10 <= n) {
				for (long i = m; i <= m * 10; i += m)
					sum += i % 10;

				sum *= n / (m * 10);
				long k = n - (m * 10) * (n / (m * 10));

				for (long i = m; i <= k; i += m)
					sum += i % 10;

			} else {
				for (long i = m; i <= n; i += m)
					sum += i % 10;
			}
			System.out.println(sum);
		}

	}

}