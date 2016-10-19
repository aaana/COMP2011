package polyu.comp.datastructure;

import java.security.SecureRandom;

/**
 * Created by huanganna on 16/9/22.
 */
public class Sort {

    //选择排序，依次选择子数组最小的放在最左边
    public void selectionSort(int[] a){
        int length = a.length;
        int minIndex = 0;
        for(int i=0;i<length-1;i++){
            minIndex = i;
            for(int j=i+1;j<length;j++){
                if(a[j]<a[minIndex])
                    minIndex = j;
            }
            if(i!=minIndex){
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
    }


    //课上练习
    public static boolean isBalanced(char[] s){
        int count = 0;
        for(int i=0;i<s.length;i++){
            if(s[i] == '(') count++;
            if(s[i] == ')') count--;
            if(count<0) return false;
        }

        return count==0;
    }

    //冒泡排序是比较相邻的两个元素，保持大的在右边。每次循环的结束标志和第几次循环有关

    //改进的冒泡排序，某次没有逆序则表示已经完全有序
    public void bubbleSort(int[]a){
        int n = a.length;
        for(int i=0;i<n-1;i++){
            boolean exchange = false;
            for(int j=0;j<n-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    exchange = true;
                }
            }
            if(exchange==false)
                return;
        }

    }

    //归并算法： 分治思想。将数组division到长度为1时，再合并。需要用到合并两个有序数组的算法。需要一个临时数组，用来保存结果，最后将其赋值到原数组
    public void mergeSort(int[]array){
        int n = array.length;
        if(n>1){
            int[]temp = new int[n];
            mergeSort(array,temp,0,n-1);
        }
    }

    private void mergeSort(int[]array,int[]temp,int left,int right){
        if(left<right){
            int mid = (left + right)/2;
            mergeSort(array,temp,left,mid);
            mergeSort(array,temp,mid+1,right);
            merge(array,temp,left,mid,right);

        }
    }

    private void merge(int[]array,int[]temp,int left,int mid,int right){
        int i = left,j = mid+1,k = 0;
        while(i<=mid&&j<=right){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        if(i>mid){
            while(j<=right){
                temp[k++] = array[j++];
            }
        }else{
            while(i<=mid){
                temp[k++] = array[i++];
            }
        }
        for(int index=0;index<=right-left;index++){
            array[left+index] = temp[index];
        }
    }
    //int 是基本类型 其实java的传参实际是赋值 只不过对于对象来说，java中存的是地址
//    public void swap(int a,int b){
//        int temp = a;
//        a = b;
//        b = temp;
//    }

    //插入排序。将数组中的元素从左到右插入到左边形成的有序数组中去
    public void insertionSort(int[] a){
        int length = a.length;
        for(int i=1;i<length;i++){
            int temp = a[i];
            int j =i-1;
            while(j>=0&&a[j]>temp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sort sort = new Sort();
        int[] a = {11,2,1,3,5};
        sort.selectionSort(a);
        for(int i =0;i<a.length;i++)
            System.out.println(a[i]);

//        int size = 100000, turns = 20;
//        long startTime = 0, duration = 0;
//        int[] a = new int[size];
//        int[] b = new int[size];
//        SecureRandom random = new SecureRandom();
//        for (int i = 0; i < size; i++)
//            a[i] = random.nextInt(size);
//        startTime = System.currentTimeMillis();
//        for (int j = 0; j < turns; j++) {
//            for (int i = 0; i < size; i++)
//                b[i] = a[i];
//            sort.selectionSort(b);
//        }
//        duration = (System.currentTimeMillis() - startTime);
//        System.out.println(turns + " runs of selectionSort takes " +
//                (duration / 1000.) + " seconds.");
//
//        startTime = System.currentTimeMillis();
//        for (int j = 0; j < turns; j++) {
//            for (int i = 0; i < size; i++)
//                b[i] = a[i];
//            sort.insertionSort(b);
//        }
//        duration = (System.currentTimeMillis() - startTime);
//        System.out.println(turns + " runs of insertionSort takes " +
//                (duration / 1000.) + " seconds.");

//        int a = 10;
//        int b = 20;
//        System.out.println("a: "+a+" b: "+b);
//        sort.swap(a,b);
//        System.out.println("a: "+a+" b: "+b);

        String s = "()()())";
        System.out.println(s+"is "+(Sort.isBalanced(s.toCharArray())?"":"not ")+"balanced");

        int k = 2;
        System.out.println("!!!!!"+Math.pow(4,k));

    }
}

