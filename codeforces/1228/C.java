import java.util.ArrayList;
import java.util.Scanner;

public class Primes_and_Multiplication {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		long x = t.nextLong();
		long y = t.nextLong();
		ArrayList<Integer> a = fac(x);
		long ans = 1;

		for (int i = 1; i <= a.size(); i++) {
			ans = (ans * evaluate(a.get(i - 1), pow(y, a.get(i - 1)))) % 1000000007;
		}
		System.out.println(ans);

	}

	public static long evaluate(int temp, long pow) {
		if (pow == 0) {
			return 1;
		}

		else {
			long ans = evaluate(temp, pow / 2);

			if (ans >= 1000000007) {
				ans = ans % 1000000007;
			}

			ans = ans * ans;

			if (ans >= 1000000007) {
				ans = ans % 1000000007;
			}

			if (pow % 2 == 1) {
				ans = ans * temp;
			}

			if (ans >= 1000000007) {
				ans = ans % 1000000007;
			}

			return ans;

		}
	}

	public static long pow(long y, long x) {
		long pow = 0;

		while (y > 0) {
			pow += y / x;
			y = y / x;
		}

		return pow;
	}

	public static ArrayList<Integer> fac(long n) {
		ArrayList<Integer> a = new ArrayList<>();

		if (n % 2 == 0) {
			a.add(2);
			while (n % 2 == 0) {
				n /= 2;
			}
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				a.add(i);

				while (n % i == 0) {
					n /= i;
				}

			}
		}

		if (n > 2 && !a.contains(n))
			a.add((int) n);

		return a;
	}

}