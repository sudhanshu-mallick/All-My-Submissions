import java.util.Scanner;

public class New_Year_Transportation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int m = t.nextInt();
		int flag = 0;
		int[] a = new int[n];
		a[n - 1] = 1;

		for (int i = 0; i < n - 1; i++) {
			a[i] = t.nextInt();
		}

		for (int i = 0; i < n; i += a[i]) {

			if (i + 1 == m)
				flag = 1;
		}

		if (flag == 1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
