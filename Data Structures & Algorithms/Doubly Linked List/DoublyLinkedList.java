import org.w3c.dom.Node;

public class DoublyLinkedList <T> implements Iterable <T>{
    // declared instance variables
    private int size = 0;           // size of linked list
    private Node <T> head = null;   // set head to null
    private Node <T> tail = null;   // set tail to null
    // linked list is empty

    private class Node<T> {
        T data;
        Node<T> prev, next;
        // constructor for Node
        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override public String toString(){
            return data.toString();
        }
    }

























}
