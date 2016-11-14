package polyu.comp.datastructure.assign2;

/**
 * Created by huanganna on 10/16/16.
 */
public class CustomerQueue {
    private CustomerList customerList;

    public CustomerQueue(){
        customerList = new CustomerList();
    }

    public String toString(){
        return customerList.toString();
    }

    public void enqueue(String name){
        customerList.insertAtEnd(name);
    }

    public String dequeue(){
        return customerList.deleteFirst();
    }

    public boolean isEmpty(){
        return customerList.isEmpty();
    }

    public CustomerQueue[] split(int k){
        int i = 0;
        CustomerNode cur = customerList.getHead();
        CustomerQueue[] queues = new CustomerQueue[k];
        while (cur!=null){
            int index = i%k;
            if(queues[index]==null)
                queues[index] = new CustomerQueue();
            queues[index].enqueue(cur.name);
            cur = cur.next;
            i++;
        }
        return queues;
    }

    public static void main(String[] args) {
        CustomerQueue customerQueue = new CustomerQueue();
        for(int i=0;i<5;i++)
            customerQueue.enqueue("aa"+i);
        System.out.println(customerQueue);
        CustomerQueue[] result = customerQueue.split(5);
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
    }

}
