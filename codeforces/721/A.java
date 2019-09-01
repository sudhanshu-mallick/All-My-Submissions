import java.util.ArrayList;
import java.util.Scanner;

public class Japanese_Crossword {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s = "";
		s = t.next();
		int k = 0, b = 0;
		ArrayList<Integer> a = new ArrayList();

		for (int i = 0; i < n; i++) {

			if (s.charAt(i) == 'B')
				b++;
			else if(b!=0){
				k++;
				a.add(b);
				b = 0;
			}

		}

		if (s.charAt(n - 1) == 'B') {
			k++;
			a.add(b);
		}

		System.out.println(k);

		for (int i = 0; i < a.size(); i++)
			System.out.print(a.get(i) + " ");

	}

}