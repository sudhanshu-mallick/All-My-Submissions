import java.util.Scanner;

public class Presents {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];
		int[] myresult = new int[n];

		for (int i = 0; i < n; i++) {
			int temp = t.nextInt();
			a[i] = --temp;
		}

		inverse(a, myresult, 0);
		display(myresult, 0);
	}

	private static void display(int[] myresult, int vidx) {
		if (vidx == myresult.length) {

			return;
		}

		System.out.print(myresult[vidx] + 1 + " ");
		display(myresult, vidx + 1);

	}

	private static void inverse(int[] arr, int[] myresult, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		inverse(arr, myresult, vidx + 1);

		myresult[arr[vidx]] = vidx;

	}

}