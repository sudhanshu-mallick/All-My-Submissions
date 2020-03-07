import java.util.Scanner;

public class QAQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		String s = "";
		s = t.next();
		int n = s.length();
		int q = 0, ql, qr;

		for (int i = 0; i < n; i++)
			if (s.charAt(i) == 'Q')
				q++;

		ql = 0;
		qr = q;
		q = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'Q') {
				ql++;
				qr--;
			} else if (s.charAt(i) == 'A')
				q += ql * qr;
		}

		System.out.println(q);

	}

}
