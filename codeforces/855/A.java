import java.util.ArrayList;
import java.util.Scanner;

public class Tom_Riddle_Diary {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		ArrayList<String> a = new ArrayList();

		while (n-- > 0) {
			String s = "";
			s = t.next();
			boolean flag = false;

			for (int i = 0; i < a.size(); i++) {
				if (s.equals(a.get(i))) {
					flag = true;
					System.out.println("YES");
					break;
				}
			}

			if (!flag)
				System.out.println("NO");

			a.add(s);
		}

	}

}
