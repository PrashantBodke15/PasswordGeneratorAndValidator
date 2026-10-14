package PasswordGeneratorAndValidator;



public class PasswordValidator {

    public static void validate(String password)
            throws WeakPasswordException {

        if (password == null || password.length() < 8) {
            throw new WeakPasswordException(
                "Password must contain at least 8 characters.");
        }

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                upper = true;
            } else if (Character.isLowerCase(ch)) {
                lower = true;
            } else if (Character.isDigit(ch)) {
                digit = true;
            } else {
                special = true;
            }
        }

        if (!upper || !lower || !digit || !special) {
            throw new WeakPasswordException(
                "Password must contain uppercase, lowercase, "
                + "digit and special character.");
        }

        System.out.println("Password is strong!");
    }
}


