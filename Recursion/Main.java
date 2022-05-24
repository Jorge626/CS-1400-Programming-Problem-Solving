/*
    Jorge Aranda
    CS 1400.03
    12/4/2020
    Project 3: Recursion
*/

public class Main {
    public static void main(String[] args) {
        String testCount22NO = "Testing count22NoOverlap...\n";
        String testCount22O = "Testing count22Overlap...\n";
        String testFactors10 = "Testing factorsOf10...\n";
        String testBalPar = "Testing balancedParens...\n";
        String testRevArr = "Testing reverseArray...\n";
        Recursion recursiveObject = new Recursion();

        System.out.print(testCount22NO);
        testCount22NO(recursiveObject);
        
        System.out.print(testCount22O);
        testCount22O(recursiveObject);
        
        System.out.print(testFactors10);
        testFactors10(recursiveObject);

        System.out.print(testBalPar);
        testBalPar(recursiveObject);

        System.out.print(testRevArr);
        testRevArr(recursiveObject);
    }

    static String testSuccess = "Test was succesful!\n";
    static String testFailure = "Test was unsucessful!\n";
    static int fails = 0;
    static String ex1TestCount = "22abc22";
    static String ex2TestCount = "abc22x22x22";
    static String ex3TestCount = "222";

    /** Test method for count22NoOverlap method
        @param obj Recursion object used to perform method*/
    public static void testCount22NO(Recursion obj) {
        if (obj.count22NoOverlap(ex1TestCount) != 2)
            fails++;
        obj.reset();
        if (obj.count22NoOverlap(ex2TestCount) != 3)
            fails++;
        obj.reset();
        if (obj.count22NoOverlap(ex3TestCount) != 1)
            fails++;
        obj.reset();

        if (fails > 0)
            System.out.println(testFailure);
        else 
            System.out.println(testSuccess);
        fails = 0;
    }

    /** Test method for count22Overlap method
        @param obj Recursion object used to perform method*/
    public static void testCount22O(Recursion obj) {
        String ex4TestCount = "abc222222";

        if (obj.count22Overlap(ex1TestCount) != 2)
            fails++;
        obj.reset();
        if (obj.count22Overlap(ex2TestCount) != 3)
            fails++;
        obj.reset();
        if (obj.count22Overlap(ex3TestCount) != 2)
            fails++;
        obj.reset();
        if (obj.count22Overlap(ex4TestCount) != 5)
            fails++;
        obj.reset();

        if (fails > 0)
            System.out.println(testFailure);
        else 
            System.out.println(testSuccess);
        fails = 0;
    }

    /** Test method for factorsOf10 method
        @param obj Recursion object used to perform method*/
    public static void testFactors10(Recursion obj) {
        int[] ex1 = {1, 10, 20};
        if (obj.factorsOf10(ex1, 0) != 1)
            fails++;
        obj.reset();

        int[] ex2 = {100, 10, 20, 200};
        if (obj.factorsOf10(ex2, 0) != 2)
            fails++;
        obj.reset();
        
        int[] ex3 = {1000, 100, 10, 1, 10};
        if (obj.factorsOf10(ex3, 0) != 4)
            fails++;
        obj.reset();
        
        int[] ex4 = {10, 20, 33, 340};
        if (obj.factorsOf10(ex4, 0) != 0)
            fails++;
        obj.reset();

        if (fails > 0)
            System.out.println(testFailure);
        else 
            System.out.println(testSuccess);
        fails = 0;
    }

    /** Test method for balancedParens method
        @param obj Recursion object used to perform method*/
    public static void testBalPar(Recursion obj) {
        ArrayStack stack = new ArrayStack();
        String ex1 = "(a+b) * c";
        String ex2 = "c";
        String ex3 = "((a+b) * c)";
        String ex4 = "(a+b) * c)";
        String ex5 = "(a+b * c";

        if (!obj.balancedParens(ex1, stack))
            fails++;
        stack.clear();

        if (!obj.balancedParens(ex2, stack))
            fails++;
        stack.clear();

        if (!obj.balancedParens(ex3, stack))
            fails++;
        stack.clear();

        if (obj.balancedParens(ex4, stack))
            fails++;
        stack.clear();

        if (obj.balancedParens(ex5, stack))
            fails++;
        stack.clear();

        if (fails > 0)
            System.out.println(testFailure);
        else 
            System.out.println(testSuccess);
        fails = 0;
    }

    /** Test method for reverseArray method
        @param obj Recursion object used to perform method*/
    public static void testRevArr(Recursion obj) {
        Object[] array = {1, 'a', 3, 'b', 5};
        Object[] reversedArray = {5, 'b', 3, 'a', 1};
        
        boolean notEqual = false;
        obj.reverseArray(array, 0, 4);
        for (int i = 0; i < array.length; i++){
            if (array[i] != reversedArray[i])
                notEqual = true;
        }

        Object[] array2 = {10, 'A', 20, 'B', 30, 'C'};
        Object[] reversedArray2 = {'C', 30, 'B', 20, 'A', 10};

        obj.reverseArray(array2, 0, 5);
        for (int i = 0; i < array2.length; i++){
            if (array2[i] != reversedArray2[i])
                notEqual = true;
        }
        if (notEqual)
            System.out.println(testFailure);
        else 
            System.out.println(testSuccess);
    }
}