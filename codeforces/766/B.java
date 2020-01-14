import java.util.Arrays;
import java.util.Scanner;

public class Mahmoud_And_A_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < n - 2; i++) {
			if (a[i] + a[i + 1] > a[i + 2]) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}

}
