package polyu.comp.datastructure;

/**
 * Created by huanganna on 9/30/16.
 */
public class Search {

    //recursion
    public int binarySearch(int[]a,int left, int right,int value){
        if(left>right)
            return -1;
        int mid = (left+right)/2;
        if(a[mid] == value)
            return mid;
        return a[mid]<value?binarySearch(a,mid+1,right,value):binarySearch(a,left,mid-1,value);
    }

    //iteration 若没有找到，low和high之间的位置则是应该插入的位置，这也是一种在有序数组中插入元素的方法。折半插入排序就利用了此思想
    public int iterativeBinarySearch(int[]a,int value){
        int low = 0, high = a.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid] == value){
                return mid;
            }else if(a[mid] < value){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,7,8,9,12};
        Search search = new Search();
        System.out.println(search.binarySearch(a,0,a.length-1,11));
        System.out.println(search.iterativeBinarySearch(a, 12));

    }
}
