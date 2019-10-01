import java.util.Scanner;

public class Equalize_Prices_Again {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			double[] a = new double[n];
			double sum = 0;

			for (int i = 0; i < n; i++) {
				a[i] = t.nextDouble();
				sum += a[i];
			}

			int SUM =(int) Math.ceil(sum/n);

			System.out.println(SUM);
		}

	}

}
