
public class Main {
    public static void main(String[] args) {
        String str = "abacdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        long uniqueChars = 0;  // we will use a long to store the unique characters using bitwise masks
        int count = 0;         // counter to keep track of how many unique characters we have found
        int foundIndex=0;      // store the index we find the first 5 continous chars
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            long mask = 1L << (c - 'a');  // create a mask for the current character
            if ((uniqueChars & mask) == 0) {  // check if the character has been seen before
                uniqueChars |= mask;  // mark the character as seen by setting the corresponding bit in the mask
                count++;  // increment the count of unique characters
            }else{
                // duplicated char, reset the count
                count=0;
                uniqueChars=0;
            }
            // we have found the first 5 unique characters
            if (count == 5) {
                foundIndex = i-5;
                break;
            }
        }
        System.out.println("First five unique characters: " + str.substring(foundIndex,foundIndex+5));
    }
}
