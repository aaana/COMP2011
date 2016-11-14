package polyu.comp.datastructure.assign3;

/**
 * Created by huanganna on 11/10/16.
 */
public class QuickSort {

    public static void swap(int[]a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static public void printArr(int[]a){
        for(int i=0;i<a.length-1;i++){
            System.out.print(a[i]+",");
        }
        System.out.println(a[a.length-1]);
    }

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

    static public void quickSort(int[] a, int begin, int end){
        if(begin>=end)
            return;
        int pivot = a[end];
        int i = begin - 1;
        int j = end + 1;
        while (i<=j){
            do{
                i++;
            }while (i<=end&&a[i]<pivot);
            do{
                j--;
            }while (j>=begin&&a[j]>pivot);
            if(i<j){
                swap(a,i,j);
            }
            printArr(a);
        }
        quickSort(a, begin, j);
        quickSort(a,j+1,end);
    }

    public static void main(String[] args) {
        int[] a = {4,3,2,1,1};
        printArr(a);
        QuickSort.quickSort(a, 0, 4);

        System.out.println();
        int[] b = {2,2,2,2,2};
        printArr(b);
        QuickSort.quickSort(b, 0, 4);

        System.out.println();
        int[] c = {1,2,2,3,4,4};
        printArr(c);
        QuickSort.quickSort(c,0,5);
    }
}
