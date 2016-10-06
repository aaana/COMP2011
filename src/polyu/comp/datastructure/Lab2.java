package polyu.comp.datastructure;

/**
 * Created by huanganna on 16/9/22.
 */
public class Lab2 {
    public long factorial3(long x){
        if(x==0||x==1){
            return 1;
        }else{
            return x*factorial3(x-1);
        }
    }

    public long factorial1(long x){
        long result = 1;
        for(long i=1;i<=x;i++){
            result = result*i;
        }
        return result;
    }

    public long factorial2(long x){

        long result = 1;
        long i = x;
        while(i>=1){
            result = result*i;
            i--;
        }
        return result;
    }

    public long fibonacci1(long x){
        if(x==0||x==1){
            return x;
        }else{
            return fibonacci1(x-2)+fibonacci1(x-1);
        }
    }

    public long fibonacci2(long x){
        long result = 0;
        if(x==0||x==1){
            return x;
        }else{
            long first = 0;
            long second = 1;
            for(long i=0;i<x-1;i++){
                result = first+second;
                first = second;
                second = result;
            }
            return result;
        }
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Lab2 lab = new Lab2();

        long startTime = System.currentTimeMillis();
        System.out.println(lab.factorial1(10));
        long duration = (System.currentTimeMillis() - startTime);
        System.out.println(duration*1000);

        startTime = System.currentTimeMillis();
        System.out.println(lab.factorial2(10));
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(duration*1000);

        startTime = System.currentTimeMillis();
        System.out.println(lab.factorial3(10));
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(duration*1000);

        startTime = System.currentTimeMillis();
        System.out.println(lab.fibonacci1(30));
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(duration*1000);

        startTime = System.currentTimeMillis();
        System.out.println(lab.fibonacci2(30));
        duration = (System.currentTimeMillis() - startTime);
        System.out.println(duration*1000);


    }
}
