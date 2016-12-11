package polyu.comp.datastructure;

/**
 * Created by huanganna on 11/10/16.
 */
public class QuickSort {

    static public void printArr(int[] array) {

        String s = "[";
        for (int i = 0; i < array.length; i++)
            s += " " + array[i];
        s += " ]";
        System.out.println(s);
    }

    public static void swap(int[]a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//
//    static public void printArr(int[]a){
//        for(int i=0;i<a.length-1;i++){
//            System.out.print(a[i]+",");
//        }
//        System.out.println(a[a.length-1]);
//    }

    static public void quickSort1(int[]a,int begin,int end){
        if(begin>=end)
            return;
        int pivot = a[end];
        int i = begin;
        for(int j=begin;j<=end;j++){
            if(a[j]<=pivot)
                swap(a,i++,j);
        }
        quickSort(a,begin,i-2);
        quickSort(a,i,end);
    }

    //!!!!!
    static public void quickSort(int[] a, int begin, int end){
        if(begin>=end)
            return;
        int pivot = a[end];
        int i = begin - 1;
        int j = end + 1;
        while (i<j){
            do{
                i++;
            }while (a[i]<pivot);
            do{
                j--;
            }while (a[j]>pivot);
            if(i<j){
                swap(a,i,j);
            }
            printArr(a);
        }
        quickSort(a, begin, i-1);
        quickSort(a,i,end);
    }

    static public void quickSort(int[]a){
        quickSort(a,0,a.length-1);
    }

    public static void main(String[] args) {
//        int[] a = {0,0,3,2,1,1};
//        printArr(a);
//        QuickSort.quickSort(a);

//        System.out.println();
//        int[] b = {2,2,2,2,2};
//        printArr(b);
//        QuickSort.quickSort(b);

        System.out.println();
        int[] c = {2,1,1};
        printArr(c);
        QuickSort.quickSort(c);
    }
}
