package com.github.diegopacheco.fp;

/**
 * Pure Functions
 *
 * A pure function is a function where the return value is only determined by
 * its input values, without observable side effects.
 * So same input will always return same output.
 * 100% predictable and reliable (different from LLMs that cannot produce same output consistently).
 *
 * validateCreditCard uses: Luhn algorithm to validate credit card numbers.
 */
public class PureFunctions {

    public boolean validateCreditCard(String cardNumber) {
        int sum =0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int digit = Character.getNumericValue(cardNumber.charAt(cardNumber.length() - 1 - i));
            if (i % 2 == 1) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }
        return sum % 10 == 0;
    }

}
