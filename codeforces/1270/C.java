import java.util.Scanner;

public class Make_Good {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			long sum = 0, xor = 0;

			for (int i = 0; i < n; i++) {
				a[i] = t.nextInt();
				sum += a[i];
				xor ^= a[i];
			}

			System.out.println(2);
			System.out.println(xor + " " + (sum + xor));
		}
	}

}
