import java.util.Scanner;

public class Vitiya_And_The_Countryside {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		if (n == 1) {
			if (a[0] == 0)
				System.out.println("UP");
			else if (a[0] == 15)
				System.out.println("DOWN");
			else
				System.out.println("-1");
		} else {
			if (a[n - 1] == 15)
				System.out.println("DOWN");
			else if (a[n - 1] == 0)
				System.out.println("UP");
			else if (a[n - 2] < a[n - 1])
				System.out.println("UP");
			else
				System.out.println("DOWN");
		}
	}

}
