package polyu.competitive.code;

import java.util.ArrayList;

/**
 * Created by huanganna on 9/26/16.
 */
public class C {
    public static void main(String[] args) {
        int[] a = new int[4];
        ArrayList<Integer> groupNums = new ArrayList<>();
        groupNums.add(2);
        groupNums.add(3);
        groupNums.add(4);
        groupNums.add(4);
        groupNums.add(2);
        groupNums.add(1);
        groupNums.add(3);
        groupNums.add(1);
        for(int i=0;i<groupNums.size();i++){
            switch (groupNums.get(i)){
                case 1:a[0]++;
                    break;
                case 2:a[1]++;
                    break;
                case 3:a[2]++;
                    break;
                case 4:a[3]++;
                    break;
            }
        }
        int shang = a[1]/2;
        int remainder = a[1]%2;
        int add=0;
        int tmp = a[0]>a[2]?a[0]-a[2]:0;
        if(remainder>0){
            tmp = tmp>3?tmp-3:0;
            add=1;
        }
        if(tmp%4==0){
            System.out.println(a[3]+a[2]+shang+add+tmp/4);
        }else{
            System.out.println(a[3]+a[2]+shang+add+tmp/4+1);
        }
    }
    //        if(catalogTail >= Math.pow(2,k)){
//            int[][] temp = new int[(int)Math.pow(2,k+1)][];
//            int jTemp = 0;
//            int iTemp = 0;
//            for(int i=0;i<catalogArray.length;i++){
//                iTemp = i/2;
//                if(i%2==0){
//                    jTemp = 0;
//                    temp[iTemp] = new int[(int)Math.pow(2,k+1)];
//                }
//                for(int j=0;j<Math.pow(2,k);j++){
//                    temp[iTemp][jTemp++] = catalogArray[i][j];
//                }
//            }
//            temp[iTemp+1] = new int[(int)Math.pow(2,k+1)];
//            temp[iTemp+1][branchTail++] = value;
//            catalogTail = (int)Math.pow(2,k-1);
//            catalogArray = temp;
//            actualSize++;
//            k++;
//        }else{
////            if(catalogArray[catalogTail]==null){
////                catalogArray[catalogTail] = new int[(int)Math.pow(2,k)];
////                catalogArray[catalogTail][branchTail++] = value;
////            }else{
////                if(branchTail<=Math.pow(2,k)-1){
////                    catalogArray[catalogTail][branchTail++] = value;
////                    if(branchTail>=Math.pow(2,k)){
////                        catalogTail++;
////                        branchTail = 0;
////                    }
////                }
////
////            }
//            if(catalogArray[catalogTail]==null){
//                catalogArray[catalogTail] = new int[(int)Math.pow(2,k)];
//            }
//            catalogArray[catalogTail][branchTail++] = value;
//            if(branchTail>=Math.pow(2,k)) {
//                catalogTail++;
//                branchTail = 0;
//            }
//            actualSize++;
//        }

}
