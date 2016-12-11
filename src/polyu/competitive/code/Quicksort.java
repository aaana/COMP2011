package polyu.competitive.code;

/**
 * Created by huanganna on 11/18/16.
 */
import java.util.*;
/**
 * Quicksort routine for arrays - invented by C.A.R. Hoare
 * Code modeled on QUICKSORT on page 154 of Introduction
 * to Algorithms by Cormen, Leiserson, & Rivest - 1st edition
 * @author Suzanne Balik, 8 Nov 2001
 */
public class Quicksort {

    public static void sort(int[] array) {

        Quicksort(array, 0, array.length - 1);
    }


    private static void Quicksort(int[] array, int first, int last) {
        if(first>=last)
            return;

//        if (first < last) {

            int x = array[first];

            int i = first - 1;

            int j = last + 1;

            while (i<j) {

                do  {

                    i++;

                } while (array[i] < x);

                do {
                    j--;

                } while (array[j] > x);



                if ( i < j ) {

                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                }

            }

            Quicksort(array, first, j);

            Quicksort(array, j+1, last);

//        }
    }

//    private static int partition(int array[], int first, int last) {
//
//        int x = array[first];
//
//        int i = first - 1;
//
//        int j = last + 1;
//
//        while (i<j) {
//
//            do {
//                j--;
//
//            } while (array[j] > x);
//
//            do  {
//
//                i++;
//
//            } while (array[i] < x);
//
//            if ( i < j ) {
//
//                int tmp = array[i];
//                array[i] = array[j];
//                array[j] = tmp;
//
//            }
//
//        }
//        return j;
//    }



    public static String toString(int[] array) {

        String s = "[";
        for (int i = 0; i < array.length; i++)
            s += " " + array[i];
        s += " ]";
        return s;
    }

    public static void main(String[] args) {

        int[] array = {2,2,1,1,0};

        System.out.println("Unsorted array: " +
                Quicksort.toString(array));
        Quicksort.sort(array);

        System.out.println("Sorted array:   " +
                Quicksort.toString(array));
        if (args.length == 1) {
            array = new int[Integer.parseInt(args[0])];
            Random generator = new Random();
            final int MAX = 200;
            for (int i = 0; i < array.length; i++)
                array[i] = generator.nextInt(MAX);
            long startTime = System.currentTimeMillis();
            Quicksort.sort(array);
            long stopTime = System.currentTimeMillis();
            System.out.println("Time to sort " + args[0] +
                    " random integers in range 1 - 200: " +
                    (stopTime - startTime) + "ms");
        }
    }
}
