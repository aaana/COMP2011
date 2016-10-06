package polyu.competitive.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by huanganna on 9/26/16.
 */
public class A {
    public static void main(String[] args) throws Exception{
        InputStreamReader is_reader = new InputStreamReader(System.in);

        // 通常使用 BufferedReader 来读取 InputStream 中的字符串内容。
        // BufferedReader 可以一次读取一行。
        String str = new BufferedReader(is_reader).readLine();
        int n = Integer.parseInt(str);

            for(int i=1;i<=n*n/2;i++){
                System.out.print(i+" "+(n*n-i+1)+" ");
                if(i%(n/2)==0)
                    System.out.println();
            }
        }

    }
