import java.util.Scanner;

public class Anton_And_Dainik {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s = "";
		s = t.next();
		int anton = 0, danik = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'A')
				anton++;
			else
				danik++;
		}

		if (anton > danik)
			System.out.println("Anton");
		else if (danik > anton)
			System.out.println("Danik");
		else
			System.out.println("Friendship");

	}

}
