import java.util.ArrayList;
import java.util.Scanner;

public class Infinity_Gauntlet {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s[] = new String[n];
		ArrayList<String> a = new ArrayList();

		for (int i = 0; i < n; i++) {
			s[i] = t.next();
		}

		boolean flag = false;

		for (int i = 0; i < n; i++) {
			if (s[i].equals("purple"))
				flag = true;
		}

		if (flag)
			flag = false;
		else
			a.add("Power");

		for (int i = 0; i < n; i++) {
			if (s[i].equals("green"))
				flag = true;
		}

		if (flag)
			flag = false;
		else
			a.add("Time");

		for (int i = 0; i < n; i++) {
			if (s[i].equals("blue"))
				flag = true;
		}

		if (flag)
			flag = false;
		else
			a.add("Space");

		for (int i = 0; i < n; i++) {
			if (s[i].equals("orange"))
				flag = true;
		}

		if (flag)
			flag = false;
		else
			a.add("Soul");

		for (int i = 0; i < n; i++) {
			if (s[i].equals("red"))
				flag = true;
		}

		if (flag)
			flag = false;
		else
			a.add("Reality");

		for (int i = 0; i < n; i++) {
			if (s[i].equals("yellow"))
				flag = true;
		}

		if (flag)
			flag = false;
		else
			a.add("Mind");

		System.out.println(a.size());

		for (int i = 0; i < a.size(); i++)
			System.out.println(a.get(i));

	}

}