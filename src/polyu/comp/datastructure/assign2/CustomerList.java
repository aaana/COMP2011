package polyu.comp.datastructure.assign2;

/**
 * Created by huanganna on 10/10/16.
 */
public class CustomerList {
    private CustomerNode head;
    private CustomerNode tail;

    public CustomerList(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public CustomerNode getHead() {
        return head;
    }

    public CustomerNode getTail() {
        return tail;
    }

    public CustomerNode locate(int i){
        if(i<1)
            return null;
        CustomerNode cur = head;
        int k = 1;
        while (cur!=null && k<i){
            cur = cur.next;
            k++;
        }
        return cur;
    }

    public boolean insertAtFront(String name){
        head = new CustomerNode(name,head);
        if(tail == null)
            tail = head;
        return true;
    }

    public boolean insertAtEnd(String name){
        if(head == null){
            insertAtFront(name);
        }else{
            tail.next = new CustomerNode(name);
            tail = tail.next;
        }
        return true;
    }

    public String deleteFirst(){
        if(head == null){
            System.out.println("The list is empty");
            return null;
        }
        String result = head.name;
        head = head.next;
        if(head == null)
            tail = null;
        return result;
    }

    public String deleteLast(){
        if(head == tail)
            return deleteFirst();
        CustomerNode cur = head;
        String result;
        while(cur.next != tail){
            cur = cur.next;
        }
        result = tail.name;
        tail = cur;
        tail.next = null;
        return result;
    }

    public CustomerNode search(String name){
        CustomerNode cur = head;
        while (cur!=null && !cur.name.equals(name)){
            cur = cur.next;
        }
        return cur;
    }

    public boolean insertAfterNodeI(int i,String name){
        if(i == 0){
            return insertAtFront(name);
        }else{
            CustomerNode temp = locate(i);
            if(temp == null)
                return false;
            temp.next = new CustomerNode(name,temp.next);
            return true;
        }
    }

    public String deleteNodeI(int i){
        if(i == 1)
            return deleteFirst();
        CustomerNode nodeToBeDeleted = locate(i);
        if(nodeToBeDeleted == null){
            System.out.println("i is too large");
            return null;
        }
        CustomerNode prev = locate(i - 1);
        String result = nodeToBeDeleted.name;
        prev.next = nodeToBeDeleted.next;
        nodeToBeDeleted = null;
        return result;
    }

    public void reverse(){
        if(head == tail)
            return;
        CustomerNode firstNode,secondNode,remainingNode;
        firstNode = head;secondNode = head.next;remainingNode = secondNode.next;
        head.next = null;
        while (remainingNode!=null){
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = remainingNode;
            remainingNode = remainingNode.next;
        }
        secondNode.next = firstNode;
        tail = head;
        head = secondNode;
    }

    public CustomerList copyReverse(){
        CustomerNode cur = head;
        CustomerList reverseList = new CustomerList();
        while(cur!=null){
            reverseList.insertAtFront(cur.name);
            cur = cur.next;
        }
        return reverseList;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        CustomerNode cur = head;
        while(cur != null) {
            sb.append(cur.name);
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        CustomerList customerList = new CustomerList();
//        customerList.insertAtEnd("Anna");
//        customerList.insertAtEnd("Annie");
//        customerList.insertAtEnd("Anson");
//        System.out.println(customerList);
//        customerList.reverse();
//        System.out.println(customerList);
        CustomerList list = new CustomerList();
        list.insertAtFront("Eason Chan");
        list.insertAtFront("Jacky Cheung");
        list.insertAtFront("Leung Chun-ying");
        System.out.println(list);
        list.insertAtFront("Jennifer Lawrence");
        System.out.println(list);
        list.insertAtEnd("John Tsang");
        System.out.println(list);
        list.reverse();
        System.out.println("reversed: " + list + "\n");
        list.reverse();
        System.out.println("reversed again: " + list + "\n");
        System.out.println("delete the first, which is " + list.deleteFirst());
        System.out.println(list);
        System.out.println("delete the last, which is " + list.deleteLast());
        System.out.println(list);
    }
}
