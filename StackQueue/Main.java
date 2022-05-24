/*
    Jorge Aranda
    CS 1400.03
    11/1/2020
    Project 2: Data Structures 
*/

public class Main {
    static String testSuccess = "Test was succesful!";
    static String testFailure = "Test was unsucessful!";
    static String pushing = "Pushing value(s): ";
    static String popping = "Popping value(s): ";
    static String sizeOfStack = "Size of stack is: ";
    static String enqueueing = "Enqueueing value(s): ";
    static String dequeueing = "Dequeuing value(s): ";
    static String frontValueStr = "Front value is: ";
    static String backValueStr = "Back value is: ";
    static String sizeOfQueue = "Size of queue is: ";
    static int failures, value, previousPeek, currentPeak, frontValue, backValue;

    public static void main(String[] args) {
        String testStack = "Testing ArrayStack...\n~~~~~~~~~~~~~~~~~~~~~";
        String arrayStackTestResult = "ArrayStack full test result: ";
        System.out.println(testStack);
        ArrayStack stack = new ArrayStack();
        testStackPush(stack);
        testStackPop(stack);
        testStackPeek(stack);
        testStackIsEmpty(stack);
        testStackResize(stack);
        testStackClear(stack);
        finalResult(arrayStackTestResult);
        failures = 0;

        String testQueue = "\nTesting ArrayQueue...\n~~~~~~~~~~~~~~~~~~~~~";
        String arrayQueueTestResult = "ArrayQueue full test result: ";
        System.out.println(testQueue);
        ArrayQueue queue = new ArrayQueue();
        testQueueEnqueue(queue);
        testQueueDequeue(queue);
        testQueueGetFront(queue);
        testQueueIsEmpty(queue);
        testQueueResize(queue);
        testQueueClear(queue);
        finalResult(arrayQueueTestResult);
    }

    /** Conducts a test for the push() method in ArrayStack
        @param stack The ArrayStack object the test is conducted on*/
    public static void testStackPush(ArrayStack stack){
        String pushTest = "Testing push(int newEntry) in ArrayStack... ";
        System.out.println(pushTest);
        value = 1;
        System.out.print(pushing + value + " ");
        stack.push(value);
        previousPeek = stack.peek();
        value = 2;
        System.out.print(value + "\n");
        stack.push(value);
        testResult(stack.peek() == value);
    }

    /** Conducts a test for the pop() method in ArrayStack
        @param stack The ArrayStack object the test is conducted on*/
    public static void testStackPop(ArrayStack stack) {
        String popTest = "\nTesting pop() in ArrayStack... ";
        System.out.println(popTest);      
        System.out.println(popping + stack.pop());
        testResult(previousPeek == stack.peek());
    }

    /** Conducts a test for the peek() method in ArrayStack
        @param stack The ArrayStack object the test is conducted on*/
    public static void testStackPeek(ArrayStack stack) {
        String peekTest = "\nTesting peek() in ArrayStack... ";
        String peeking = "Peeking value: ";
        System.out.println(peekTest);
        int currentPeek = previousPeek = stack.peek();
        System.out.println(peeking + currentPeek);
        System.out.println(pushing + value);
        stack.push(value);
        currentPeek = stack.peek();
        System.out.println(peeking + currentPeek);
        testResult(currentPeek == value && currentPeek != previousPeek);
    }

    /** Conducts a test for the isEmpty() method in ArrayStack
        @param stack The ArrayStack object the test is conducted on*/
    public static void testStackIsEmpty(ArrayStack stack){
        String isEmptyTest = "\nTesting isEmpty() in ArrayStack... ";
        System.out.println(isEmptyTest);
        System.out.println(sizeOfStack + stack.getSizeOfStack());
        if (stack.isEmpty() && stack.getSizeOfStack() > 0) {
            System.out.println(testFailure);
            failures++;
        }
        System.out.println(popping + stack.pop() + " " + stack.pop());
        System.out.println(sizeOfStack + stack.getSizeOfStack());
        testResult(stack.isEmpty() && stack.getSizeOfStack() == 0);
    }

    /** Conducts a test for the resize method in ArrayStack to determine
        if it succesfully resizes array as well as keeps the current order.
        @param stack The ArrayStack object the test is conducted on*/
    public static void testStackResize(ArrayStack stack) {
        String resizeTest = "\nTesting resize() in ArrayStack... ";
        String sizeOfArray = "Size of stack array is: ";
        System.out.println(resizeTest);
        System.out.print(pushing);
        for (int i = 0; i < 10; i++){
            value = i + 1;
            System.out.print(value + " ");
            stack.push(value);
        }
        int currentSizeOfArray = stack.getSizeOfArray();
        System.out.println( "\n" + sizeOfStack + stack.getSizeOfStack());
        System.out.println(sizeOfArray + currentSizeOfArray);
        value = 11;
        System.out.println(pushing + value);
        stack.push(value);
        System.out.println(sizeOfStack + stack.getSizeOfStack());
        System.out.println(sizeOfArray + stack.getSizeOfArray());
        testResult(stack.getSizeOfArray() > currentSizeOfArray);
    }

    /** Conducts a test for the clear() method in ArrayStack
        @param stack The ArrayStack object the test is conducted on*/
    public static void testStackClear(ArrayStack stack){
        String clearTest = "\nTesting clear() in ArrayStack... ";
        String clearing = "Clearing stack";
        System.out.println(clearTest);
        System.out.println(sizeOfStack + stack.getSizeOfStack());
        System.out.println(clearing);
        stack.clear();
        System.out.println(sizeOfStack + stack.getSizeOfStack());
        testResult(stack.getSizeOfStack() == 0);
    }

