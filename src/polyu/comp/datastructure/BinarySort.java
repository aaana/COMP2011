package polyu.comp.datastructure;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by huanganna on 9/30/16.
 */
public class BinarySort {

    public static void binarySort(Student[]a){
        int i = 0, j= a.length-1;
        Student temp;

        while(i<j){
            while(a[i].gender==0){
                i++;
            }
            while (a[j].gender==1){
                j--;
            }
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

//    public static void main(String[] args) {
//        int[] test = {1,1,1,0,1,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,1};
//        BinarySort binarySort = new BinarySort();
//        binarySort.binarySort(test);
//        for(int i=0;i<test.length-1;i++){
//            System.out.print(test[i]+",");
//        }
//        System.out.println(test[test.length-1]);
//
//    }
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int size = 10;
        Student[] arr = new Student[size];
        // build 100 students with random id and gender.
        for (int i= 0; i < size; i++ ) {
            int id = Math.abs(random.nextInt(100));
            arr[i] = new Student(id, (byte) (id % 2));
        }
        System.out.println(Arrays.stream(arr).
                map(Student::toString).
                collect(Collectors.joining("\n ")));
        binarySort(arr);
        System.out.println("----------------after sorting----------------");
        System.out.println(Arrays.stream(arr).
                map(Student::toString).
                collect(Collectors.joining("\n ")));
    }
}

class Student {
    int id;
    byte gender; // 0 for girls and 1 for boys.

    public Student (int id, byte gender) {
        this.id = id;
        this.gender = gender;
    }

    public String toString () {
        return (gender == 0? "female":"male") + " student " + id;
    }
}
