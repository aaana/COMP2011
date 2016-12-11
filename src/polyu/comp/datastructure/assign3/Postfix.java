package polyu.comp.datastructure.assign3;


import java.util.StringTokenizer;

/**
 * Created by huanganna on 11/16/16.
 */
public class Postfix {
    public static boolean isOperator(char c) {
        return ((c == '+') || (c == '-') || (c == '*') || (c == '/'));
    }

    public static boolean isWhitespace(char c) {
        return ((c == ' ') || (c == '\n') || (c == '\t') || (c == '\r'));
    }

    public static ExpressionTree buildTree(String postfix){
        Stack treeNodeStack = new Stack();
        StringTokenizer parser = new StringTokenizer(postfix," \n\t\r",false);
        while(parser.hasMoreTokens()){
            String token = parser.nextToken();
            TreeNode treeNode = new TreeNode(token);
//            System.out.println(token);
            char c = token.charAt(0);
            if(isOperator(c)) {
                treeNode.rightChild = treeNodeStack.pop();
                treeNode.leftChild = treeNodeStack.pop();
                treeNodeStack.push(treeNode);
            }else {
                treeNodeStack.push(treeNode);
            }
        }
        ExpressionTree expressionTree = new ExpressionTree();
        expressionTree.root = treeNodeStack.pop();
        return expressionTree;
    }

    public static void main(String[] args) {
        ExpressionTree tree = buildTree("5 2 1 - - 6 5 / +");
        System.out.print("Preorder traverse:");
        tree.preorder();
        System.out.print("\nPostorder traverse:");
        tree.postorder();
        System.out.print("\nInorder traverse:");
        tree.inorder();
        System.out.println();
        System.out.println(tree.size());
        System.out.println(tree.recSize());
        // (((5)-((2)-(1)))+((6)/(5)))
        // ((5-(2-1))+(6/5))
        // 5-(2-1) + 6/5
    }
}
