package com.github.diegopacheco.oop.antipatterns.magicnumbers;

/**
 * Magic Numbers Antipattern
 *
 * This class demonstrates the Magic Numbers antipattern where numeric literals are used directly in the code.
 * It is better to use relational algebra or type systems or proper object subtypes to improve readability and maintainability.
 */
public class MagicNumbers {

    // Provider
    class AuthService{
        public boolean login(int userType, String username, String password) {
            if (userType == 1) {
                // process type 1
            } else if (userType == 2) { // User
                // process other type
            }
            return false;
        }
    }

    // Consumer
    class AuthController{
        private AuthService authService = new AuthService();

        public boolean login(String username, String password) {
            return authService.login(1, username, password);
        }
    }

}
