import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Primes_and_Multiplication {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int x = t.nextInt();
		long n = t.nextLong();
		ArrayList<Integer> pf = prime_fact(x);

		long ans = 1, temp1 = n;
		for (int i = 0; i < pf.size(); i++) {
			int temp = pf.get(i);
			long pow = 0;

			while (n > 0) {
				pow += n / temp;
				n = n / temp;
			}

			ans = ans * evaluate(temp, pow);
			if (ans >= 1000000007) {
				ans = ans % 1000000007;
			}
			n = temp1;
		}
		System.out.println(ans);
	}

	public static ArrayList<Integer> prime_fact(int n) {
		ArrayList<Integer> pf = new ArrayList<>();
		HashSet<Integer> pfs = new HashSet<>();
		;

		while (n % 2 == 0) {
			if (!pfs.contains(2)) {
				pfs.add(2);
				pf.add(2);
			}
			n = n / 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i++) {
			while (n % i == 0) {
				if (!pfs.contains(i)) {
					pfs.add(i);
					pf.add(i);
				}
				n = n / i;
			}
		}

		if (n > 2) {
			if (!pfs.contains(n)) {
				pfs.add(n);
				pf.add(n);
			}
		}
		return pf;
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

}