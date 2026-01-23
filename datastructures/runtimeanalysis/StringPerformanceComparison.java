package runtimeanalysis;

/*
this class compares the performance of String, StringBuilder, and
StringBuffer during massive concatenation operations. it illustrates
how the immutability of String leads to O(N²) time due to constant
object creation, whereas mutable buffers operate in O(N).
*/
public class StringPerformanceComparison {

    public static void main(String[] args) {
        int n = 100000; //number of operations

        //testing immutable String concatenation
        long start = System.currentTimeMillis();
        String s = "";
        //this is extremely slow for large n
        for (int i = 0; i < 10000; i++) {
            s += "hello";
        }
        System.out.println("String time (10k ops): " + (System.currentTimeMillis() - start) + "ms");

        //testing mutable StringBuilder (single-threaded)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        System.out.println("StringBuilder time (" + n + " ops): " + (System.currentTimeMillis() - start) + "ms");

        //testing mutable StringBuffer (thread-safe)
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("hello");
        }
        System.out.println("StringBuffer time (" + n + " ops): " + (System.currentTimeMillis() - start) + "ms");
    }
}