import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Garland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> evenl = new ArrayList<>();
		ArrayList<Integer> oddl = new ArrayList<>();
		HashSet<Integer> map = new HashSet<>();
		int even = 0, odd = 0, min = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (a[i] != 0) {
				map.add(a[i]);
				list.add(i);
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!map.contains(i)) {
				if (i % 2 == 0)
					even++;
				else
					odd++;
			}
		}

		if (list.isEmpty()) {
			if (n == 1)
				System.out.println(0);
			else
				System.out.println(1);

			return;
		}

		for (int i = 1; i < list.size(); i++) {
			int i1 = list.get(i), i2 = list.get(i - 1);

			if (a[i1] % 2 == a[i2] % 2) {
				if (a[i1] % 2 == 0)
					evenl.add(i1 - i2 - 1);
				else
					oddl.add(i1 - i2 - 1);
			} else
				min++;
		}

		Collections.sort(evenl);
		Collections.sort(oddl);

		for (int i = 0; i < evenl.size(); i++) {
			if (even >= evenl.get(i))
				even -= evenl.get(i);
			else
				min += 2;
		}

		for (int i = 0; i < oddl.size(); i++) {
			if (odd >= oddl.get(i))
				odd -= oddl.get(i);
			else
				min += 2;
		}

		if (a[list.get(0)] % 2 == 0) {
			if (even >= list.get(0))
				even -= list.get(0);
			else
				min += 1;

		} else {
			if (odd >= list.get(0))
				odd -= list.get(0);
			else
				min += 1;
		}

		if (a[list.get(list.size() - 1)] % 2 == 0) {
			if (even >= n - list.get(list.size() - 1) - 1) {
				even -= n - list.get(list.size() - 1) - 1;
			} else {
				min += 1;
			}
		} else {
			if (odd >= n - list.get(list.size() - 1) - 1) {
				odd -= n - list.get(list.size() - 1) - 1;
			} else {
				min += 1;
			}
		}

		System.out.println(min);
	}

}
