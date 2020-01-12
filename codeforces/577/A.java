import java.util.HashSet;
import java.util.Scanner;

public class Multiplication_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int m = t.nextInt();
		HashSet<Integer> map = new HashSet<>();
		int c = 0;

		for (int i = 1; i <= n; i++)
			map.add(i);

		for (int i = 1; i <= n; i++) {
			if (m % i == 0 && map.contains(i) && map.contains(m / i)) {
				map.remove(i);
				if (i == m / i) {
					c++;
				} else {
					c += 2;
					map.remove(m / i);
				}
			}
		}

		System.out.println(c);

	}

}
