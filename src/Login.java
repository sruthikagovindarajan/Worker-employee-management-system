//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;
    public static final int W_FRAME = 540;
    public static final int H_FRAME = 360;
    private final String errorText = "Wrong username or password";
    private JPanel contentPane;
    private JButton button_login;
    private JLabel label_username;
    private JLabel label_password;
    private JLabel label_icon;
    private JLabel label_errorText;
    private JTextField textField_username;
    private JPasswordField passwordField_password;
    private Insets insets;

    public Login() {
        super("Login");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\icons\\Login_user_24.png"));
        this.setResizable(false);
        this.setLayout((LayoutManager)null);
        this.setSize(540, 360);
        this.setLocationRelativeTo((Component)null);
        this.setLocation(this.getX() - 80, this.getY() - 80);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.insets = this.getInsets();
        this.GUI();
    }

    private void GUI() {
        this.contentPane = new JPanel();
        this.contentPane.setLayout((LayoutManager)null);
        this.contentPane.setBounds(this.insets.left, this.insets.top, 540 - this.insets.left - this.insets.right, 360 - this.insets.bottom - this.insets.top);
        this.label_username = new JLabel("Username");
        this.label_username.setFont(new Font("Tahoma", 0, 14));
        this.label_username.setBounds(120, 140, 70, 20);
        this.contentPane.add(this.label_username);
        this.label_password = new JLabel("Password");
        this.label_password.setFont(this.label_username.getFont());
        this.label_password.setBounds(this.label_username.getX(), this.label_username.getY() + 40, this.label_username.getWidth(), this.label_username.getHeight());
        this.contentPane.add(this.label_password);
        this.textField_username = new JTextField();
        this.textField_username.setBounds(this.label_username.getX() + this.label_username.getWidth() + 30, this.label_username.getY(), 120, this.label_username.getHeight());
        this.textField_username.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                Login.this.passwordField_password.requestFocus();
            }
        });
        this.contentPane.add(this.textField_username);
        this.passwordField_password = new JPasswordField();
        this.passwordField_password.setBounds(this.textField_username.getX(), this.label_password.getY(), 120, this.label_password.getHeight());
        this.passwordField_password.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                Login.this.button_login.doClick();
            }
        });
        this.contentPane.add(this.passwordField_password);
        this.button_login = new JButton("Login");
        this.button_login.setBounds(this.textField_username.getX() + 20, this.label_username.getY() + 80, 80, 22);
        this.button_login.setFocusPainted(false);
        this.button_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (!Login.this.textField_username.getText().equals("") && !String.valueOf(Login.this.passwordField_password.getPassword()).equals("")) {
                    Login.this.label_errorText.setText("");
                    if (DataBase.verifyLogin(Login.this.textField_username.getText(), String.valueOf(Login.this.passwordField_password.getPassword())) != -1) {
                        EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                Login.this.dispose();
                                new AdminPanel();
                            }
                        });
                    } else {
                        Login.this.label_errorText.setText("Wrong username or password");
                    }
                } else {
                    Login.this.label_errorText.setText("Wrong username or password");
                }

            }
        });
        this.contentPane.add(this.button_login);
        this.label_icon = new JLabel(new ImageIcon("src\\icons\\Login_user_72.png"));
        this.label_icon.setBounds(this.textField_username.getX() + 20, this.textField_username.getY() - 100, 72, 72);
        this.contentPane.add(this.label_icon);
        this.label_errorText = new JLabel();
        this.label_errorText.setForeground(Color.RED);
        this.label_errorText.setBounds(this.button_login.getX() - 45, this.button_login.getY() + 30, 170, 30);
        this.label_errorText.setFont(new Font("Tahoma", 1, 11));
        this.contentPane.add(this.label_errorText);
        this.setContentPane(this.contentPane);
    }

    public static void main(String[] var0) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
