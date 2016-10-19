package polyu.comp.datastructure.assign1;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by huanganna on 10/4/16.
 */
public class ImprovedSelectionSort {
    public static void selectionSort(int[] b) {
        int n = b.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++)
                if (b[j] < b[min])
                    min = j;

            // swap
            int temp = b[min];
            b[min] = b[i];
            b[i] = temp;
        }
    }

    public static void improvedSelectionSort1(int[] b){
        int n = b.length;

        //1st improvement: put the int variable outside the for loop to save time and space.
        int minIndex;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i; j < n; j++)
                if (b[j] < b[minIndex])
                    minIndex = j;

            // swap
            int temp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = temp;
        }
    }

    public static void improvedSelectionSort2(int[] b){
        int n = b.length;

        //2nd improvement: if the first n-1 elements are in the right place, then the last element is in place.
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i;j<n;j++)
                if(b[j]<b[minIndex])
                    minIndex = j;

            // not over improved, no need to check if i==minIndex
            int temp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = temp;
        }
    }

    public static void improvedSelectionSort3(int[] b){
        int n = b.length;
        for(int i=0;i<n;i++){
            int minIndex = i;
            //3st improvement
            for(int j=i+1;j<n;j++)
                if(b[j]<b[minIndex])
                    minIndex = j;

            // not over improved, no need to check if i==minIndex
            int temp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = temp;
        }
    }

    public static void improvedSelectionSortMix(int[] b){
        int n = b.length;

        //1st improvement: put the int variable outside the for loop to save time and space.
        int minIndex;
        //2nd improvement: if the first n-1 elements are in the right place, then the last element is in place.
        for(int i=0;i<n-1;i++){
            minIndex = i;
            //3st improvement
            for(int j=i+1;j<n;j++)
                if(b[j]<b[minIndex])
                    minIndex = j;

            // not over improved, no need to check if i==minIndex
            int temp = b[minIndex];
            b[minIndex] = b[i];
            b[i] = temp;
        }
    }

    public static void main(String[] args) {
        // you need to change the sie and turns if it runs too slow,
        // or if the differences are too insignificant.
        //
        // try at least three different sizes.
        int size = 50000, turns = 30;
        long startTime = 0, duration = 0;

        int[] a = new int[size];
        int[] b = new int[size];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++)
            a[i] = random.nextInt(size);

        // If you would like to see the array (before or after sorting),
        // use the following to print out the content of the array.
        //
        // But please comment them off when you start testing. WHY?
        //
//        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
//        ImprovedSelectionSort.improvedSelectionSort(a);
//        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
//
//        if (true) return;
        startTime = System.currentTimeMillis();
        for (int j = 0; j < turns; j++) {
            for (int i = 0; i < size; i++)
                b[i] = a[i];
            selectionSort(b);
        }
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(size+" length: " + turns + " runs of selectionSort takes "+ (duration / 1000.) + " seconds.");
//        System.out.println(Arrays.stream(b).mapToObj(Integer::toString).collect(Collectors.joining(", ")));

        //improvement1
        startTime = System.currentTimeMillis();
        for (int j = 0; j < turns; j++) {
            for (int i = 0; i < size; i++)
                b[i] = a[i];
            improvedSelectionSort1(b);
        }
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(size+" length: " + turns + " runs of improvedSelectionSort1 takes "+ (duration / 1000.) + " seconds.");
//        System.out.println(Arrays.stream(b).mapToObj(Integer::toString).collect(Collectors.joining(", ")));

        //improvement2
        startTime = System.currentTimeMillis();
        for (int j = 0; j < turns; j++) {
            for (int i = 0; i < size; i++)
                b[i] = a[i];
            improvedSelectionSort2(b);
        }
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(size+" length: " + turns + " runs of improvedSelectionSort2 takes "+ (duration / 1000.) + " seconds.");
//        System.out.println(Arrays.stream(b).mapToObj(Integer::toString).collect(Collectors.joining(", ")));

        //improvement3
        startTime = System.currentTimeMillis();
        for (int j = 0; j < turns; j++) {
            for (int i = 0; i < size; i++)
                b[i] = a[i];
            improvedSelectionSort3(b);
        }
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(size+" length: " + turns + " runs of improvedSelectionSort3 takes "+ (duration / 1000.) + " seconds.");
//        System.out.println(Arrays.stream(b).mapToObj(Integer::toString).collect(Collectors.joining(", ")));

        //improvementMix
        startTime = System.currentTimeMillis();
        for (int j = 0; j < turns; j++) {
            for (int i = 0; i < size; i++)
                b[i] = a[i];
            improvedSelectionSortMix(b);
        }
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(size+" length: " + turns + " runs of improvedSelectionSortMix takes "+ (duration / 1000.) + " seconds.");
//        System.out.println(Arrays.stream(b).mapToObj(Integer::toString).collect(Collectors.joining(", ")));

    }
}
