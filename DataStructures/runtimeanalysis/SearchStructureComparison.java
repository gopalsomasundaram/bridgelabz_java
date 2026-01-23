package runtimeanalysis;

import java.util.HashSet;
import java.util.TreeSet;

/*
this class compares search speeds across Arrays, HashSets, and TreeSets.
it validates that HashSets provide the fastest average-case lookups O(1),
TreeSets provide O(log N), and Arrays require O(N) unless sorted.
*/
public class SearchStructureComparison {

    public static void main(String[] args) {
        int size = 1000000;
        int target = 999999;

        //populating structures
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        //testing Array search (O(N))
        long start = System.nanoTime();
        for (int x : array) {
            if (x == target) break;
        }
        System.out.println("Array Search time: " + (System.nanoTime() - start) / 1000000.0 + "ms");

        //testing HashSet search (O(1))
        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet Search time: " + (System.nanoTime() - start) / 1000000.0 + "ms");

        //testing TreeSet search (O(log N))
        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet Search time: " + (System.nanoTime() - start) / 1000000.0 + "ms");
    }
}