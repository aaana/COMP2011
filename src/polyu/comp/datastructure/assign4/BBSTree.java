package polyu.comp.datastructure.assign4;

/**
 * Created by huanganna on 12/7/16.
 */
class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(int data){
        this.data = data;
        leftChild = rightChild = null;
    }

}
public class BBSTree {

    public static TreeNode sortedArrToBBST(int[]array,int left,int right){
        if(left>right)
            return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.leftChild = sortedArrToBBST(array,left,mid-1);
        root.rightChild = sortedArrToBBST(array,mid+1,right);
        return root;
    }
}
