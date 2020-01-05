import java.util.Arrays;
import java.util.Scanner;

public class Cut_Ribbon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] ar = new int[n + 1];
		Arrays.fill(ar, Integer.MIN_VALUE);
		ar[0] = 0;
		int a = t.nextInt();
		int b = t.nextInt();
		int c = t.nextInt();

		for (int i = 1; i <= n; i++) {
			if (i >= a)
				ar[i] = Math.max(ar[i], ar[i - a] + 1);
			if (i >= b)
				ar[i] = Math.max(ar[i], ar[i - b] + 1);
			if (i >= c)
				ar[i] = Math.max(ar[i], ar[i - c] + 1);
		}

		System.out.println(ar[n]);
	}

}
