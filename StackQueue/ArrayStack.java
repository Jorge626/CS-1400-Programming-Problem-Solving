public class ArrayStack {
    private int[] store;
    private int topOfStack = -1;

    //  Default constructor assigns the array 'store' with size 10
    ArrayStack() { this.store = new int[10]; }

    /** Constructor with an array as the parameter. Sets
        that array as the array 'store'
        @param store An array to be used as the stack*/   
    ArrayStack(int[] store) { 
        this.store = store;
        for (int i = 0; i < store.length; i++){
            if (store[i] == 0){
                topOfStack = i - 1; 
                break;
            }
            if (i == store.length - 1)
                topOfStack = store.length -1;
        }
    }
    
    /** Constructor with an int as the parameter. Sets
        the array 'store' with a size of the given int value
        @param storeSize An int that will be used to set size of stack*/
    ArrayStack(int storeSize) { this.store = new int[storeSize]; }

    /** Adds an int 'newEntry' to the top of the stack
        @param newEntry An int that will be added to the stack*/
    public void push(int newEntry){
        topOfStack++;
        if (topOfStack == store.length){
            resize();
            store[topOfStack] = newEntry;
        }
        else
            store[topOfStack] = newEntry;
    }
    
    /** Removes and returns the top entry at the top of the stack
        @return The int at the top of the stack
        @throws EmptyStackException if the stack is empty before method call*/
    public int pop(){
        if (topOfStack == -1) {
            throw new EmptyStackException();
        }
        topOfStack--;
        return store[topOfStack + 1];
    }
    
    /** Returns the int at the top of the stack
        @return The int at the top of the stack
        @throws EmptyStackException if the stack is empty.*/
    public int peek(){
        if (topOfStack == -1) {
            throw new EmptyStackException();
        }
        return store[topOfStack];
    }

    /** Checks to see if the stack is empty 
        @return True if the stack is empty*/
    public boolean isEmpty(){
        return (topOfStack == -1);
    }

    // Removes all entries from the stack
    public void clear(){
        for (int i = topOfStack; i > -1; i--){
            store[i] = 0;
        }
        topOfStack = -1;
    }

    /** Returns the current size of the store array.
        @return Length of the current 'store' array*/
    public int getSizeOfArray() {
        return store.length;
    }

    /** Returns the current size of the stack array.
        @return Int that is the total amount of values store in stack*/
    public int getSizeOfStack() {
        return topOfStack + 1;
    }

    // Resizes the array. Doubles the array size
    private void resize() {
        int[] newStack = new int[store.length * 2];
        for (int i = 0; i < store.length; i++)
            newStack[i] = store[i];
        this.store = newStack;
    }
}
