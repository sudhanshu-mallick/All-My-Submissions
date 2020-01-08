import java.util.Scanner;

public class New_Year_Candles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int a = t.nextInt();
		int b = t.nextInt();
		int hrs = a, rem = 0;

		while (a > 0) {
			int q = a / b;
			rem = a % b;
			hrs += q;

			if (q == 0)
				break;

			a = q + rem;
		}

		System.out.println(hrs);
	}

}
