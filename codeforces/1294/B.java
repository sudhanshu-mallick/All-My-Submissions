import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Collecting_Packages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			Pair[] a = new Pair[n];

			for (int i = 0; i < n; i++) {
				int x = t.nextInt();
				int y = t.nextInt();
				a[i] = new Pair(x, y);
			}

			Compare1 ob1 = new Compare1();
			ob1.compare(a, n);
			
			Compare2 ob2 = new Compare2();
			ob2.compare(a, n);

			StringBuilder s = new StringBuilder();
			int x = 0, y = 0, dx = 0, dy = 0, flag = 0;

			for (int i = 0; i < n; i++) {
				dx = a[i].x - x;
				dy = a[i].y - y;
				x = a[i].x;
				y = a[i].y;

				if (dx < 0 || dy < 0) {
					flag = 1;
					break;
				}

				while (dx-- > 0)
					s.append("R");

				while (dy-- > 0)
					s.append("U");
			}

			if (flag == 0) {
				System.out.println("YES");
				System.out.println(s);
			} else {
				System.out.println("NO");
			}

		}
	}

}


class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Compare1 {
	static void compare(Pair arr[], int n) {
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.x - p2.x;
			}
		});
	}
}

class Compare2 {
	static void compare(Pair arr[], int n) {
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.y - p2.y;
			}
		});
	}
}

