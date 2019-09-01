import java.util.Arrays;
import java.util.Scanner;

public class Polycarps_Pockets {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];
		int cur = 1, max = 1;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < n - 1; i++) {
			if (a[i] == a[i + 1])
				cur++;
			else {
				if (max < cur)
					max = cur;
				cur = 1;
			}
		}

		if (a.length != 1 && a[n - 2] == a[n - 1]) {
			if (max < cur)
				max = cur;
		}

		System.out.println(max);
	}

}
