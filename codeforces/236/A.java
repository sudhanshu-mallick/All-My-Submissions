import java.util.HashMap;
import java.util.Scanner;

public class Boy_or_Girl {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		String s = new String();
		s = t.next();
		HashMap<Character, Boolean> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), true);

		if (map.size() % 2 == 1)
			System.out.println("IGNORE HIM!");

		else
			System.out.println("CHAT WITH HER!");

	}

}