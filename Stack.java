import java.util.Arrays;

class Stack<T>  {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] store;
    private int size = 0;
    private int capacity;


    public Stack() {
        this.capacity = DEFAULT_CAPACITY;
        store = (T[]) new Object[DEFAULT_CAPACITY];
    }


    public Stack(int capacity) {
        this.capacity = capacity;
        store = (T[]) new Object[capacity];
    }


    public boolean push(T value) {
        if (this.size >= store.length) {
            int newSize = size + (size >> 1);
            store = Arrays.copyOf(store, newSize);
        }

        // not only store value in Stack but also
        // increases size of the array, a good use
        // ++ operator which ensures that first
        // you store at current index and than
        // increment size.

        store[size++] = value;
        return true;
    }


    public T pop() {
        if (size <= 0) {
            return null;
        }

        // again first we are reducing size and then getting value
        // from Stack, because size is always 1 more array index
        // because index starts at 0. So if you have just one
        // element in Stack, then valid index is zero but size
        // would be one.
        T value = store[--size];

        // make sure you dereference element at top of the stack
        // to prevent memory leak in Java
        store[size] = null;

        // shrinking array if its too big
        int reducedSize = size;
        if (size >= capacity && size < (reducedSize + (reducedSize << 1))) {
            System.arraycopy(store, 0, store, 0, size);
        }
        return value;
    }


    public boolean contains(T value) {
        // check for an element in array using
        // sequential search algorithm
        boolean found = false;
        for (int i = 0; i < size; i++) {
            T element = store[i];
            if (element.equals(value)) {
                found = true;
            }
        }

        return found;
    }


    public int size() {
        return size;
    }


    public void clear() {
        // make sure you release reference of all
        // element to avoid memory leak in Java
        for (int i = 0; i < size; i++) {
            store[i] = null;
        }
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns String view of Stack, fist element
     * is the top of stack
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(this.pop());

            if (i > 0) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
