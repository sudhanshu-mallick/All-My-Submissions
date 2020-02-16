import java.util.Scanner;

public class Boredom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		long[] in = new long[100003];
		long[] ans = new long[100003];

		for (int i = 0; i < n; i++)
			in[t.nextInt()]++;

		ans[0] = 0;
		ans[1] = in[1];

		for (int i = 2; i < 100003; i++)
			ans[i] = Math.max(ans[i - 1], ans[i - 2] + in[i] * i);

		System.out.println(ans[100002]);

	}

}
