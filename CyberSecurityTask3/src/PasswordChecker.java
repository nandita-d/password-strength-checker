public class PasswordChecker {

    public static int calculateScore(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*].*")) score++;

        return score;
    }

    public static String getStrength(int score) {
        if (score == 5) return "💪 Strong";
        else if (score >= 3) return "⚠️ Medium";
        else return "❌ Weak";
    }
}