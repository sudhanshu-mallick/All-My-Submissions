import java.util.Scanner;

public class Maximum_Increase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		int[] max = new int[n];
		max[0] = 1;
		int maximum = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1])
				max[i] = max[i - 1] + 1;
			else
				max[i] = 1;
		}

		for (int i = 0; i < n; i++)
			maximum = Math.max(maximum, max[i]);

		System.out.println(maximum);
	}

}
