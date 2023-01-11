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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ViewRecord extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int TX = 5;
    private final int TY = 5;
    private final int TW = 500;
    private final int TH = 323;
    private final int SPACE = 80;
    private final String[] column_array = new String[]{"ID", "Employer", "Date", "Note", "Number of workers", "Wage"};
    private final String[] detailColumn_array = new String[]{"ID", "Worker", "Employer", "Date"};
    private String[][] data_2array;
    private String[][] employer_2array;
    private JButton filter_button;
    private JButton detail_button;
    private JButton print_button;
    private JCheckBox date_checkBox;
    private JScrollPane record_scroll;
    private JScrollPane detailRecord_scroll;
    private JLabel chooseDate_label;
    private JLabel chooseEmployer_label;
    private JLabel chooseRecord_label;
    private JLabel dateCheckBox_label;
    private JLabel button_label;
    private JLabel dateRange_label;
    private JLabel tableCount_label;
    private JLabel note_label;
    private JTextField date_text;
    private JTextField record_text;
    private JTextField dateRangeStart_text;
    private JTextField dateRangeEnd_text;
    private JTextField detailNote_text;
    private JTextArea note_area;
    private JComboBox<String> employer_comboBox;
    private int tableSelectedRow = -1;

    public ViewRecord() {
        this.setLayout((LayoutManager)null);
        this.detailRecord_scroll = new JScrollPane(this.createTable(new String[0][], this.detailColumn_array));
        this.detailRecord_scroll.setBounds(525, 5, 400, 347);
        this.add(this.detailRecord_scroll);
        this.note_label = new JLabel("NOTE");
        this.note_label.setHorizontalAlignment(0);
        this.note_label.setBounds(this.detailRecord_scroll.getX(), 358, 400, 24);
        Font var1 = this.note_label.getFont();
        Map var2 = var1.getAttributes();
        var2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        this.note_label.setFont(var1.deriveFont(var2));
        this.add(this.note_label);
        this.note_area = new JTextArea();
        this.note_area.setBounds(this.note_label.getX(), this.note_label.getY() + this.note_label.getHeight(), this.note_label.getWidth(), 100);
        this.note_area.setBorder(new LineBorder(Color.CYAN));
        this.note_area.setEditable(false);
        this.add(this.note_area);
        this.data_2array = this.idConvertName(this.getData("employer_record", "all"), "employer", 1);
        this.record_scroll = new JScrollPane(this.createTable(this.data_2array, this.column_array));
        this.record_scroll.setBounds(5, 5, 500, 323);
        this.add(this.record_scroll);
        this.detail_button = new JButton("View detail");
        this.detail_button.setBounds(this.record_scroll.getX(), this.record_scroll.getY() + 323, 500, 24);
        this.detail_button.setFocusPainted(false);
        this.detail_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                if (((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getSelectedRow() != -1) {
                    if (ViewRecord.this.tableSelectedRow != ((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getSelectedRow()) {
                        ViewRecord.this.tableSelectedRow = ((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getSelectedRow();
                        String var2 = (String)((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getValueAt(ViewRecord.this.tableSelectedRow, 0);
                        String var3 = ViewRecord.this.nameConvertToId("employer", (String)((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getValueAt(ViewRecord.this.tableSelectedRow, 1));
                        String var4 = (String)((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getValueAt(ViewRecord.this.tableSelectedRow, 2);
                        String var5 = (String)((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getValueAt(ViewRecord.this.tableSelectedRow, 3);
                        String var6 = (String)((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getValueAt(ViewRecord.this.tableSelectedRow, 4);
                        String var7 = (String)((JTable)ViewRecord.this.record_scroll.getViewport().getComponent(0)).getValueAt(ViewRecord.this.tableSelectedRow, 5);
                        System.out.println(var2 + " " + var3 + " " + var4 + " " + var5 + " " + var6 + " " + var7);
                        String[][] var8 = ViewRecord.this.getData("employer_record", var3 + "," + var4);
                        System.out.println("Length = " + var8.length);

                        for(int var9 = 0; var9 < var8.length; ++var9) {
                            for(int var10 = 0; var10 < var8.length; ++var10) {
                                System.out.print(var8[var9][var10] + " | ");
                            }

                            System.out.println("");
                        }

                        ViewRecord.this.note_area.setText(var5);
                        ViewRecord.this.revalidate();
                        ViewRecord.this.repaint();
                    } else {
                        JOptionPane.showOptionDialog((Component)null, "Already displayed", "CALM DOWN", 0, 2, (Icon)null, new Object[]{"OK I CALMED DOWN"}, 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Please select a row from the table", "NOT SELECTED", 2);
                }

            }
        });
        this.add(this.detail_button);
        this.tableCount_label = new JLabel(this.data_2array.length + " displaying");
        this.tableCount_label.setHorizontalAlignment(4);
        this.tableCount_label.setBounds(5, this.detail_button.getY() + this.detail_button.getHeight(), 500, 24);
        this.tableCount_label.setForeground(new Color(0, 180, 0));
        this.add(this.tableCount_label);
        this.chooseEmployer_label = new JLabel("Selection employer");
        this.chooseEmployer_label.setForeground(new Color(76, 76, 76));
        this.chooseEmployer_label.setBounds(76, 408, 125, 24);
        this.add(this.chooseEmployer_label);
        this.employer_2array = this.listConvertToArray(DataBase.getData("employer"));
        this.employer_comboBox = new JComboBox(this.listConvertToArray(DataBase.getData("employer"), 1, 2));
        this.employer_comboBox.setBounds(this.chooseEmployer_label.getX(), this.chooseEmployer_label.getY() + this.chooseEmployer_label.getHeight(), this.chooseEmployer_label.getWidth(), 24);
        this.employer_comboBox.setSelectedItem((Object)null);
        this.add(this.employer_comboBox);
        this.chooseDate_label = new JLabel("Selection date");
        this.chooseDate_label.setForeground(new Color(76, 76, 76));
        this.chooseDate_label.setBounds(this.chooseEmployer_label.getX() + this.chooseEmployer_label.getWidth() + 125, this.chooseEmployer_label.getY(), this.chooseEmployer_label.getWidth(), 24);
        this.add(this.chooseDate_label);
        this.date_text = new JTextField();
        this.date_text.setBounds(this.chooseDate_label.getX(), this.chooseDate_label.getY() + this.chooseDate_label.getHeight(), this.chooseEmployer_label.getWidth(), 24);
        this.add(this.date_text);
        this.date_checkBox = new JCheckBox();
        this.date_checkBox.setBounds(this.date_text.getX() - 3, this.date_text.getY() + this.date_text.getHeight(), 18, 24);
        this.date_checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent var1) {
                if (var1.getStateChange() == 2) {
                    ViewRecord.this.date_text.setText("");
                } else {
                   // ViewRecord.this.date_text.setText(LocalDate.now().makeConcatWithConstants<invokedynamic>(LocalDate.now()));
                }

            }
        });
        this.add(this.date_checkBox);
        this.dateCheckBox_label = new JLabel("Today");
        this.dateCheckBox_label.setForeground(new Color(146, 146, 146));
        this.dateCheckBox_label.setBounds(this.date_text.getX() + this.date_checkBox.getWidth(), this.date_checkBox.getY(), this.date_text.getWidth() - this.date_checkBox.getWidth(), 24);
        this.add(this.dateCheckBox_label);
        this.filter_button = new JButton("Fetch matching data");
        this.filter_button.setBounds(this.chooseEmployer_label.getX() + this.chooseEmployer_label.getWidth() / 2, this.date_text.getY() + this.date_text.getHeight() + 40, 500 - this.date_text.getWidth() - this.employer_comboBox.getWidth(), 24);
        this.filter_button.setFocusPainted(false);
        this.filter_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                ViewRecord.this.tableSelectedRow = -1;
                boolean var2 = false;
                boolean var3 = false;
                String var4 = (String)ViewRecord.this.employer_comboBox.getSelectedItem();
                int var5 = -1;
                String var6 = "";
                if (var4 != null) {
                    for(int var7 = 0; var7 < ViewRecord.this.employer_2array.length; ++var7) {
                        String var10001 = ViewRecord.this.employer_2array[var7][1];
                        if (var4.equals(var10001 + " " + ViewRecord.this.employer_2array[var7][2])) {
                            var5 = Integer.parseInt(ViewRecord.this.employer_2array[var7][0]);
                            var3 = true;
                            break;
                        }
                    }
                }

                String var10 = "";

                try {
                    if (!ViewRecord.this.date_text.getText().equals("")) {
                        (new SimpleDateFormat("yyyy-MM-dd")).parse(ViewRecord.this.date_text.getText());
                        var10 = ViewRecord.this.date_text.getText();
                    }

                    if (!var10.equals("")) {
                        var2 = true;
                    }
                } catch (ParseException var9) {
                    JOptionPane.showMessageDialog(ViewRecord.this, "incorrect date format", "Date", 0);
                }

                if (var2) {
                    var6 = var6 + "WHERE date='" + var10 + "'";
                }

                if (var3) {
                    if (var6.equals("")) {
                        var6 = var6 + "WHERE employer_id=" + var5;
                    } else {
                        var6 = var6 + " AND employer_id=" + var5;
                    }
                }

                if (var6.equals("")) {
                    ViewRecord.this.data_2array = new String[0][];
                } else {
                    ViewRecord.this.data_2array = ViewRecord.this.listConvertToArray(DataBase.getData("employer_record", var6));
                }

                System.out.println(var6);
                ViewRecord.this.record_scroll.getViewport().removeAll();
                ViewRecord.this.record_scroll.getViewport().add(ViewRecord.this.createTable(ViewRecord.this.idConvertName(ViewRecord.this.data_2array, "employer", 1), ViewRecord.this.column_array));
                ViewRecord.this.tableCount_label.setText(ViewRecord.this.data_2array.length + " displaying");
                ViewRecord.this.employer_comboBox.setSelectedItem((Object)null);
            }
        });
        this.add(this.filter_button);
        this.button_label = new JLabel("One or more can be selected");
        this.button_label.setBounds(this.filter_button.getX(), this.filter_button.getY() + this.filter_button.getHeight() + 10, this.filter_button.getWidth(), this.filter_button.getHeight());
        this.button_label.setHorizontalAlignment(0);
        this.button_label.setForeground(Color.RED);
        this.add(this.button_label);
        this.print_button = new JButton("Print the displayed data");
        this.print_button.setFocusPainted(false);
        this.print_button.setBackground(new Color(0, 188, 212));
        this.print_button.setBounds(this.note_area.getX(), this.note_area.getY() + this.note_area.getHeight() + 25, 400, 50);
        this.print_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
            }
        });
        this.add(this.print_button);
    }

    private String[][] idConvertName(String[][] var1, String var2, int var3) {
        String[][] var4 = var1;

        for(int var5 = 0; var5 < var1.length; ++var5) {
            String[] var10000 = var4[var5];
            String var10002 = ((String[])DataBase.getData(var2, "WHERE " + var2 + "_id='" + Integer.parseInt(var1[var5][var3]) + "'").get(0))[1];
            var10000[var3] = var10002 + " " + ((String[])DataBase.getData(var2, "WHERE " + var2 + "_id='" + Integer.parseInt(var1[var5][var3]) + "'").get(0))[2];
        }

        return var4;
    }

    private Component createTable(String[][] var1, String[] var2) {
        JTable var3 = new JTable(var1, var2) {
            DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
            DefaultTableCellRenderer renderLeft = new DefaultTableCellRenderer();

            {
                this.renderCenter.setHorizontalAlignment(0);
            }

            public boolean isCellEditable(int var1, int var2) {
                return false;
            }

            public TableCellRenderer getCellRenderer(int var1, int var2) {
                return this.renderCenter;
            }
        };
        var3.setRowHeight(25);
        var3.setSelectionMode(0);
        if (var2.length == 6) {
            var3.getColumnModel().getColumn(0).setPreferredWidth(18);
            var3.getColumnModel().getColumn(1).setPreferredWidth(150);
            var3.getColumnModel().getColumn(2).setPreferredWidth(80);
            var3.getColumnModel().getColumn(3).setPreferredWidth(30);
            var3.getColumnModel().getColumn(4).setPreferredWidth(100);
            var3.getColumnModel().getColumn(5).setPreferredWidth(25);
        } else if (var2.length == 4) {
            var3.getColumnModel().getColumn(0).setPreferredWidth(18);
            var3.getColumnModel().getColumn(0).setPreferredWidth(150);
            var3.getColumnModel().getColumn(0).setPreferredWidth(60);
            var3.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        return var3;
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
            StringTokenizer var4 = new StringTokenizer(var2, ",");
            var2 = "WHERE";
            var2 = var2 + " date='" + var4.nextToken() + "'";
            var2 = var2 + " AND employer_id=" + var4.nextToken();
            var3 = DataBase.getData(var1, var2);

            for(int var5 = 0; var5 < var3.size(); ++var5) {
                for(int var6 = 0; var6 < ((String[])var3.get(var5)).length; ++var6) {
                    PrintStream var10000 = System.out;
                    String[] var10001 = (String[])var3.get(var5);
                    var10000.print(var10001[var6] + " | ");
                }

                System.out.println("");
            }
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
        if (var3[0].length<Arrays.stream(var2).max().getAsInt()) {
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
        String[][] var3 = this.employer_2array;

        for(int var4 = 0; var4 < var3.length; ++var4) {
            if ((var3[var4][1] + " " + var3[var4][2]).equals(var2)) {
                return var3[var4][0];
            }
        }

        return null;
    }

    public String toString() {
        return "View Record";
    }
}
