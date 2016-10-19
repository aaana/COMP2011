package polyu.comp.datastructure.assign1;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by huanganna on 10/7/16.
 */

// "abc" == "abc" false

// 0 == 0 true
// int[][] a = new int[10][];
// a[0] = new int[8];
// a[0] = new int[10];
// enqueue: O(1)  dequeue: O(n)[move the elements to left.] ＝》改进：循环队列
// 对象在heap中，引用在stack中

public class ExpressionCal {



//    public posfixParser(){
//
//    }

    public static boolean isOperator(char c){
        return (c=='+')||(c=='-')||(c=='*')||(c=='/');
    }

    public static int evalPostFix(String postFix){
        Stack<Integer> s = new Stack<>();
        //
        StringTokenizer parser = new StringTokenizer(postFix," \n\t\r",false);
        while(parser.hasMoreTokens()){
            String token = parser.nextToken();
//            System.out.println(token);
            char c = token.charAt(0);
            if(isOperator(c)){
                int x = s.pop();
                int y = s.pop();
                switch (c){
                    case '+': s.push(x+y);break;
                    case '-': s.push(y-x);break;
                    case '*': s.push(x*y);break;
                    case '/': s.push(y/x);break;
                }
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalPostFix("3 2 -"));
    }

}
