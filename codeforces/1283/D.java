import java.io.*;
import java.util.*;
 
public class D1283 implements Runnable {
 
    private static final int MAX = 2* (int) (1E5 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    long[] x = new long[MAX];
    private void solve() throws IOException {
        int n =reader.nextInt();
        int m = reader.nextInt();
        TreeSet<Long> set = new TreeSet<>();
        TreeSet<Long> tset = new TreeSet<>();
        List<Long> res = new ArrayList<>();
        TreeSet<Long> temp = new TreeSet<>();
        for(int i=0;i<n;i++) {
            x[i] = reader.nextLong();
            set.add(x[i]);
        }
        for(int i=0;i<n;i++){
            if(!set.contains(x[i]+1))
                tset.add((x[i]+1));
            if(!set.contains(x[i]-1))
                tset.add((x[i]-1));
            set.add(x[i]-1);
            set.add(x[i]+1);
        }
 
        long sum =0, k=1;
        while(true){
            for(long a : tset){
                res.add(a);
                sum+=k;
                if(!set.contains(a-1))
                    temp.add(a-1);
                if(!set.contains(a+1))
                    temp.add(a+1);
                set.add(a-1);
                set.add(a+1);
                m--;
                if(m<=0)break;
            }
            if(m<=0)break;
            k++;
            tset.clear();
            for(long a: temp)
                tset.add(a);
            temp.clear();
        }
 
        writer.println(sum);
        for(long a: res)
            writer.print(a+" ");
    }
 
    public static void main(String[] args) throws IOException {
        try (Input reader = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            new D1283().run();
        }
    }
 
    StandardInput reader;
    PrintWriter writer;
 
    @Override
    public void run() {
        try {
            reader = new StandardInput();
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    interface Input extends Closeable {
        String next() throws IOException;
 
        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        default double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
 
        default int[] readIntArray() throws IOException {
            return readIntArray(nextInt());
        }
 
        default int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
            return array;
        }
 
        default long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }
 
    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        private StringTokenizer stringTokenizer;
 
        @Override
        public void close() throws IOException {
            reader.close();
        }
 
        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}