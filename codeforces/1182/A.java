import java.util.Scanner;

public class Filling_Shapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();

		if (n % 2 == 1)
			System.out.println(0);
		else {
			long ans = (long) Math.pow(2, n / 2);

			System.out.println(ans);
		}
	}

}
