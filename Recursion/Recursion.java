public class Recursion {
    private int count = 0;
    /** Recursive function that computes the number of "22" substrings in the string. 
        The "22" substrings should not overlap.
        @param str String that will be checked for "22" instances
        @return total amount of "22" instances (no overlaps)*/
    int count22NoOverlap(String str) {
        if (str.length() == 1)
            return count;
        else {
            if (str.substring(0, 2).equals("22")) {
                count++;
                if (str.length() == 2)
                    return count;
                else
                    return count22NoOverlap(str.substring(2));
            }
            else
                return count22NoOverlap(str.substring(1));
        }
    }

    /** Recursive function that computes the number of "22" substrings in the string. 
        The "22" substrings can overlap.
        @param str String that will be checked for "22" instances
        @return total amount of "22" instances (overlaps OK)*/
    int count22Overlap(String str){
        if (str.length() == 1)
            return count;
        else {
            if (str.substring(0, 2).equals("22")) 
                count++;
            return count22Overlap(str.substring(1));
        }
    }

    /** Recursive function that computes the number of consecutive elements that increase 
        or decrease by a factor of 10.
        @param array array that is checked for instances of increase/decrease by factor of 10
        @param value int that keeps track of the index of the array
        @return int of total amount of instances where there is a number that increases/decreases by 
        a factor of 10*/
    int factorsOf10(int[] array, int value){
        if (value == array.length - 1)
            return count;
        else if (array[value] * 10 == array[value + 1] || array[value] / 10 == array[value + 1])
            count++;
        return factorsOf10(array, ++value);
    }

    /** Recursive function that checks whether a mathematical expression has balanced parenthesis
        @param string String that holds the mathematical expression
        @param stack stack that helps with keeping track of balanced parenthesis
        @return boolean that determines whether the parenthesis are balanced*/
    boolean endParenthesisFalse = false;
    boolean balancedParens(String string, ArrayStack stack) {
        if (string.length() != 0) {         
            char currentChar = string.charAt(0);
            if (currentChar != '(' && currentChar != ')')
                balancedParens(string.substring(1), stack);
        
            if (currentChar == '(') {
                stack.push(currentChar);
                balancedParens(string.substring(1), stack);
            }
            if (currentChar == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    balancedParens(string.substring(1), stack);
                }
                else {
                    endParenthesisFalse = true;
                }
            }   
        }  
        if (!stack.isEmpty())
            return false;
        else if (endParenthesisFalse)
            return false;
        else 
            return true;
    }

    /** Recursive function that reverses the order of an array
        @param array array that will be reversed
        @param index1 int that keeps track of the index of the array
        @param index2 int that keeps track of another index of the array
        @return an array that is reversed*/
    void reverseArray(Object[] array, int index1, int index2){
        if (index1 > index2)
            return;
        Object tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
        reverseArray(array, ++index1, --index2);
    }

    /** Helper function that resets global variables used to help
        with some methods*/
    void reset() {
        count = 0;
        endParenthesisFalse = false;
    }
}
