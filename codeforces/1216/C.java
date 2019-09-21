
import java.util.Scanner;

public class White_Sheet {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		long x1 = t.nextLong();
		long y1 = t.nextLong();
		long x2 = t.nextLong();
		long y2 = t.nextLong();
		long x3 = t.nextLong();
		long y3 = t.nextLong();
		long x4 = t.nextLong();
		long y4 = t.nextLong();
		long x5 = t.nextLong();
		long y5 = t.nextLong();
		long x6 = t.nextLong();
		long y6 = t.nextLong();

		long areaWB1 = intersect(x1, x2, y1, y2, x3, x4, y3, y4);
		long areaWB2 = intersect(x1, x2, y1, y2, x5, x6, y5, y6);
		long areaB1B2 = intersect2(x3, x4, y3, y4, x5, x6, y5, y6, x1, x2, y1, y2);

		if ((x2 - x1) * (y2 - y1) - (areaWB1 + areaWB2 - areaB1B2) > 0)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	private static long intersect(long x1, long x2, long y1, long y2, long x3, long x4, long y3, long y4) {
		long area = 0;
		long upper = Math.min(x4, x2);
		long lower = Math.max(x1, x3);
		long left = Math.max(y1, y3);
		long right = Math.min(y2, y4);

		area = (upper - lower) * (right - left);

		if (upper < lower || right < left)
			return 0;
		else if (area >= 0)
			return area;
		else
			return 0;
	}

	private static long intersect2(long x1, long x2, long y1, long y2, long x3, long x4, long y3, long y4, long xi,
			long xf, long yi, long yf) {
		long area = 0;
		long upper = Math.min(x4, x2);
		long lower = Math.max(x1, x3);
		long left = Math.max(y1, y3);
		long right = Math.min(y2, y4);

		area = (upper - lower) * (right - left);

		if (upper < lower || right < left)
			return 0;
		else if (area >= 0)
			return intersect(xi, xf, yi, yf, lower, upper, left, right);
		else
			return 0;
	}

}
