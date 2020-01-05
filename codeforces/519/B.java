import java.util.Scanner;

public class A_And_B_And_Compilation_Errors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		long sum1 = 0, sum2 = 0, sum3 = 0;

		for (int i = 0; i < n; i++)
			sum1 += t.nextLong();

		for (int i = 0; i < n - 1; i++)
			sum2 += t.nextLong();

		for (int i = 0; i < n - 2; i++)
			sum3 += t.nextLong();

		System.out.println(sum1 - sum2);
		System.out.println(sum2 - sum3);

	}

}