    /** Conducts a test for the enqueue() method in ArrayQueue
        @param queue The ArrayQueue object the test is conducted on*/
    public static void testQueueEnqueue(ArrayQueue queue){
        String enqueueTest = "Testing enqueue(int newEntry) in ArrayQueue... ";
        System.out.println(enqueueTest);
        frontValue = 1;
        System.out.print(enqueueing + frontValue + " ");
        queue.enqueue(frontValue);
        backValue = 2;
        System.out.print(backValue + "\n");
        queue.enqueue(backValue);
        testResult(queue.getFront() == frontValue && queue.getBack() == backValue);
    }

    /** Conducts a test for the dequeue() method in ArrayQueue
        @param queue The ArrayQueue object the test is conducted on*/
    public static void testQueueDequeue(ArrayQueue queue){
        String dequeueTest = "\nTesting dequeue() in ArrayQueue... ";
        System.out.println(dequeueTest);      
        System.out.println(dequeueing + queue.dequeue());
        testResult(queue.getBack() == queue.getFront());
    }
    
    /** Conducts a test for the getFront() method in ArrayQueue
        @param queue The ArrayQueue object the test is conducted on*/
    public static void testQueueGetFront(ArrayQueue queue){
        String getFrontTest = "\nTesting getFront() in ArrayQueue... ";
        System.out.println(getFrontTest);
        frontValue = queue.getFront();
        System.out.println(frontValueStr + frontValue);
        backValue = 1;
        System.out.println(enqueueing + backValue);
        queue.enqueue(backValue);
        System.out.println(frontValueStr + queue.getFront());
        testResult(frontValue == queue.getFront());
    }

    /** Conducts a test for the isEmpty() method in ArrayQueue
        @param queue The ArrayQueue object the test is conducted on*/
    public static void testQueueIsEmpty(ArrayQueue queue){
        String isEmptyTest = "\nTesting isEmpty() in ArrayQueue... ";
        System.out.println(isEmptyTest);
        System.out.println(sizeOfQueue + queue.getSizeOfQueue());
        if (queue.isEmpty() && queue.getSizeOfQueue() > 0) {
            System.out.println(testFailure);
            failures++;
        }
        System.out.println(dequeueing + queue.dequeue() + " " + queue.dequeue());
        System.out.println(sizeOfQueue + queue.getSizeOfQueue());
        testResult(queue.isEmpty() && queue.getSizeOfQueue() == 0);
    }

    /** Conducts a test for the resize method in ArrayQueue to determine
        if it succesfully resizes array as well as keeps the current order.
        @param queue The ArrayQueue object the test is conducted on*/
    public static void testQueueResize(ArrayQueue queue){
        String resizeTest = "\nTesting resize() in ArrayQueue... ";
        String sizeOfArray = "Size of queue array is: ";
        System.out.println(resizeTest);
        System.out.print(enqueueing);
        for (int i = 0; i < 7; i++){
            backValue = i + 1;
            System.out.print(backValue + " ");
            queue.enqueue(backValue);
        }
        System.out.println("\n" + dequeueing + queue.dequeue() + " " + queue.dequeue());
        System.out.print(enqueueing);
        for(int i = 0; i < 5; i++){
            backValue = i + 1;
            System.out.print(backValue + " ");
            queue.enqueue(backValue);
        }
        System.out.println("\n" + frontValueStr + queue.getFront());
        System.out.println(backValueStr + queue.getBack());
        int currentSizeOfArray = queue.getSizeOfArray();
        System.out.println(sizeOfQueue + queue.getSizeOfQueue());
        System.out.println(sizeOfArray + currentSizeOfArray);
        backValue = 11;
        System.out.println(enqueueing + backValue);
        queue.enqueue(backValue);
        System.out.println(frontValueStr + queue.getFront());
        System.out.println(backValueStr + queue.getBack());
        System.out.println(sizeOfQueue + queue.getSizeOfQueue());
        System.out.println(sizeOfArray + queue.getSizeOfArray());
        testResult(queue.getSizeOfArray() > currentSizeOfArray);
    }

    /** Conducts a test for the clear() method in ArrayQueue
        @param queue The ArrayQueue object the test is conducted on*/
    public static void testQueueClear(ArrayQueue queue){
        String clearTest = "\nTesting clear() in ArrayQueue... ";
        String clearing = "Clearing queue";
        System.out.println(clearTest);
        System.out.println(sizeOfQueue + queue.getSizeOfQueue());
        System.out.println(clearing);
        queue.clear();
        System.out.println(sizeOfQueue + queue.getSizeOfQueue());
        testResult(queue.getSizeOfQueue() == 0);
    }

    /** Determines if specific tests was succesful and outputs result
        as well as increments the failure variable if it was unsuccessful
        @param test A boolean containing the result of the test*/
    public static void testResult(boolean test){
        if (test) 
            System.out.println(testSuccess);       
        else {
            System.out.println(testFailure);
            failures++;
        }
    }

    /** Determines if all tests for given data structure was succesful
        @param test String that contains which data structure was tested*/
    public static void finalResult(String test) {
        if (failures > 0)
            System.out.println("\n" + test + testFailure);
        else
            System.out.println("\n" + test + testSuccess);
    }
}