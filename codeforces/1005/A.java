import java.util.ArrayList;
import java.util.Scanner;

public class Tanya_and_Stairways {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];
		int stair = 0;
		ArrayList<Integer> arr = new ArrayList();
		int c = 0;

		for (int i = 0; i < n; i++) {

			a[i] = t.nextInt();

			if (a[i] == 1) {
				if (i == 0) {
					c = 1;
				} else {
					arr.add(c);
					c = 1;
				}

				stair++;
			} else {
				c++;
			}
		}

		arr.add(c);

		System.out.println(stair);

		for (int i = 0; i < arr.size(); i++)
			System.out.print(arr.get(i) + " ");

	}

}