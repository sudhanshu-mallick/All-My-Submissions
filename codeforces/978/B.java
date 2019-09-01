import java.util.Scanner;

public class File_Name {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s = "";
		s = t.next();
		int remove = 0;

		for (int i = 0; i < n - 2; i++) {
			if (s.charAt(i) == 'x' && s.charAt(i + 1) == 'x' && s.charAt(i + 2) == 'x')
				remove++;
		}

		System.out.println(remove);

	}

}