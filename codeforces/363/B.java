import java.util.Scanner;

public class Fence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int m = t.nextInt();
		int[] a = new int[n];
		int[] height = new int[n - m + 1];
		int k = 0, idx = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (k < m) {
				height[0] += a[i];
				k++;
			}
		}

		int min = height[0];

		for (int i = 1; i < height.length; i++) {
			height[i] = height[i - 1] - a[i - 1] + a[i + m - 1];
			min = Math.min(min, height[i]);

			if (min == height[i])
				idx = i;
		}

		System.out.println(idx + 1);
	}

}
