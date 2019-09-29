import java.util.HashSet;
import java.util.Scanner;

public class Distinct_Digits {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int l = t.nextInt();
		int r = t.nextInt();

		for (int j = l; j <= r; j++) {
			HashSet<Integer> map = new HashSet<>();
			int i = j;
			boolean flag = true;

			while (i != 0) {
				if (map.contains(i % 10)) {
					flag = false;
					break;
				}

				map.add(i % 10);
				i /= 10;
			}

			if (flag) {
				System.out.println(j);
				return;
			}
		}

		System.out.println(-1);

	}

}
