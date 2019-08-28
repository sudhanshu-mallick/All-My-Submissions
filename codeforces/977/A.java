import java.util.Scanner;

public class Wrong_Subtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int k = t.nextInt();

		while (k-- > 0) {
			if (n % 10 == 0)
				n /= 10;
			else
				n--;
		}

		System.out.println(n);

	}

}