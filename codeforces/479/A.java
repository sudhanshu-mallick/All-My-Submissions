import java.util.Scanner;

public class Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int a = t.nextInt();
		int b = t.nextInt();
		int c = t.nextInt();
		int max = 0;

		if (a + b + c > max)
			max = a + b + c;

		if (a + b * c > max)
			max = a + b * c;

		if (a * b + c > max)
			max = a * b + c;

		if (a * b * c > max)
			max = a * b * c;

		if ((a + b) * c > max)
			max = (a + b) * c;

		if (a * (b + c) > max)
			max = a * (b + c);

		System.out.println(max);

	}

}
