package polyu.comp.datastructure.assign2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListOnArray {
	private int[] data;
	private static final int DEFAULTSIZE = 10;

	public ListOnArray(){
		this(DEFAULTSIZE);
	}

	public ListOnArray (int size) {
		data = new int[2*(size+1)];
		data[0] = 0;
		for(int i=0;i<size-1;i++){
			data[2*i+2] = 2*i + 3;
		}
		data[2*size] = 0;
		data[2*size +1] = 1;
	}
	
	public boolean isEmpty() {
		return data[0] == 0;
	}

	public boolean isFull(){
		return data[data.length-1] == 0;
	}

	private int getEmptyListHead(){
		return data[data.length-1];
	}

	private void setEmptyListHead(int head){
		data[data.length-1] = head;
	}

	private void setListHead(int head){
		data[0] = head;
	}

	private int getListHead(){
		return data[0];
	}
	
	public void insertAtFront(int x) {
		if(isFull()){
			System.out.println("The list is full");
			return;
		}
		int pos = getEmptyListHead();
		data[pos] = x;
		setEmptyListHead(data[pos + 1]);
		data[pos+1] = getListHead();
		setListHead(pos);
		
	}
	
	public void insertAtTail(int x) {
		if(isFull()){
			System.out.println("The list is full");
			return;
		}
		if(isEmpty()){
			insertAtFront(x);
			return;
		}
		int pos = getEmptyListHead();
		data[pos] = x;
		setEmptyListHead(data[pos+1]);
		data[pos+1] = 0;
		int cur = getListHead();
		while (data[cur+1]!=0){
			cur = data[cur+1];
		}
		data[cur+1] = pos;
	}
	
	public int deleteFront() {
		if(isEmpty()){
			System.out.println("The list is empty!");
			return -1;
		}
		int head = getListHead();
		int result = data[head];
		data[0] = data[head+1];
		data[head+1] = getEmptyListHead();
		data[data.length-1] = head;
		return result;
	}
	
	public int deleteTail() {
		int cur = getListHead();
		if(cur==0||data[cur+1] ==0 )
			return deleteFront();
		int next = data[cur+1];
		while (data[next+1]!=0){
			cur = next;
			next = data[next+1];
		}
		int result = data[next];
		data[next+1] = getEmptyListHead();
		data[data.length-1] = next;
		data[cur+1] = 0;
		return result;
	}

	//todo
	public int delete(int x) {
		if(isEmpty()){
			System.out.println("The list is empty!");
			return -1;
		}
		int cur = getListHead();
		if(data[cur] == x)
			return deleteFront();
		int next = data[cur+1];
		while (next!=0&&data[next]!=x){
			cur = next;
			next = data[next+1];
		}
		if(next == 0){
			System.out.println("element x does not exit");
			return -1;
		}
		int result = data[next];
		data[cur+1] = data[next+1];
		data[next+1] = getEmptyListHead();
		data[data.length-1] = next;
		return result;
	}

	// this method should print out the numbers in the list in order
	// for example, after the demonstration, it should be "75, 99, 38, 69, 87"
	public String toString() {
		String result = "";
		int cur = getListHead();
		while (cur!=0){
			result += data[cur];
			cur = data[cur+1];
			if(cur!=0)
				result += ",";
		}
		return result;
	}
	
	public static void main(String[] args) {
		// A good idea is to print out the content of the array after each step.
		// System.out.println( Arrays.stream(list.data).mapToObj(Integer::toString).collect(Collectors.joining(", ")) );
		// WARNING: this output should be different from the toString method.
		ListOnArray list = new ListOnArray();
		list.insertAtFront(75);
		list.insertAtTail(99);
		list.insertAtTail(85);
		list.insertAtTail(38);
		list.insertAtTail(49);
		list.insertAtTail(69);
		list.delete(85);
		list.delete(49);
		list.insertAtTail(87);
		System.out.println(list);
	}
}