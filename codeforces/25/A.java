import java.util.ArrayList;
import java.util.Scanner;

public class IQ_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (a[i] % 2 == 0)
				even.add(i + 1);
			else
				odd.add(i + 1);
		}

		if (even.size() == 1)
			System.out.println(even.get(0));
		else
			System.out.println(odd.get(0));

	}

}
