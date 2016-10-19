package polyu.comp.datastructure.assign1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by huanganna on 10/2/16.
 */
public class SecondSmallest {

    public static int[] find(int[] array,int left,int right){
        if(right-left<=1){
            if(array[left]<array[right]){
                return new int[]{array[left],array[right]};
            }else{
                return new int[]{array[right],array[left]};
            }
        }else{
            int mid = (left+right)/2;
            int[] leftResult = find(array,left,mid);
            int[] rightResult = find(array,mid+1,right);
            if(leftResult[0]<rightResult[0]){
                if(leftResult[0] == leftResult[1])
                    return new int[]{leftResult[0],rightResult[0]};
                if(leftResult[1]<rightResult[0]){
                    return new int[]{leftResult[0],leftResult[1]};
                }else{
                    return new int[]{leftResult[0],rightResult[0]};
                }
            }else if(leftResult[0]>rightResult[0]){
                if(rightResult[0] == rightResult[1])
                    return new int[]{leftResult[0],leftResult[0]};
                return rightResult[1]<leftResult[0]?new int[]{rightResult[0],rightResult[1]}:new int[]{rightResult[0],leftResult[0]};
            }else{
                return rightResult[1]<leftResult[1]?new int[]{rightResult[0],rightResult[1]}:new int[]{rightResult[0],leftResult[1]};
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Please enter an array like 1,1,2,2,3,4,5(separated by ,):");
        InputStreamReader is_reader = new InputStreamReader(System.in);
        String str = new BufferedReader(is_reader).readLine();
        String[] strArr = str.split(",");
        int[] intArr = new int[strArr.length];
        for(int i=0;i<intArr.length;i++)
            intArr[i] = Integer.parseInt(strArr[i]);
        System.out.println("The second smallest: "+SecondSmallest.find(intArr, 0, intArr.length-1)[1]);
    }
}
