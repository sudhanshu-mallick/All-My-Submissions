import java.util.ArrayList;
import java.util.Scanner;

public class Santa_Claus_And_Candies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		int cur = 1;
		int p = n;
		int now = 0;

		while (n > 0) {
			if (n - cur > cur) {
				a.add(cur);
				n -= cur;
				now += cur;
				cur++;
			} else {
				a.add(p - now);
				break;
			}
		}

		System.out.println(a.size());

		for (int i = 0; i < a.size(); i++)
			System.out.print(a.get(i) + " ");
	}

}
