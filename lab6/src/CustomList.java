import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomList<T> {
    private class Node {
        public T value;
        public Node next;
        public Node(T value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    public CustomList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    private boolean isEmpty(){
        return this.head == null && this.tail == null;
    }
    public void addLast(T item){
            Node node = new Node(item, null);
            if(isEmpty()){
                this.head = node;
            }
            else{
                this.tail.next = node;
            }
            this.tail = node;
    }
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return this.tail.value;
    }
    public void addFirst(T item){
        Node node = new Node(item, this.head);
        if(isEmpty()){
            this.tail = node;
        }
        this.head = node;
    }
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return this.head.value;
    }
    public T removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node removedNode = this.head;
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
            return removedNode.value;
        }
        this.head = removedNode.next;
        return removedNode.value;
    }
    public T removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }
        Node it = this.head;
        while(it.next != tail){
            it = it.next;
        }
        Node removedNode = this.tail;
        it.next = null;
        this.tail = it;
        return removedNode.value;
    }
    @Override
    public String toString(){
        String str = " ";
        Node it = this.head;
        while(it.next != null){
            str += it.value + " ";
        }
        return str;
    }
}
