import java.util.Scanner;

public class Joysticks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int a = t.nextInt();
		int b = t.nextInt();
		int min = 0;

		while (a > 0 && b > 0) {
			if (a > b) {
				a -= 2;
				b += 1;
			} else {
				a += 1;
				b -= 2;
			}

			if (a >= 0 && b >= 0)
				min++;
		}

		System.out.println(min);
	}

}
