package gui;

import javax.swing.*;

public class LoginGUI extends JFrame {
    private JPanel panel;
    private JLabel emailLabel, passwordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGUI() {
        panel = new JPanel();
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        this.add(panel);
        this.setTitle("Login");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
