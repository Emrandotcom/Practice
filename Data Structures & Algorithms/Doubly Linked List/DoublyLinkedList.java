import org.w3c.dom.Node;

public class DoublyLinkedList <T> implements Iterable <T>{
    // declared instance variables
    private int size = 0;           // size of linked list
    private Node <T> head = null;   // set head to null
    private Node <T> tail = null;   // set tail to null
    // linked list is empty

    private class Node<T> {     // internal node class to represent data
        T data;                 // data for nodes
        Node<T> prev, next;     // previous and next pointers
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
    // empty the linked list, method does so in linear time O(n)
    public void clear(){
        Node<T> trav = head;                // start traverser at the head
        while(trav != null){                // while there are elements in the list
            Node<T> next = trav.next;
            trav.prev = trav.next = null;   // deallocates by setting element to null
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;          // reset head and tail
        size = 0;                           // reset size
    }

    public int size(){ return size; }                  // returns size of list

    public boolean isEmpty(){ return size() == 0; }    // returns true if size of list is empty

    public void add(T elem){ addLast(elem); }          // add an element to the tail of the list O(1)

    public void addFirst(T elem){                      // add an element to the beginning of the list O(1)

        if(isEmpty()){                                                  // if list is empty:
            head = tail = new Node<T> ( elem, null, null);    // head & tail = new node with both pointers set to null
        } else{                                                         // if list is not empty:
            head.prev = new Node<T> (elem, null, head);            // head's previous pointer = newly created node
            head = head.prev;                                           // move pointer back to beginning of list
        }
        size++;         // increment size of linked list
    }

    public void addLast(T elem){                        // add an element to the beginning of the list O(1)
        if(isEmpty()){                                                  // if list is empty:
            head = tail = new Node<T> ( elem, null, null);    // head & tail = new node with both pointers set to null
        } else{                                                         // if list is not empty:
            tail.next = new Node<T> (elem, tail, null);            // tail's previous pointer = newly created node
            tail = tail.next;                                           // move pointer to the end of list
        }
        size++;         // increment size of linked list
    }

    public T peekFirst(){                                           // looking at the element in beginning of list
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast(){                                            // looking at the element in end of list
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T removeFirst(){                                         // remove first value at the head of linked list O(1)
        if(isEmpty()) throw new RuntimeException("Empty List");
        T data = head.data;                                         // extract data at head
        head = head.next;                                           // move head pointer forward one node
        -- size;                                                    // decrease size of list by 1

        if(isEmpty()) tail = null;                                  // if list is empty set tail to null now head & tail are null
        else head.prev = null;

    }






































}
