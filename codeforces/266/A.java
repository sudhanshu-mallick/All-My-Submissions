import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stone_on_a_Table {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader t = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(t.readLine());
		String s = t.readLine();
		int count = 0;

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				count++;
		}

		System.out.println(count);

	}

}