package PasswordGeneratorAndValidator;



import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class PasswordGenerator {

    private final SecureRandom random = new SecureRandom();

    private final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lower = "abcdefghijklmnopqrstuvwxyz";
    private final String digits = "0123456789";
    private final String special = "!@#$%^&*";

    private final ArrayList<String> history = new ArrayList<>();
    private final HashSet<String> uniquePasswords = new HashSet<>();

    private char randomChar(String characters) {
        return characters.charAt(
            random.nextInt(characters.length()));
    }

    public String generatePassword(int length)
            throws WeakPasswordException {

        if (length < 8) {
            throw new WeakPasswordException(
                "Password length must be at least 8.");
        }

        String password;

        do {
            ArrayList<Character> chars = new ArrayList<>();

            // Ensure every required character type is present
            chars.add(randomChar(upper));
            chars.add(randomChar(lower));
            chars.add(randomChar(digits));
            chars.add(randomChar(special));

            String all = upper + lower + digits + special;

            while (chars.size() < length) {
                chars.add(randomChar(all));
            }

            Collections.shuffle(chars, random);

            StringBuilder result = new StringBuilder();

            for (char ch : chars) {
                result.append(ch);
            }

            password = result.toString();

        } while (uniquePasswords.contains(password));

        uniquePasswords.add(password);
        history.add(password);

        return password;
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No passwords generated yet.");
            return;
        }

        System.out.println("\nGenerated Passwords:");

        history.forEach(System.out::println);
    }
}


