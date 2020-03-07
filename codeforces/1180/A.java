import java.util.Scanner;

public class Alex_and_A_Rhombus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		a[0] = 1;

		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + i * 4;
		}

		System.out.println(a[n - 1]);
	}

}
