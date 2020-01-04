import java.util.Scanner;

public class Fancy_Fence {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			double a = t.nextDouble();
			double n = 3, ans = 60;

			while (ans < a) {
				n++;
				ans = ((n - 2) * 180) / n;
			}

			if (ans == a)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}
