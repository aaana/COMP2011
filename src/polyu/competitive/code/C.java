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

}
