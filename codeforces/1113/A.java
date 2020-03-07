import java.util.ArrayList;
import java.util.Scanner;

public class Sasha_And_His_Trip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int v = t.nextInt();
		ArrayList<Integer> a = new ArrayList();

		if (n - 1 <= v)
			a.add(n - 1);
		else {
			a.add(v - 1);

			for (int i = 1; i <= n - v; i++) {
				a.add(a.get(a.size() - 1) + i);
			}
		}

		System.out.println(a.get(a.size() - 1));

	}

}
