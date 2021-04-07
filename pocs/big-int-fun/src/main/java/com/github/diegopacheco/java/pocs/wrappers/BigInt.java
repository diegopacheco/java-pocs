package com.github.diegopacheco.java.pocs.wrappers;

public class BigInt implements Comparable<BigInt> {

    private String value;

    public BigInt(String value) {
        this.value = value;
    }

    public boolean isPositive(){
        if (value==null || "".equals(value))
            throw new IllegalStateException("Cant figure out the size yet - no value!");
        String lastDigit = value.charAt(value.length()-1)+"";
        int val = Integer.parseInt(lastDigit);
        return (val>=0);
    }

    public static String add(String x, String y) {
        BigInt result = new BigInt(x);
        result.plus(new BigInt(y));
        return result.getValue();
    }

    public static String subtract(String x, String y) {
        BigInt result = new BigInt(x);
        result.minus(new BigInt(y));
        return result.getValue();
    }

    @Override
    public int compareTo(BigInt x) {
        if (this.length() > x.length())
            return 1;
        if (this.length() < x.length())
            return -1;

        char[] thisChars = this.chars();
        char[] xChars = x.chars();

        for (int i = 0; i < this.length(); i++) {
            int xInt = Character.getNumericValue(xChars[i]);
            int thisInt = Character.getNumericValue(thisChars[i]);

            if (thisInt > xInt) return 1;
            if (thisInt < xInt) return -1;
        }
        return 0;
    }//------------------

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = Integer.toString(value);
    }

    public char[] chars() {
        return this.value.toCharArray();
    }

    public int length() {
        return value.length();
    }

    public BigInt clone() {
        return new BigInt(this.getValue());
    }

    public BigInt plus(BigInt x) {
        String[] xy = equalLengths(x, this);
        char[] xChars = xy[0].toCharArray();
        char[] yChars = xy[1].toCharArray();

        int overflow = 0; //number being carried over when sum goes over 10

        StringBuilder solution = new StringBuilder();
        for (int i = xChars.length - 1; i >= 0; i--) {
            int xInt = Character.getNumericValue(xChars[i]);
            int yInt = Character.getNumericValue(yChars[i]);
            int digitSum = xInt + yInt + overflow;

            solution.append(digitSum % 10);
            overflow = digitSum / 10;
        }
        //append the number if overlow is nonzero (it can only be 1 or 0)
        //then reverse the string builder because they are added backwards
        this.value = (overflow == 0 ? "" : "1") + solution.reverse().toString();

        return this;
    }

    //this.value -= x.value
    public BigInt minus(BigInt x) {
        int thisGThanX = this.compareTo(x);
        if (thisGThanX == 0)//numbers are equal, difference is zero
            this.setValue("0");
        else if (thisGThanX < 0)//diff would be negative
            this.setValue("ERROR, negative not implemented");//TODO: implement negatives
        else {   //x and 'this' values in an array
            String[] xThis = equalLengths(x, this);
            char[] xChars = xThis[0].toCharArray();
            char[] thisChars = xThis[1].toCharArray();

            int overflow = 0;
            StringBuilder difference = new StringBuilder();
            for (int i = xChars.length - 1; i >= 0; i--)//subtraction happens in reverse order
            {
                int xInt = Character.getNumericValue(xChars[i]);
                int thisInt = Character.getNumericValue(thisChars[i]) + overflow;
                overflow = 0;//either 0 or -1, -1 when you need to take a 1 from the next 10s place up

                if (thisInt < xInt)//when you cant subtract, take from next highest digit
                {
                    overflow = -1;
                    thisInt += 10;
                }
                //we know that with the overflow added, we will always be able to subtract
                difference.append(thisInt - xInt);
            }
            //trim zeroes
            //note the string builder is in reverse order, so leading zeroes are now at the end
            while (difference.charAt(difference.length() - 1) == '0')
                difference.deleteCharAt(difference.length() - 1);

            this.setValue(difference.reverse().toString());
        }
        return this;
    }

    private static String[] equalLengths(BigInt x, BigInt y){
        String yVal = y.getValue();
        String xVal = x.getValue();

        if(x.length() > y.length())
            yVal =  "0".repeat(x.length() - y.length()) + y.getValue();
        else if (x.length() < y.length())
            xVal = "0".repeat(y.length() - x.length()) + x.getValue();

        return new String[] {xVal,yVal};
    }

    @Override
    public String toString() {
        return this.value;
    }
}