import java.util.Scanner;

public class Restoring_Three_Numbers {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		int[] a = new int[4];
		a[0] = t.nextInt();
		int max = a[0];
		int idx = 0;
		
		for (int i = 1; i < 4; i++) {
			a[i] = t.nextInt();
			if (a[i] > max) {
				max = a[i];
				idx = i;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if (idx != i)
				System.out.print(max - a[i] + " ");
		}

	}

}