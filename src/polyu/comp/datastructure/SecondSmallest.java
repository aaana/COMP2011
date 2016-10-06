package polyu.comp.datastructure;

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

    public static void main(String[] args) {
        System.out.println(SecondSmallest.find(new int[]{1, 1, 2, 3, 4, 2, 5, 0}, 0, 7)[1]);
    }
}
