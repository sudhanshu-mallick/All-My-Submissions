import java.util.HashMap;
import java.util.Scanner;

public class Palindrome_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			HashMap<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				a[i] = t.nextInt();

				if (map.containsKey(a[i])) {
					map.put(a[i], map.get(a[i]) + 1);
				} else {
					map.put(a[i], 1);
				}
			}

			int flag = 0;

			for (int i = 0; i < n - 2; i++) {
				int val = map.get(a[i]);

				if (val == 2) {
					if (a[i] != a[i + 1]) {
						flag = 1;
						break;
					} else {
						map.put(a[i], val - 1);
					}
				} else if (val > 2) {
					flag = 1;
					break;
				} else {

				}
			}

			if (flag == 0)
				System.out.println("NO");
			else
				System.out.println("YES");

		}
	}

}
