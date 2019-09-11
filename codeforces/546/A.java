import java.util.Scanner;

public class Soldier_and_Bananas {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		long k = t.nextLong();
		long n = t.nextLong();
		long w = t.nextLong();
		long ans = (w * (w + 1) * k) / 2 - n;

		if (ans >= 0)
			System.out.println(ans);
		else
			System.out.println(0);

	}

}