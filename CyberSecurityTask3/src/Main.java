//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Password Strength Checker");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Gradient Panel
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                int w = getWidth();
                int h = getHeight();

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(58, 123, 213),
                        w, h, new Color(58, 213, 175)
                );

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };

        panel.setLayout(null);
        frame.setContentPane(panel);

        // Title
        JLabel title = new JLabel("Password Strength Checker");
        title.setBounds(70, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        panel.add(title);

        // Label
        JLabel label = new JLabel("Enter Password:");
        label.setBounds(40, 70, 150, 25);
        label.setForeground(Color.WHITE);
        panel.add(label);

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(180, 70, 180, 25);
        panel.add(passwordField);

        // Show Checkbox
        JCheckBox show = new JCheckBox("Show");
        show.setBounds(180, 100, 70, 20);
        show.setOpaque(false);
        show.setForeground(Color.WHITE);
        panel.add(show);

        show.addActionListener(e -> {
            if (show.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        // Button
        JButton btn = new JButton("Check Strength");
        btn.setBounds(140, 130, 150, 30);
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        panel.add(btn);

        // Result Label
        JLabel result = new JLabel("");
        result.setBounds(120, 180, 250, 30);
        result.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(result);

        // Button Action
        btn.addActionListener(e -> {
            String password = new String(passwordField.getPassword());

            int score = PasswordChecker.calculateScore(password);
            String strength = PasswordChecker.getStrength(score);

            result.setText("Strength: " + strength);

            // Color based on strength
            if (score == 5) {
                result.setForeground(new Color(0, 255, 0));
            } else if (score >= 3) {
                result.setForeground(Color.YELLOW);
            } else {
                result.setForeground(Color.RED);
            }
        });

        frame.setVisible(true);
    }
}