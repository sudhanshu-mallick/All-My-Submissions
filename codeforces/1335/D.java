import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 9; ++i) {
				String s = t.next();

				for (int j = 0; j < 9; ++j) {
					if (s.charAt(j) == '1')
						sb.append('2');
					else
						sb.append(s.charAt(j));
				}

				sb.append("\n");
			}

			System.out.println(sb);
		}
	}
}