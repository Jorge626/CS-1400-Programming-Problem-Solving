public class ArrayQueue {
    private int back = -1, front = -1, size = 0;
    private int[] store;

    // Default constructor assigns the array 'store' with size 10
    ArrayQueue() { this.store = new int[10]; }

    /** Constructor with an array as the parameter. Sets
        that array as the array 'store'
        @param store An array that will be set as the current queue*/   
    ArrayQueue(int[] store) { 
        this.store = store;
        for (int i = 0; i < store.length; i++){
            if (store[i] == 0){
                back = i - 1; 
                break;
            }
            if (i == store.length - 1)
                back = store.length - 1;
        }
        front = 0;
        size = back + 1;
    }
    
    /** Constructor with an int as the parameter. Sets
        the array 'store' with a size of the given int value
        @param storeSize An int that will set the size of the queue*/
    ArrayQueue(int storeSize) { this.store = new int[storeSize]; }

    /** Adds a new entry to the back of the queue
        @param newEntry An int that will be added to the queue */
    public void enqueue(int newEntry){
        if (size == 0){
            size++;
            front++;
            back++;
            store[front] = newEntry;
        }
        else if ((back + 1) % store.length == front){
            resize();
            back = (back + 1) % store.length;
            store[back] = newEntry;
            size++;
        }
        else {
            back = (back + 1) % store.length;
            store[back] = newEntry;
            size++;
        }
    }
    
    /** Removes and returns the entry at the front of the queue
        @return The int at the front of the queue
        @throws EmptyQueueException if the queue is empty before the method call */
    public int dequeue() {
        if (size == 0)
            throw new EmptyQueueException();
        else {
            if (back == front){
                int entry = store[front];
                back--;
                front--;
                size--;
                return entry;
            }
            else {
                int entry = store[front];
                front = (front + 1) % store.length;
                size--;
                return entry;
            }
        }
    }

    /** Returns the entry at the front of the queue 
        @return Entry at the front of the queue
        @throws EmptyQueueException if the queue is empty before method call*/
    public int getFront() {
        if (front == -1 && back == -1)
            throw new EmptyQueueException();
        return store[front];
    }

    /** Checks to see if the queue is empty
        @return True if the queue is empty*/
    public boolean isEmpty() {
        return (size == 0);
    }

    // Removes all entries from the queue
    public void clear(){
        for (int i = 0; i < store.length; i++)
            store[i] = 0;
        front = -1;
        back = -1;
        size = 0;
    }

    public int getBack() {
        if (front == -1 && back == -1)
            throw new EmptyQueueException();
        return store[back];
    }

     /** Returns the current size of the store array.
        @return Length of the current store*/
        public int getSizeOfArray() {
            return store.length;
        }
    
        public int getSizeOfQueue() {
            return size;
        }

    // Resizes the array. Doubles the array size
    private void resize() {
        int[] newStack = new int[store.length * 2];
        int index = -1;
        for (int i = front; i < store.length; i++){ 
            newStack[++index] = store[i];       
        }
        for (int i = 0; i < back + 1; i++){
            newStack[++index] = store[i];
        }
        front = 0;
        back = store.length - 1;
        this.store = newStack;
    }
}