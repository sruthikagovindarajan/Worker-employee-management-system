//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class NewWorker extends JPanel implements ActionListener, FocusListener {
    private static final long serialVersionUID = 1L;
    private final int LY = 250;
    private final int LX = 300;
    private final int TW = 150;
    private final int TH = 25;
    private final int LW = 85;
    private final int LH = 25;
    private final int LVS = 40;
    private final int LHS = 30;
    private final int BW = 80;
    private final int BH = 30;
    private JLabel name_label;
    private JLabel surname_label;
    private JLabel phoneNumber_label;
    private JLabel image_label;
    private JTextField name_text;
    private JTextField surname_text;
    private JTextField phoneNumber_text;
    private JButton save_button;

    public NewWorker() {
        this.setLayout((LayoutManager)null);
        this.image_label = new JLabel(new ImageIcon("src\\icons\\new_worker.png"));
        this.image_label.setBounds(427, 80, 128, 128);
        this.add(this.image_label);
        this.name_label = new JLabel("Name");
        this.name_label.setBounds(300, 250, 85, 25);
        int var10001 = AdminPanel.INSETS.left;
        System.out.println("300\n85\n" + var10001 + "\n" + this.image_label.getX() + "\n" + (this.name_label.getX() + this.name_label.getWidth()));
        this.add(this.name_label);
        this.name_text = new JTextField();
        this.name_text.setBounds(300 + this.name_label.getWidth() + 30, this.name_label.getY(), 150, 25);
        this.name_text.addFocusListener(this);
        this.name_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (!NewWorker.this.name_text.getText().equals("")) {
                    NewWorker.this.surname_text.requestFocus();
                }

            }
        });
        this.add(this.name_text);
        this.surname_label = new JLabel("Surname");
        this.surname_label.setBounds(300, this.name_label.getY() + 40, 85, 25);
        this.add(this.surname_label);
        this.surname_text = new JTextField();
        this.surname_text.setBounds(300 + this.surname_label.getWidth() + 30, this.surname_label.getY(), 150, 25);
        this.surname_text.addFocusListener(this);
        this.surname_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (!NewWorker.this.surname_text.getText().equals("")) {
                    NewWorker.this.phoneNumber_text.requestFocus();
                }

            }
        });
        this.add(this.surname_text);
        this.phoneNumber_label = new JLabel("Phone Number");
        this.phoneNumber_label.setBounds(300, this.surname_label.getY() + 40, 85, 25);
        this.add(this.phoneNumber_label);
        this.phoneNumber_text = new JTextField();
        this.phoneNumber_text.setBounds(300 + this.phoneNumber_label.getWidth() + 30, this.phoneNumber_label.getY(), 150, 25);
        this.phoneNumber_text.addFocusListener(this);
        this.phoneNumber_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                NewWorker.this.save_button.doClick();
            }
        });
        this.add(this.phoneNumber_text);
        this.save_button = new JButton("SAVE");
        this.save_button.setBounds(0, 0, 80, 30);
        this.save_button.addActionListener(this);
        this.save_button.setBounds(this.phoneNumber_text.getX() + 35, this.phoneNumber_text.getY() + 25 + 20, 80, 30);
        this.save_button.setFocusPainted(false);
        this.add(this.save_button);
    }

    public void focusGained(FocusEvent var1) {
        ((JTextField)var1.getSource()).setBorder(new LineBorder(Color.blue));
    }

    public void focusLost(FocusEvent var1) {
        Color var2 = Color.green;
        if (((JTextField)var1.getSource()).getText().replaceAll("\\s+", "").equals("")) {
            if (var1.getSource() != this.name_text && var1.getSource() != this.surname_text) {
                var2 = Color.white;
            } else {
                var2 = Color.red;
            }
        } else if (var1.getSource() == this.phoneNumber_text) {
            if (this.phoneNumberControl(this.phoneNumber_text.getText())) {
                var2 = Color.white;
            } else {
                var2 = Color.red;
            }
        }

        ((JTextField)var1.getSource()).setBorder(new LineBorder(var2));
    }

    public void actionPerformed(ActionEvent var1) {
        if (!this.name_text.getText().replaceAll("\\s+", "").equals("") && !this.surname_text.getText().replaceAll("\\s+", "").equals("") && !this.phoneNumber_text.getText().replaceAll("\\s+", "").equals("")) {
            JLabel var2 = new JLabel(this.name_label.getText());
            JLabel var3 = new JLabel(this.surname_label.getText());
            JLabel var4 = new JLabel(this.phoneNumber_label.getText());
            JTextField var5 = new JTextField(this.name_text.getText().toUpperCase());
            var5.setSize(80, 24);
            var5.setEditable(false);
            JTextField var6 = new JTextField(this.surname_text.getText().toUpperCase());
            var6.setSize(80, 24);
            var6.setEditable(false);
            JTextField var7 = new JTextField(this.phoneNumber_text.getText().toUpperCase());
            var7.setSize(80, 24);
            var7.setEditable(false);
            Object[] var8 = new Object[]{var2, var5, var3, var6, var4, var7};
            int var9 = JOptionPane.showOptionDialog(this, var8, "Save Form", 0, -1, new ImageIcon("src//icons//accounting_icon_1_32.png"), new Object[]{"SAVE", "CANCEL"}, "CANCEL");
            System.out.print(var9);
            if (var9 == 0) {
                if (DataBase.addWorker(var5.getText().toUpperCase(), var6.getText().toUpperCase(), var7.getText().toUpperCase())) {
                    JOptionPane.showMessageDialog(this, "SAVED");
                    this.clearPanel();
                } else {
                    JOptionPane.showMessageDialog(this, "NOT SAVED", "DATABASE ERROR", 0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter the information correctly", "ERROR", 0);
        }

    }

    private boolean phoneNumberControl(String var1) {
        if (var1.equals("")) {
            return true;
        } else {
            return var1.charAt(0) == '0' && var1.length() == 11 || var1.charAt(0) != '0' && var1.length() == 10 || var1.charAt(0) == '+' && var1.length() == 13;
        }
    }

    private void clearPanel() {
        this.name_text.setText("");
        this.surname_text.setText("");
        this.phoneNumber_text.setText("");
        this.name_text.setBorder(new LineBorder(Color.white));
        this.surname_text.setBorder(new LineBorder(Color.white));
        this.phoneNumber_text.setBorder(new LineBorder(Color.white));
    }

    public String toString() {
        return "New Worker";
    }
}
