// Very simple data structure
public class Array <T> implements Iterable<T>{      // this array class supports Generics of type <T>

    // Instance Variables
    private T [] arr;           // internal static array
    private int len = 0;        // length user thinks array is
    private int capacity = 0;   // actual array size

    public Array() { this(16);}     // initialize the array to be size 16

    public Array(int capacity){
        // capacity must be >= 0 otherwise exception is thrown
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];       // initialize array to hold capacity number of elements
    }

    public int size(){ return len;}                     // get size of array
    public boolean isEmpty(){ return size() == 0;}      // check if array is empty

    // should include a bounds check for getter and setter but not included
    public T get(int index) { return arr[index]; }              // get the index of the array
    public void set(int index, T elem){ arr[index] = elem;}     // set the element to the index in array

    public void clear(){
        for(int i = 0; i < capacity; i++)       // goes through each element in array
            arr[i] = null;                      // removes data by setting each element to null
        len = 0;                                // resets the length of array
    }

    public void add(T elem){
        // if the length + 1 is greater than or equal to the capacity then it's time to resize array
        if(len + 1 >= capacity){
            if(capacity == 0) capacity = 1;
            else capacity *= 2;                 // doubles the size of the array

            T[] newArray = (T[]) new Object[capacity];      // new array holds newly doubled capacity
            for(int i = 0; i< len; i++)                     // copies elements from old array to new array
                newArray[i] = arr[i];
            arr = newArray;                 // arr has extra nulls padded
        }
        arr[len++] = elem;                  // copies new values into array
    }

    public T removeAt(int rmIndex){         // removes the element at the specific index in this list
        // checks if index is valid
        if(rmIndex >= len && rmIndex < 0) throw new IndexOutOfBoundsException();
        // set the index being removed to data
        T data = arr[rmIndex];
        // initialize new array with 1 less element
        T[] newArray = (T[]) new Object[len-1];

        for(int i = 0, j = 0; i < len; i++, j++)
            if(i == rmIndex) j--;           // skips over rmIndex by making j lag behind
            else newArray[j] = arr[i];      // copies everything into new array
        arr = newArray;                     // set copied array to be new array
        capacity = --len;                   // reset capacity
        return data;                        // return removed data
    }

    public boolean remove(Object obj){
        // scan through array to look for the object being removed
        for(int i = 0; i < len; i++){
            if (arr[i].equals(obj)){        // if object is found
                removeAt(i);                // remove object at given index
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        // scan through array to look for the index of object
        for(int i = 0; i < len; i++){
            if(arr[i].equals(obj))          // if object is found
                return i;                   // return index of newly found element
        }
        return -1;                          // return -1 if element not found
    }

    public boolean contains(Object obj){
        // checks if indexOf is not equal to -1
        return indexOf(obj) != -1;
    }

    @Override public java.util.Iterator<T> iterator(){
        // allows iteration over the array while providing abstraction for the array
        return new java.util.Iterator <T> (){
            int index = 0;
            // if index < len of array then next element exists
            public boolean hasNext(){ return index < len; }
            // returns the next element in the array relative to the iterator
            public T next() {return arr[index++]; }
        };
    }

    @Override public String toString(){
        // used to get a string representation of the array
        if(len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder( len ).append("[");
            for (int i = 0; i < len-1; i++)
                sb.append(arr[i] + ", ");
            return sb.append(arr[len-1] + "]").toString();
        }
    }


























}
