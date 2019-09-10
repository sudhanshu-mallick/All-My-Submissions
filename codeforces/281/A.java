import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Word_Capitalization {

	public static void main(String[] args) throws IOException {
		BufferedReader t = new BufferedReader(new InputStreamReader(System.in));

		String s = t.readLine();

		if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')
			System.out.println(s);
		else {
			System.out.println(Character.toUpperCase(s.charAt(0)) + "" + s.substring(1));
		}
	}

}