package polyu.competitive.code;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huanganna on 9/26/16.
 */
public class CandyBags {

    public Map<Integer,ArrayList<Integer>> gerald(int n){
        Map<Integer,ArrayList<Integer>> result = new HashMap<>();
        Map<Integer,ArrayList<Integer>> temp = new HashMap<>();
        for(int i=1;i<=n*n/2;i++){
            temp.put(i,new ArrayList<>());
            ((ArrayList)temp.get(i)).add(i);
            ((ArrayList)temp.get(i)).add(n*n-i+1);
        }

        for(int i=1;i<=n;i++){
            for(int j=(n/2)*(i-1)+1;j<=n/2*i;j++){
                if(result.get(i)==null)
                {
                    result.put(i,new ArrayList<>());
                }
                for(int k: temp.get(j))
                    result.get(i).add(k);

            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{

        CandyBags candyBags = new CandyBags();
        InputStreamReader is_reader = new InputStreamReader(System.in);

        // 通常使用 BufferedReader 来读取 InputStream 中的字符串内容。
        // BufferedReader 可以一次读取一行。
        String str = new BufferedReader(is_reader).readLine();
        int n = Integer.parseInt(str);
        Map<Integer,ArrayList<Integer>> result = candyBags.gerald(n);
        for(int i=1;i<=result.size();i++){
            for(int j: result.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
}
