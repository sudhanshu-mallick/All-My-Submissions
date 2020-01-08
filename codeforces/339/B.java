import java.util.Scanner;

public class Xenia_And_Ringroad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int m = t.nextInt();
		int n = t.nextInt();
		int[] a = new int[n];
		int cur = 1; 
		long steps = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < n; i++) {
			if (cur == a[i]) {

			} else if (cur > a[i]) {
				steps += m + a[i] - cur;
				cur = a[i];
			} else {
				steps += a[i] - cur;
				cur = a[i];
			}

		}

		System.out.println(steps);
	}

}
