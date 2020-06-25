import java.util.*;
import java.io.*;

public class Xenia_And_Bit_Operation {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		int size = 1 << n;
		int m = t.nextInt();
		long[] a = new long[size];

		for (int i = 0; i < size; ++i)
			a[i] = t.nextLong();

		Tree tree = new Tree(a, size);

		while (m-- > 0) {
			int idx = t.nextInt() - 1;
			long val = t.nextLong();

			o.println(tree.update(idx, val, size));
		}

		o.flush();
		o.close();
	}

}

class Tree {
	private class Node {
		long val;
		Node left;
		Node right;

		private Node(long val) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	Node head;
	int cur;

	public Tree(long[] a, int n) {
		List<Node> list = new ArrayList<>();
		boolean f = true;

		for (int i = 0; i < n; ++i) {
			list.add(new Node(a[i]));
		}

		while (list.size() > 1) {
			List<Node> temp = new ArrayList<>();

			if (f)
				for (int i = 0; i < list.size(); i += 2) {
					long val = list.get(i).val | list.get(i + 1).val;
					Node left = list.get(i);
					Node right = list.get(i + 1);
					Node node = new Node(val);
					node.left = left;
					node.right = right;

					temp.add(node);
				}
			else
				for (int i = 0; i < list.size(); i += 2) {
					long val = list.get(i).val ^ list.get(i + 1).val;
					Node left = list.get(i);
					Node right = list.get(i + 1);
					Node node = new Node(val);
					node.left = left;
					node.right = right;

					temp.add(node);
				}

			list = temp;
			f = !f;
		}

		this.head = list.get(0);
	}

	public void cur() {
		this.cur = 0;
	}

	public long update(int idx, long val, int n) {
		this.cur();
		return update(idx, val, 0, n - 1, this.head).val;
	}

	private Node update(int idx, long val, int low, int high, Node node) {
		if (low == high) {
			node = new Node(val);
			return node;
		}

		int mid = (low + high) / 2;

		if (mid >= idx) {
			node.left = update(idx, val, low, mid, node.left);
		} else {
			node.right = update(idx, val, mid + 1, high, node.right);
		}

		if ((cur & 1) == 0)
			node.val = (node.left.val | node.right.val);
		else
			node.val = (node.left.val ^ node.right.val);

		this.cur++;

		return node;
	}

	public long getHead() {
		return head.val;
	}

}