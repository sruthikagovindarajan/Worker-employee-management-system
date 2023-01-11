//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class EmployerPayment extends JPanel {
    private static final long serialVersionUID = 1L;
    JButton newSearch_button;
    JButton search_button;
    JTextField searchBox_text;
    JPanel searchBottom_panel;
    JLabel searchBoxInfoMessage_label;
    JLabel searchBoxTitle_label;
    private String[][] employers;

    public EmployerPayment() {
        this.setLayout((LayoutManager)null);
        this.employers = this.getData("employer", "all");
        this.newSearch_button = new JButton("New search");
        this.newSearch_button.setFocusPainted(false);
        this.newSearch_button.setBackground(new Color(255, 255, 255));
        this.newSearch_button.setBounds(10, 535, 150, 30);
        this.newSearch_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                EmployerPayment.this.GUI();
            }
        });
        this.GUI();
    }

    void GUI() {
        this.removeAll();
        this.searchBox_text = new JTextField();
        this.searchBox_text.setBounds(250, 150, 420, 30);
        this.searchBox_text.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        this.searchBox_text.setHorizontalAlignment(0);
        this.searchBox_text.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent var1) {
                if (EmployerPayment.this.searchBox_text.getText().length() > 0) {
                    EmployerPayment.this.updateBottomPanel(((JTextField)var1.getSource()).getText());
                } else {
                    EmployerPayment.this.searchBottom_panel.setVisible(false);
                }

            }
        });
        this.searchBox_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                EmployerPayment.this.search_button.doClick();
            }
        });
        this.add(this.searchBox_text);
        this.search_button = new JButton("Search");
        this.search_button.setBounds(this.searchBox_text.getX() + this.searchBox_text.getWidth() + 1, this.searchBox_text.getY(), 80, 30);
        this.search_button.setBackground(new Color(214, 214, 214));
        this.search_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                EmployerPayment.this.searchResultsGUI(EmployerPayment.this.searchBox_text.getText().toUpperCase());
            }
        });
        this.add(this.search_button);
        this.searchBoxInfoMessage_label = new JLabel("If to view all employers, leave the field blank and press the Search button.");
        this.searchBoxInfoMessage_label.setFont(new Font("Dialog", 2, 9));
        this.searchBoxInfoMessage_label.setForeground(new Color(0, 190, 0));
        this.searchBoxInfoMessage_label.setBounds(this.searchBox_text.getX(), this.searchBox_text.getY() + this.searchBox_text.getHeight(), this.searchBox_text.getWidth(), 10);
        this.searchBoxInfoMessage_label.setHorizontalAlignment(0);
        this.add(this.searchBoxInfoMessage_label);
        this.searchBoxTitle_label = new JLabel("SEARCH EMPLOYER");
        this.searchBoxTitle_label.setBounds(this.searchBox_text.getX(), this.searchBox_text.getY() - 50, this.searchBox_text.getWidth(), 24);
        this.searchBoxTitle_label.setFont(new Font("Tahoma", 3, 18));
        this.searchBoxTitle_label.setForeground(new Color(38, 38, 38));
        this.searchBoxTitle_label.setHorizontalAlignment(0);
        this.add(this.searchBoxTitle_label);
        this.searchBottom_panel = new JPanel();
        this.searchBottom_panel.setBounds(this.searchBox_text.getX(), this.searchBox_text.getY() + this.searchBox_text.getHeight() + 11, this.searchBox_text.getWidth(), 0);
        this.searchBottom_panel.setVisible(true);
        this.searchBottom_panel.setLayout((LayoutManager)null);
        this.add(this.searchBottom_panel);
        this.revalidate();
        this.repaint();
    }

    void viewGUI(final String var1) {
        this.removeAll();
        this.setBackground(Color.white);
        this.add(this.newSearch_button);
        JLabel var2 = new JLabel("Payment form for " + var1);
        var2.setFont(new Font("Serif", 3, 21));
        var2.setBounds(0, 60, this.getWidth(), 28);
        var2.setHorizontalAlignment(0);
        var2.setForeground(new Color(152, 30, 58));
        this.add(var2);
        final JTextField var3 = new JTextField();
        var3.setBounds(180, 270, 130, 26);
        var3.setHorizontalAlignment(0);
        var3.setBorder(new LineBorder(new Color(0, 160, 0), 1));
        this.add(var3);
        JLabel var4 = new JLabel("amount of payment");
        var4.setBounds(180, 240, 130, 30);
        var4.setForeground(new Color(0, 160, 0));
        var4.setFont(new Font("Tahoma", 0, 9));
        var4.setHorizontalAlignment(0);
        var4.setVerticalAlignment(0);
        this.add(var4);
        final JTextField var5 = new JTextField();
        var5.setBounds(341, 270, 65, 26);
        var5.setHorizontalAlignment(0);
        var5.setBorder(new LineBorder(new Color(20, 20, 220), 1));
        var5.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent var1) {
                String var2 = var5.getText();
                if (!var2.equals("")) {
                    try {
                        int var3x = Integer.parseInt(var2);
                        byte var4 = 100;
                       // var3.setText((var4 * var3x).makeConcatWithConstants<invokedynamic>(var4 * var3x));
                    } catch (NumberFormatException var5x) {
                        var3.setText("a lot of money");
                    }
                } else {
                    var3.setText("0");
                }

            }
        });
        this.add(var5);
        JLabel var6 = new JLabel("Wage");
        var6.setBounds(341, 240, 65, 30);
        var6.setForeground(new Color(20, 20, 220));
        var6.setFont(new Font("Tahoma", 0, 9));
        var6.setHorizontalAlignment(0);
        var6.setVerticalAlignment(0);
        this.add(var6);
        String var7 = this.nameConvertToId(var1);
        String[][] var8 = this.idConvertName(this.getData("employer_payment", "WHERE employer_id=" + var7), 1);
        String[] var9 = new String[]{"ID", "Employer", "Date", "Paid"};
        JTable var10 = new JTable(var8, var9) {
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();

            {
                this.render.setHorizontalAlignment(0);
            }

            public TableCellRenderer getCellRenderer(int var1, int var2) {
                return this.render;
            }

            public boolean isCellEditable(int var1, int var2) {
                return false;
            }
        };
        var10.setRowHeight(24);
        var10.getColumnModel().getColumn(0).setPreferredWidth(5);
        var10.getColumnModel().getColumn(1).setPreferredWidth(80);
        var10.getColumnModel().getColumn(2).setPreferredWidth(22);
        var10.getColumnModel().getColumn(3).setPreferredWidth(40);
        var10.setAutoResizeMode(3);
        JScrollPane var11 = new JScrollPane(var10);
        var11.setBounds(500, 200, 400, 210);
        var11.getViewport().setBackground(Color.white);
        this.add(var11);
        JButton var12 = new JButton("Get paid");
        var12.setBounds(150, 380, 286, 30);
        var12.setFocusPainted(false);
        var12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1x) {
                if (!var3.getText().equals("") && !var3.getText().equals("0")) {
                    boolean var2 = true;

                    try {
                        int var3x = Integer.parseInt(var3.getText());
                        String var4 = EmployerPayment.this.nameConvertToId(var1);
                        if (DataBase.employerPayment("employer_payment", var4, var3x)) {
                            JOptionPane.showMessageDialog((Component)null, "PAYMENT SUCCESSFUL", "PAYMENT RESULT", 1);
                            EmployerPayment.this.viewGUI(var1);
                        }
                    } catch (NumberFormatException var5) {
                        JOptionPane.showMessageDialog((Component)null, "Enter only the number values \nin the amount field.", "ERROR", 0);
                    }
                }

            }
        });
        this.add(var12);
        this.revalidate();
        this.repaint();
    }

    protected void searchResultsGUI(String var1) {
        this.removeAll();
        this.add(this.newSearch_button);
        DefaultListModel var2 = new DefaultListModel();

        for(int var3 = 0; var3 < (this.employers == null ? 0 : this.employers.length); ++var3) {
            String var10001 = this.employers[var3][1];
            var2.addElement(var10001 + " " + this.employers[var3][2]);
        }

        String[] var7 = new String[var2.getSize()];
        var2.copyInto(var7);
        Arrays.sort(var7);
        var2 = new DefaultListModel();

        for(int var4 = 0; var4 < var7.length; ++var4) {
            var2.addElement(var7[var4]);
        }

        JList var8 = new JList(var2);
        var8.setBackground(new Color(244, 244, 244));
        ((DefaultListCellRenderer)var8.getCellRenderer()).setHorizontalAlignment(0);
        var8.setFixedCellHeight(32);
        var8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent var1) {
                if (var1.getClickCount() == 2) {
                    EmployerPayment.this.viewGUI((String)((JList)var1.getSource()).getSelectedValue());
                }

            }
        });
        MyScrollPane var5 = new MyScrollPane(var8);
        var5.setBounds(0, 40, 944, 210);
        this.add(var5);
        JLabel var6 = new JLabel("Double click on the person you want to select");
        var6.setBounds(var5.getX(), var5.getY() + var5.getHeight(), var5.getWidth(), 12);
        var6.setFont(new Font("Dialog", 2, 10));
        var6.setForeground(new Color(0, 180, 0));
        this.add(var6);
        this.revalidate();
        this.repaint();
    }

    protected void updateBottomPanel(String var1) {
        this.searchBottom_panel.removeAll();
        int var2 = 0;

        for(int var3 = 0; var3 < (this.employers == null ? 0 : this.employers.length); ++var3) {
            if ((this.employers[var3][1] + " " + this.employers[var3][2]).contains(var1.toUpperCase())) {
                this.searchBottom_panel.add((JTextField)this.getBottomComponent(this.employers[var3][1].toUpperCase() + " " + this.employers[var3][2], var2));
                this.searchBottom_panel.add((JButton)this.getBottomComponent("", var2));
                ++var2;
            }
        }

        this.searchBottom_panel.setSize(502, (var2 > 10 ? 10 : var2) * 29);
        this.searchBottom_panel.setVisible(true);
        this.repaint();
    }

    private Component getBottomComponent(String var1, int var2) {
        Object var3 = null;
        if (var1.equals("")) {
            JButton var4 = new JButton("Choose");
            var4.setBounds(421, var2 * 29, 80, 28);
            var4.setName(var1 + var2);
            var4.setFocusPainted(false);
            var4.setBackground(new Color(214, 214, 214));
            var4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent var1) {
                    int var2 = Integer.parseInt(((JButton)var1.getSource()).getName());
                    EmployerPayment.this.viewGUI(((JTextField)EmployerPayment.this.searchBottom_panel.getComponent(var2 * 2)).getText());
                }
            });
            var3 = var4;
        } else {
            final JTextField var5 = new JTextField(var1);
            var5.setHorizontalAlignment(0);
            var5.setEditable(false);
            var5.setBackground(new Color(238, 238, 238));
            var5.setBorder(new LineBorder(Color.white));
            var5.setBounds(0, var2 * 29, 420, 28);
            var5.addMouseListener(new MouseAdapter() {
                public void mouseExited(MouseEvent var1) {
                    var5.setBackground(new Color(238, 238, 238));
                }

                public void mouseEntered(MouseEvent var1) {
                    var5.setBackground(Color.WHITE);
                }

                public void mouseClicked(MouseEvent var1) {
                    EmployerPayment.this.viewGUI(((JTextField)var1.getSource()).getText());
                }
            });
            var3 = var5;
        }

        return (Component)var3;
    }

    public String[][] getData(String var1, String var2) {
        ArrayList var3;
        if (var2.equals("all")) {
            var3 = DataBase.getData(var1);
        } else {
            var3 = DataBase.getData(var1, var2);
        }

        return this.listConvertToArray(var3);
    }

    public String[][] listConvertToArray(ArrayList<String[]> var1) {
        String[][] var2 = new String[0][];
        if (var1.size() != 0) {
            var2 = new String[var1.size()][((String[])var1.get(0)).length];

            for(int var3 = 0; var3 < var2.length; ++var3) {
                for(int var4 = 0; var4 < var2[var3].length; ++var4) {
                    var2[var3][var4] = ((String[])var1.get(var3))[var4];
                }
            }
        }

        return var2;
    }

    private String nameConvertToId(String var1) {
        for(int var2 = 0; var2 < this.employers.length; ++var2) {
            if ((this.employers[var2][1] + " " + this.employers[var2][2]).equals(var1)) {
                return this.employers[var2][0];
            }
        }

        return null;
    }

    private String[][] idConvertName(String[][] var1, int var2) {
        String[][] var3 = var1;

        for(int var4 = 0; var4 < var3.length; ++var4) {
            String[] var10000 = var3[var4];
            int var10003 = Integer.parseInt(var1[var4][var2]);
            String var10002 = ((String[])DataBase.getData("employer", "WHERE employer_id='" + var10003 + "'").get(0))[1];
            int var10004 = Integer.parseInt(var1[var4][var2]);
            var10000[var2] = var10002 + " " + ((String[])DataBase.getData("employer", "WHERE employer_id='" + var10004 + "'").get(0))[2];
        }

        return var3;
    }

    public String toString() {
        return "Employer Payment";
    }
}
