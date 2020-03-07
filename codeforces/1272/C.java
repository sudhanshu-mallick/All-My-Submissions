import java.util.HashSet;
import java.util.Scanner;

public class Yet_Another_Broken_Keyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int k = t.nextInt();
		String s = "";
		s = t.next();
		HashSet<Character> map = new HashSet();
		long ans = 0, seq = 0;

		for (int i = 0; i < k; i++)
			map.add(t.next().charAt(0));

		for (int i = 0; i < n; i++) {
			if (map.contains(s.charAt(i))) {
				seq++;
			} else {
				ans += ((seq + 1) * seq) / 2;
				seq = 0;
			}
		}

		ans += ((seq + 1) * seq) / 2;

		System.out.println(ans);
	}

}
