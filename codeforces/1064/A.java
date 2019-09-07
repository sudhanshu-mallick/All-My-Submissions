import java.util.Arrays;
import java.util.Scanner;

public class Make_a_Triangle {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int[] a = new int[3];
		a[0] = t.nextInt();
		a[1] = t.nextInt();
		a[2] = t.nextInt();

		Arrays.sort(a);

		if (a[0] + a[1] > a[2])
			System.out.println(0);
		else
			System.out.println(a[2] - a[1] - a[0] + 1);

	}

}
