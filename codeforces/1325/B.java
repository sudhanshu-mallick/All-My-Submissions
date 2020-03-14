import java.util.HashSet;
import java.util.Scanner;

public class Copy5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			HashSet<Integer> map = new HashSet<>();

			for (int i = 0; i < n; i++) {
				a[i] = t.nextInt();

				map.add(a[i]);
			}

			System.out.println(map.size());
		}
	}

}