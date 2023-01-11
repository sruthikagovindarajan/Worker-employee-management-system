//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class NewEmployer extends JPanel implements FocusListener, ActionListener {
    private static final long serialVersionUID = 1L;
    private final int LY = 250;
    private final int LX = 300;
    private final int TW = 150;
    private final int TH = 25;
    private final int LW = 95;
    private final int LH = 25;
    private final int LVS = 40;
    private final int LHS = 30;
    private final int BW = 80;
    private final int BH = 30;
    private final int TEXT_EDGE = 30;
    private JLabel name_label;
    private JLabel surname_label;
    private JLabel business_label;
    private JLabel phoneNumber_label;
    private JLabel image_label;
    private JLabel imageText_label;
    private JTextField name_text;
    private JTextField surname_text;
    private JTextField business_text;
    private JTextField phoneNumber_text;
    private JButton save_button;
    private JButton paneSave_button;
    private JButton paneCancel_button;
    private JPanel saveButton_panel;
    private int currentTextArray = 0;
    private ArrayList<JTextField> textArray;

    public NewEmployer() {
        this.setLayout((LayoutManager)null);
        this.image_label = new JLabel();
        this.image_label.setIcon(new ImageIcon("src\\icons\\new_employer.png"));
        this.image_label.setBounds(435, 40, 128, 130);
        this.add(this.image_label);
        this.imageText_label = new JLabel("NEW EMPLOYER");
        this.imageText_label.setBounds(425, 180, 150, 30);
        this.imageText_label.setFont(new Font("SansSerif", 0, 18));
        this.add(this.imageText_label);
        this.textArray = new ArrayList();
        this.name_label = new JLabel("Name");
        this.name_label.setBounds(300, 250, 95, 25);
        this.add(this.name_label);
        this.name_text = new JTextField();
        this.name_text.setBounds(this.name_label.getX() + 95 + 30, this.name_label.getY(), 150, 25);
        this.name_text.addFocusListener(this);
        this.textArray.add(this.name_text);
        this.name_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (NewEmployer.this.save_button != null) {
                    NewEmployer.this.surname_text.requestFocus();
                }

            }
        });
        this.add(this.name_text);
        this.surname_label = new JLabel("Surname");
        this.surname_label.setBounds(this.name_label.getX(), this.name_label.getY() + 40, 95, 25);
        this.add(this.surname_label);
        this.surname_text = new JTextField();
        this.surname_text.setBounds(this.surname_label.getX() + 95 + 30, this.surname_label.getY(), 150, 25);
        this.surname_text.addFocusListener(this);
        this.textArray.add(this.surname_text);
        this.surname_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (NewEmployer.this.save_button != null) {
                    NewEmployer.this.business_text.requestFocus();
                }

            }
        });
        this.add(this.surname_text);
        this.business_label = new JLabel("Business");
        this.business_label.setBounds(this.surname_label.getX(), this.surname_label.getY() + 40, 95, 25);
        this.add(this.business_label);
        this.business_text = new JTextField();
        this.business_text.setBounds(this.business_label.getX() + 95 + 30, this.business_label.getY(), 150, 25);
        this.business_text.addFocusListener(this);
        this.textArray.add(this.business_text);
        this.surname_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (NewEmployer.this.save_button != null) {
                    NewEmployer.this.phoneNumber_text.requestFocus();
                }

            }
        });
        this.add(this.business_text);
        this.phoneNumber_label = new JLabel("Phone Number");
        this.phoneNumber_label.setBounds(this.business_label.getX(), this.business_label.getY() + 40, 95, 25);
        this.add(this.phoneNumber_label);
        this.phoneNumber_text = new JTextField();
        this.phoneNumber_text.setBounds(this.phoneNumber_label.getX() + 95 + 30, this.phoneNumber_label.getY(), 150, 25);
        this.phoneNumber_text.addFocusListener(this);
        this.phoneNumber_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (NewEmployer.this.save_button != null) {
                    NewEmployer.this.save_button.doClick();
                }

            }
        });
        this.textArray.add(this.phoneNumber_text);
        this.add(this.phoneNumber_text);
        this.save_button = new JButton("SAVE");
        this.save_button.setBounds(this.phoneNumber_text.getX() + 35, this.phoneNumber_text.getY() + 25 + 20, 80, 30);
        this.save_button.setFocusPainted(false);
        this.save_button.addActionListener(this);
        this.add(this.save_button);
    }

    public void focusGained(FocusEvent var1) {
        ((JTextField)var1.getSource()).setBorder(new LineBorder(Color.blue));
    }

    public void focusLost(FocusEvent var1) {
        Color var2 = Color.green;
        if (((JTextField)var1.getSource()).getText().replaceAll("\\s+", "").equals("")) {
            var2 = Color.red;
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
        if (!this.name_text.getText().replaceAll("\\s+", "").equals("") && !this.surname_text.getText().replaceAll("\\s+", "").equals("") && !this.business_text.getText().replaceAll("\\s+", "").equals("") && !this.phoneNumber_text.getText().replaceAll("\\s+", "").equals("")){
            String var10000 = this.name_text.getText().toUpperCase();
            String var2 = "\n  Name :\t" + var10000 + "\n\n  Surname : \t" + this.surname_text.getText().toUpperCase() + "\n\n  Business : \t" + this.business_text.getText().toUpperCase() + "\n\n  Phone number :   " + this.phoneNumber_text.getText() + "\n";
            Object[] var3 = new Object[]{new JLabel("Will be saved as"), new JTextArea(var2) {
                public boolean isEditable() {
                    return false;
                }
            }};
            int var4 = JOptionPane.showOptionDialog(this, var3, "DOCUMENT", 1, 1, new ImageIcon("src\\icons\\accounting_icon_1_32.png"), new Object[]{"SAVE", "CANCEL"}, "CANCEL");
            if (var4 == 0) {

                if (DataBase.addEmployer(this.name_text.getText().toUpperCase(), this.surname_text.getText().toUpperCase(), this.business_text.getText().toUpperCase(), this.phoneNumber_text.getText())) {
                    JOptionPane.showMessageDialog(this, "SAVED");
                    this.clearPanel();
                } else {
                    JOptionPane.showMessageDialog(this, "NOT SAVED", "DATABASE ERROR", 0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter the information correctly\ncannot be empty", "ERROR", 0);
        }

    }

    private boolean phoneNumberControl(String var1) {
        if (var1.equals("")) {
            return false;
        } else {
            return var1.charAt(0) == '0' && var1.length() == 11 || var1.charAt(0) != '0' && var1.length() == 10 || var1.charAt(0) == '+' && var1.length() == 13;
        }
    }

    private void clearPanel() {
        this.name_text.setText("");
        this.surname_text.setText("");
        this.business_text.setText("");
        this.phoneNumber_text.setText("");
        this.name_text.setBorder(new LineBorder(Color.white));
        this.surname_text.setBorder(new LineBorder(Color.white));
        this.business_text.setBorder(new LineBorder(Color.white));
        this.phoneNumber_text.setBorder(new LineBorder(Color.white));
    }

    public String toString() {
        return "New Employer";
    }
}
