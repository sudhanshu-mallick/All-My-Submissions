import java.util.HashMap;
import java.util.Scanner;

public class Towers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);

			if (map.get(a[i]) > max)
				max = map.get(a[i]);
		}

		System.out.println(max + " " + map.size());
	}

}
