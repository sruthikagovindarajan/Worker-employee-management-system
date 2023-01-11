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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class WorkerPayment extends JPanel {
    JPanel bottom_panel;
    JTextField searchBox_text;
    JButton search_button;
    JButton newSearch_button;
    JLabel searchBoxTitle_label;
    JLabel searchBoxInfoMessage_label;
    private final String[] titleTable = new String[]{"ID", "Worker", "Employer", "Date", "Paid"};
    private final String[][] workerData_2array;
    private final String[][] employerData_2array;

    public WorkerPayment() {
        this.setLayout((LayoutManager)null);
        this.workerData_2array = this.getData("worker", "all");
        this.employerData_2array = this.getData("employer", "all");
        this.newSearch_button = new JButton("New search");
        this.newSearch_button.setFocusPainted(false);
        this.newSearch_button.setBackground(new Color(255, 255, 255));
        this.newSearch_button.setBounds(10, 535, 150, 30);
        this.newSearch_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                WorkerPayment.this.GUI();
            }
        });
        this.GUI();
    }

    void GUI() {
        this.removeAll();
        this.searchBox_text = new JTextField();
        this.searchBox_text.setBounds(250, 150, 420, 30);
        this.searchBox_text.setHorizontalAlignment(0);
        this.searchBox_text.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        this.searchBox_text.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent var1) {
                if (WorkerPayment.this.searchBox_text.getText().length() > 0) {
                    WorkerPayment.this.updateBottomPanel(((JTextField)var1.getSource()).getText());
                } else {
                    WorkerPayment.this.bottom_panel.setVisible(false);
                }

            }
        });
        this.searchBox_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                WorkerPayment.this.search_button.doClick();
            }
        });
        this.add(this.searchBox_text);
        this.search_button = new JButton("Search");
        this.search_button.setBounds(this.searchBox_text.getX() + this.searchBox_text.getWidth() + 1, this.searchBox_text.getY(), 80, 30);
        this.search_button.setBackground(new Color(214, 214, 214));
        this.search_button.setFocusPainted(false);
        this.search_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                WorkerPayment.this.searchResultsGUI(WorkerPayment.this.searchBox_text.getText().toUpperCase());
            }
        });
        this.add(this.search_button);
        this.searchBoxInfoMessage_label = new JLabel("If to view all workers, leave the field blank and press the Search button.");
        this.searchBoxInfoMessage_label.setFont(new Font("Dialog", 2, 9));
        this.searchBoxInfoMessage_label.setForeground(new Color(0, 190, 0));
        this.searchBoxInfoMessage_label.setBounds(this.searchBox_text.getX(), this.searchBox_text.getY() + this.searchBox_text.getHeight(), this.searchBox_text.getWidth(), 10);
        this.searchBoxInfoMessage_label.setHorizontalAlignment(0);
        this.add(this.searchBoxInfoMessage_label);
        this.searchBoxTitle_label = new JLabel("SEARCH WORKER");
        this.searchBoxTitle_label.setBounds(this.searchBox_text.getX(), this.searchBox_text.getY() - 50, this.searchBox_text.getWidth(), 24);
        this.searchBoxTitle_label.setFont(new Font("Tahoma", 3, 18));
        this.searchBoxTitle_label.setForeground(new Color(38, 38, 38));
        this.searchBoxTitle_label.setHorizontalAlignment(0);
        this.add(this.searchBoxTitle_label);
        this.bottom_panel = new JPanel();
        this.bottom_panel.setBounds(this.searchBox_text.getX(), this.searchBox_text.getY() + this.searchBox_text.getHeight() + 11, this.searchBox_text.getWidth(), 0);
        this.bottom_panel.setVisible(true);
        this.bottom_panel.setLayout((LayoutManager)null);
        this.add(this.bottom_panel);
        this.revalidate();
        this.repaint();
    }

    protected void updateBottomPanel(String var1) {
        this.bottom_panel.removeAll();
        int var2 = 0;

        for(int var3 = 0; var3 < this.workerData_2array.length; ++var3) {
            if (this.workerData_2array[var3][1].contains(var1.toUpperCase())) {
                this.bottom_panel.add((JTextField)this.getBottomComponent(this.workerData_2array[var3][1].toUpperCase() + " " + this.workerData_2array[var3][2], var2));
                this.bottom_panel.add((JButton)this.getBottomComponent("", var2));
                ++var2;
            }
        }

        this.bottom_panel.setSize(502, (var2 > 10 ? 10 : var2) * 29);
        this.bottom_panel.setVisible(true);
        this.revalidate();
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
                    WorkerPayment.this.paymentGUI(((JTextField)WorkerPayment.this.bottom_panel.getComponent(var2 * 2)).getText());
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
                    WorkerPayment.this.paymentGUI(((JTextField)var1.getSource()).getText());
                }
            });
            var3 = var5;
        }

        return (Component)var3;
    }

    protected void searchResultsGUI(String var1) {
        this.removeAll();
        this.add(this.newSearch_button);
        DefaultListModel var2 = new DefaultListModel();

        for(int var3 = 0; var3 < this.workerData_2array.length; ++var3) {
            if ((this.workerData_2array[var3][1] + " " + this.workerData_2array[var3][2]).contains(var1)) {
                String var10001 = this.workerData_2array[var3][1];
                var2.addElement(var10001 + " " + this.workerData_2array[var3][2]);
            }
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
                    WorkerPayment.this.paymentGUI((String)((JList)var1.getSource()).getSelectedValue());
                }

            }
        });
        MyScrollPane var5 = new MyScrollPane(var8);
        var5.setBounds(0, 40, 944, 210);
        this.add(var5);
        JLabel var6 = new JLabel("Double click on the person you want to select");
        var6.setBounds(var5.getX(), var5.getY() + var5.getHeight(), var5.getWidth(), 12);
        var6.setHorizontalAlignment(0);
        var6.setFont(new Font("Dialog", 2, 11));
        var6.setForeground(new Color(0, 180, 0));
        this.add(var6);
        this.revalidate();
        this.repaint();
    }

    protected void paymentGUI(final String var1) {
        this.removeAll();
        this.setBackground(Color.white);
        this.add(this.newSearch_button);
        JLabel var2 = new JLabel(var1);
        var2.setFont(new Font("Serif", 1, 21));
        var2.setBounds(AdminPanel.W_FRAME / 2 + 4, 60, AdminPanel.W_FRAME / 2 - 4, 28);
        var2.setHorizontalAlignment(2);
        var2.setForeground(Color.BLUE);
        this.add(var2);
        JLabel var3 = new JLabel("Payment form for");
        var3.setFont(new Font("Serif", 3, 21));
        var3.setBounds(0, 60, AdminPanel.W_FRAME / 2 - 4, 28);
        var3.setHorizontalAlignment(4);
        var3.setForeground(new Color(152, 30, 58));
        this.add(var3);
        JLabel var4 = new JLabel("Payer");
        var4.setBounds(150, 200, 170, 26);
        var4.setForeground(new Color(53, 68, 78));
        this.add(var4);
        DefaultComboBoxModel var5 = new DefaultComboBoxModel();

        for(int var6 = 0; var6 < this.employerData_2array.length; ++var6) {
            String var10001 = this.employerData_2array[var6][1];
            var5.addElement(var10001 + " " + this.employerData_2array[var6][2]);
        }

        final JComboBox var19 = new JComboBox(var5);
        var19.setBounds(260, 200, 170, 26);
        ((JLabel)var19.getRenderer()).setHorizontalAlignment(0);
        var19.setSelectedItem((Object)null);
        this.add(var19);
        JLabel var7 = new JLabel("Amount");
        var7.setBounds(150, 300, 120, 26);
        var7.setForeground(new Color(53, 68, 78));
        this.add(var7);
        final JTextField var8 = new JTextField();
        var8.setBounds(260, 300, 95, 26);
        var8.setHorizontalAlignment(0);
        var8.setBorder(new LineBorder(new Color(0, 160, 0), 1));
        this.add(var8);
        JLabel var9 = new JLabel("Amount of payment");
        var9.setBounds(260, 270, 95, 30);
        var9.setForeground(new Color(0, 160, 0));
        var9.setFont(new Font("Tahoma", 0, 9));
        var9.setHorizontalAlignment(0);
        var9.setVerticalAlignment(0);
        this.add(var9);
        final JTextField var10 = new JTextField();
        var10.setBounds(365, 300, 65, 26);
        var10.setHorizontalAlignment(0);
        var10.setBorder(new LineBorder(new Color(20, 20, 220), 1));
        var10.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent var1) {
                String var2 = var10.getText();
                if (!var2.equals("")) {
                    try {
                        int var3 = Integer.parseInt(var2);
                        int var4 = Integer.parseInt("100") - Integer.parseInt("10");
                     //   var8.setText((var4 * var3).makeConcatWithConstants<invokedynamic>(var4 * var3));
                    } catch (NumberFormatException var5) {
                        var8.setText("a lot of money");
                    }
                } else {
                    var8.setText("0");
                }

            }
        });
        this.add(var10);
        JLabel var11 = new JLabel("Wage");
        var11.setBounds(365, 270, 65, 30);
        var11.setForeground(new Color(20, 20, 220));
        var11.setFont(new Font("Tahoma", 0, 9));
        var11.setHorizontalAlignment(0);
        var11.setVerticalAlignment(0);
        this.add(var11);
        String var12 = this.nameConvertToId("worker", var1);
        String[][] var13 = this.getData("worker_payment", "WHERE worker_id=" + var12);
        System.out.println(var13.length + ", " + var13[0].length);
        String[][] var14 = this.idConvertName(var13, "worker", 1);
        System.out.println(var14.length + ", " + var14[0].length);
        String[][] var15 = this.idConvertName(var14, "employer", 2);
        System.out.println(var15.length + ", " + var15[0].length);
        JTable var16 = new JTable(var15, this.titleTable) {
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
        var16.setRowHeight(24);
        var16.getColumnModel().getColumn(0).setPreferredWidth(5);
        var16.getColumnModel().getColumn(1).setPreferredWidth(60);
        var16.getColumnModel().getColumn(2).setPreferredWidth(80);
        var16.getColumnModel().getColumn(3).setPreferredWidth(22);
        var16.getColumnModel().getColumn(4).setPreferredWidth(40);
        var16.setAutoResizeMode(3);
        JScrollPane var17 = new JScrollPane(var16);
        var17.setBounds(500, 200, 400, 210);
        var17.getViewport().setBackground(Color.white);
        this.add(var17);
        JButton var18 = new JButton("Pay");
        var18.setBounds(150, 380, 286, 30);
        var18.setFocusPainted(false);
        this.add(var18);
        var18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1x) {
                if (!var8.getText().equals("") && !var8.getText().equals("0")) {
                    boolean var2 = true;

                    try {
                        int var3 = Integer.parseInt(var8.getText());
                        System.out.println(var3);
                        String var4 = WorkerPayment.this.nameConvertToId("employer", (String)var19.getSelectedItem());
                        String var5 = WorkerPayment.this.nameConvertToId("worker", var1);
                        System.out.println(var4 + " " + var5 + " " + var3);
                        if (DataBase.workerPayment("worker_payment", var5, var4, var3)) {
                            JOptionPane.showMessageDialog(WorkerPayment.this, "PAYMENT SUCCESSFUL", "PAYMENT RESULT", 1);
                            WorkerPayment.this.paymentGUI(var1);
                        } else {
                            JOptionPane.showMessageDialog(WorkerPayment.this, "PAYMENT FAILED", "PAYMENT RESULT", 0);
                        }
                    } catch (NumberFormatException var6) {
                        var6.printStackTrace();
                        JOptionPane.showMessageDialog((Component)null, "Enter only the number values \nin the amount field.", "ERROR", 0);
                    }
                }

            }
        });
        this.revalidate();
        this.repaint();
    }

    public JTable setColumnWidth(JTable var1, int... var2) {
        for(int var3 = 0; var3 < var1.getColumnCount() && var3 < var2.length; ++var3) {
            var1.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
        }

        var1.setAutoResizeMode(3);
        return var1;
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

    public String[] listConvertToArray(ArrayList<String[]> var1, int... var2) {
        String[][] var3 = this.listConvertToArray(var1);
        String[] var4 = new String[var3.length];
        if (var3[0].length < Arrays.stream(var2).max().getAsInt()) {
            return null;
        } else {
            for(int var5 = 0; var5 < var3.length; ++var5) {
                var4[var5] = "";

                for(int var6 = 0; var6 < var2.length; ++var6) {
                    var4[var5] = var4[var5] + var3[var5][var2[var6]] + " ";
                }

                var4[var5] = var4[var5].substring(0, var4[var5].length() - 1);
            }

            return var4;
        }
    }

    private String nameConvertToId(String var1, String var2) {
        String[][] var3 = null;
        if (var1.equals("worker")) {
            var3 = this.workerData_2array;
        }

        if (var1.equals("employer")) {
            var3 = this.employerData_2array;
        }

        for(int var4 = 0; var4 < var3.length; ++var4) {
            if ((var3[var4][1] + " " + var3[var4][2]).equals(var2)) {
                return var3[var4][0];
            }
        }

        return null;
    }

    private String[][] idConvertName(String[][] var1, String var2, int var3) {
        String[][] var4 = var1;
        String var5 = var3 == 1 ? "worker" : (var3 == 2 ? "employer" : null);

        for(int var6 = 0; var6 < var1.length; ++var6) {
            String[] var10000 = var4[var6];
            String var10002 = ((String[])DataBase.getData(var2, "WHERE " + var5 + "_id='" + Integer.parseInt(var1[var6][var3]) + "'").get(0))[1];
            var10000[var3] = var10002 + " " + ((String[])DataBase.getData(var2, "WHERE " + var5 + "_id='" + Integer.parseInt(var1[var6][var3]) + "'").get(0))[2];
        }

        return var4;
    }

    public String toString() {
        return "Worker Payment";
    }
}
