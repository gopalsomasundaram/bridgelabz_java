package stringbuilderlinearbinary;

/*
this class compares the execution time of StringBuffer and
StringBuilder. StringBuilder is generally faster as it is not
synchronized (not thread-safe), whereas StringBuffer includes
overhead for thread-safety.
*/
public class ConcatenationSpeedTest {

    //main function to measure and compare performance
    public static void main(String[] args) {
        int iterations = 1000000;
        String text = "hello";

        //measure StringBuilder time
        long start = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) builder.append(text);
        long end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1e6 + " ms");

        //measure StringBuffer time
        start = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) buffer.append(text);
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1e6 + " ms");
    }
}