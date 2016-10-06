package polyu.competitive.code;

/**
 * Created by huanganna on 9/26/16.
 */
public class B {
    public static void main(String[] args) {
        int y=10;
        int k=6;
        int n=40;
        int yes=0;
        for(int i=y;i<=n;i++){
            if(i%k==0){
                if(i-y>0){
                    System.out.print((i-y)+" ");
                    yes=1;
                }
            }
        }
        if(yes==0)
            System.out.println(-1);
    }
}
