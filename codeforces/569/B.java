import java.util.HashMap;
import java.util.Scanner;

public class Inventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		int step = 1;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();
			map.put(i + 1, 0);
		}

		for (int i = 0; i < n; i++) {
			if (a[i] <= n)
				map.put(a[i], map.get(a[i]) + 1);
			else {
				a[i] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				while (map.get(step) >= 1) {
					step++;
				}

				a[i] = step;
				map.put(a[i], 1);
			} else if (map.get(a[i]) == 1) {
				//
			} else if (map.get(a[i]) > 1) {
				while (map.get(step) >= 1) {
					step++;
				}

				map.put(a[i], map.get(a[i]) - 1);
				a[i] = step;
				map.put(a[i], 1);
			} else {
				//
			}
		}

		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");

	}

}
