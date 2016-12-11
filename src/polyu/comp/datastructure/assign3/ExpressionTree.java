package polyu.comp.datastructure.assign3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huanganna on 11/16/16.
 */
class TreeNode {
    String data;
    TreeNode leftChild;
    TreeNode rightChild;
    public String toString() {
        return data;
    }
    public TreeNode(String string){
        data = string;
        leftChild = rightChild = null;
    }

}

public class ExpressionTree {
    public ExpressionTree(){
        root = null;
    }

    public TreeNode root;

    //1 >
    //0 ==
    //-1 <
    public int priorityCompare(String op1,String op2){
        if(op1.equals("+") || op1.equals("-")){
            return op2.equals("*")||op2.equals("/")?-1:0;
        }
        if(op1.equals("*")||op1.equals("/")){
            return op2.equals("+")||op2.equals("-")?1:0;
        }
        return 1;
    }

    public void inorder() {inorder(root);}
    public void inorder(TreeNode r) {
        if(r!=null){
            boolean leftChildBraces = false;
            boolean rightChildBraces = false;
            if(r.leftChild!=null && priorityCompare(r.leftChild.data,r.data) == -1)
                leftChildBraces = true;
            if(r.rightChild!=null && priorityCompare(r.rightChild.data,r.data) != 1)
                rightChildBraces = true;
            if(leftChildBraces)
                System.out.print("(");
            inorder(r.leftChild);
            if(leftChildBraces)
                System.out.print(")");
            System.out.print(r.data);
            if(rightChildBraces)
                System.out.print("(");
                inorder(r.rightChild);
            if(rightChildBraces)
                System.out.print(")");
        }
    }

    public void preorder() {preorder(root);}
    public void preorder(TreeNode r) {
        if(r!=null){
            System.out.print(r.data);
            preorder(r.leftChild);
            preorder(r.rightChild);
        }
    }

    public void postorder() {postorder(root);}
    public void postorder(TreeNode r) {
        if(r!=null){
            postorder(r.leftChild);
            postorder(r.rightChild);
            System.out.print(r.data);
        }
    }

    //iteration
    public int size() {
        if(root == null){
            return 0;
        }
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if(cur.leftChild != null){
                queue.add(cur.leftChild);
                count++;
            }
            if(cur.rightChild != null){
                queue.add(cur.rightChild);
                count++;
            }
        }
        return count;
    }

    //recursion
    public int recSize() { return recSize(root); }
    public int recSize(TreeNode node) {
        if(node == null)
            return 0;
        return recSize(node.leftChild) + recSize(node.rightChild) + 1;
    }
}