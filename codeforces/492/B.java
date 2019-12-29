import java.util.Arrays;
import java.util.Scanner;

public class Vanya_And_Lanterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int l = t.nextInt();
		int[] a = new int[n + 2];
		a[n + 1] = l;
		double d = 0;

		for (int i = 1; i <= n; i++) {
			a[i] = t.nextInt();
		}

		Arrays.sort(a);

		for (int i = 2; i <= n; i++) {
			if (d < a[i] - a[i - 1])
				d = a[i] - a[i - 1];
		}

		d = d / 2;

		if (d < a[1] - a[0])
			d = a[1] - a[0];

		if (d < a[n + 1] - a[n])
			d = a[n + 1] - a[n];

		System.out.println(d);

	}

}