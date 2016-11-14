package polyu.comp.datastructure;

/**
 * Created by huanganna on 10/28/16.
 */

class DNode {
    int data;
    DNode previous, next;

    DNode(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}

public class DList {
    private DNode head; // firstNode
    private DNode tail; // lastNode

    public DList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtFront(int e) {
        DNode newNode = new DNode(e);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.previous = newNode;
        head = newNode;

    }

    public void insertAtEnd(int e) {
        if(head == tail){
            insertAtFront(e);
        }else{
            DNode newNode = new DNode(e);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public int deleteFirst() {
        if(isEmpty()){
            System.out.println("The list is empty");
            return -1;
        }
        int deletedValue = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }else{
            head.previous = null;
        }
        return deletedValue;
    }

    public int deleteLast() {
        if(head == tail){
            return deleteFirst();
        }
        int deletedValue = tail.data;
        tail = tail.previous;
        tail.next = null;
        return deletedValue;
    }

    public String toString(){
        String result = "";
        DNode cur = head;
        while(cur!=null){
            result +=cur.data;
            cur = cur.next;
            if(cur!=null)
                result +=",";
        }
        return result;
    }

    public static void main(String[] args) {
        DList list = new DList();
        list.insertAtFront(1);
        System.out.println(list);
        list.insertAtFront(2);
        System.out.println(list);
        list.deleteFirst();
        System.out.println(list);
        list.deleteLast();
        System.out.println(list);
    }

}
