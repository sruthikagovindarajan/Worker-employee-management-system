//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.PlainDocument;

public class NewRecord extends JPanel implements CaretListener, ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private final int LBX = 85;
    private final int LBY = 90;
    private final int LBW = 200;
    private final int LBH = 130;
    private final int LBS = 400;
    private final int SBH = 30;
    private final int SBW = 200;
    private final int BW = 120;
    private final int BH = 30;
    private final int BS = 70;
    private final String countText = "Selected : ";
    private JList<String> selectionBox_list;
    private JList<String> selectedBox_list;
    private DefaultListModel<String> selection_model;
    private DefaultListModel<String> selected_model;
    private DefaultListModel<String> data_model;
    private JTextField selectionSearchBox_text;
    private JTextField selectedSearchBox_text;
    private JTextField dateBox_text;
    private JScrollPane selection_scroll;
    private JScrollPane selected_scroll;
    private JScrollPane note_scroll;
    private JButton add_button;
    private JButton remove_button;
    private JButton save_button;
    private JLabel selectionBox_label;
    private JLabel selectedBox_label;
    private JLabel countText_label;
    private JLabel employer_label;
    private JLabel dateBox_label;
    private JLabel todayCheckBox_label;
    private JLabel selectionEmployer_label;
    private JLabel selectedEmployer_label;
    private JLabel selectionDate_label;
    private JLabel selectedDate_label;
    private JLabel note_label;
    private JLabel noteRemainderCharacter_label;
    private ArrayList<String[]> workerData_arrayList;
    private ArrayList<String[]> employerData_arrayList;
    private JTextArea note_textArea;
    private String logNote;
    private JCheckBox today_checkBox;
    private JComboBox<String> employer_comboBox;
    private DefaultComboBoxModel<String> employer_model;

    public NewRecord() {
        this.setLayout((LayoutManager)null);
        this.workerData_arrayList = DataBase.getData("worker");
        this.employerData_arrayList = DataBase.getData("employer");
        this.data_model = new DefaultListModel();

        String var10001;
        int var1;
        for(var1 = 0; var1 < this.workerData_arrayList.size(); ++var1) {
            DefaultListModel var10000 = this.data_model;
            var10001 = ((String[])this.workerData_arrayList.get(var1))[1];
            var10000.addElement(var10001 + " " + ((String[])this.workerData_arrayList.get(var1))[2]);
        }

        this.selection_model = this.data_model;
        this.employer_model = new DefaultComboBoxModel();

        for(var1 = 0; var1 < this.employerData_arrayList.size(); ++var1) {
            DefaultComboBoxModel var2 = this.employer_model;
            var10001 = ((String[])this.employerData_arrayList.get(var1))[1];
            var2.addElement(var10001 + " " + ((String[])this.employerData_arrayList.get(var1))[2]);
        }

        this.selected_model = new DefaultListModel();
        this.selectionBox_list = new JList(this.selection_model);
        this.selectionBox_list.setFixedCellHeight(24);
        this.selectionBox_list.setSelectionMode(0);
        this.selectionBox_list.addListSelectionListener(this);
        this.selectedBox_list = new JList(this.selected_model);
        this.selectedBox_list.setFixedCellHeight(24);
        this.selectedBox_list.setSelectionMode(0);
        this.selectedBox_list.addListSelectionListener(this);
        this.selection_scroll = new JScrollPane(this.selectionBox_list);
        this.selection_scroll.setBounds(85, 90, 200, 130);
        this.add(this.selection_scroll);
        this.selected_scroll = new JScrollPane(this.selectedBox_list);
        this.selected_scroll.setBounds(this.selection_scroll.getX() + 400 + 200, this.selection_scroll.getY(), 200, 130);
        this.add(this.selected_scroll);
        this.selectionBox_label = new JLabel("Worker List");
        this.selectionBox_label.setBounds(160, 10, 200, 50);
        this.add(this.selectionBox_label);
        this.selectedBox_label = new JLabel("Selected List");
        this.selectedBox_label.setBounds(735, this.selectionBox_label.getY(), 200, 50);
        this.add(this.selectedBox_label);
        this.countText_label = new JLabel("Selected : " + this.selected_model.getSize());
        this.countText_label.setBounds(685, 215, 200, 30);
        this.add(this.countText_label);
        this.employer_label = new JLabel("Choose employer");
        this.employer_label.setBounds(85, 290, 200, 24);
        this.add(this.employer_label);
        this.selectionEmployer_label = new JLabel("Selected employer");
        this.selectionEmployer_label.setBounds(this.employer_label.getX() + 200 + 400, this.employer_label.getY(), 200, 24);
        this.add(this.selectionEmployer_label);
        this.employer_comboBox = new JComboBox(this.employer_model);
        this.employer_comboBox.setSelectedItem((Object)null);
        this.employer_comboBox.setBounds(85, this.employer_label.getY() + this.employer_label.getHeight(), 200, 24);
        this.employer_comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                NewRecord.this.selectedEmployer_label.setText((String)NewRecord.this.employer_comboBox.getSelectedItem());
            }
        });
        this.add(this.employer_comboBox);
        this.selectedEmployer_label = new JLabel((String)this.employer_comboBox.getSelectedItem());
        this.selectedEmployer_label.setFont(new Font("SansSerif", 3, 16));
        this.selectedEmployer_label.setForeground(Color.gray);
        this.selectedEmployer_label.setBounds(this.employer_comboBox.getX() + 200 + 400, this.employer_comboBox.getY(), 200, 24);
        this.add(this.selectedEmployer_label);
        this.dateBox_label = new JLabel("Choose date (YYYY-MM-DD)");
        this.dateBox_label.setBounds(85, this.employer_comboBox.getY() + this.employer_comboBox.getHeight() + 50, 200, 24);
        this.add(this.dateBox_label);
        this.selectionDate_label = new JLabel("Selected date");
        this.selectionDate_label.setBounds(this.dateBox_label.getX() + 200 + 400, this.dateBox_label.getY(), 200, 24);
        this.add(this.selectionDate_label);
        this.dateBox_text = new JTextField();
        this.dateBox_text.setDocument(new PlainDocument());
        this.dateBox_text.setBounds(this.dateBox_label.getX(), this.dateBox_label.getY() + this.dateBox_label.getHeight(), 200, 24);
        this.dateBox_text.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent var1) {
                NewRecord.this.selectedDate_label.setText(NewRecord.this.dateBox_text.getText());
            }
        });
        this.add(this.dateBox_text);
        this.selectedDate_label = new JLabel(this.dateBox_text.getText());
        this.selectedDate_label.setBounds(this.dateBox_text.getX() + 200 + 400, this.dateBox_text.getY(), 200, 24);
        this.selectedDate_label.setFont(this.selectedEmployer_label.getFont());
        this.selectedDate_label.setForeground(Color.gray);
        this.add(this.selectedDate_label);
        this.today_checkBox = new JCheckBox();
        this.today_checkBox.setBounds(this.dateBox_text.getX(), this.dateBox_text.getY() + this.dateBox_text.getHeight(), 18, 18);
        this.today_checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent var1) {
                if (var1.getStateChange() == 2) {
                    NewRecord.this.dateBox_text.setText("");
                } else if (var1.getStateChange() == 1) {
                 //   NewRecord.this.dateBox_text.setText(LocalDate.now().makeConcatWithConstants<invokedynamic>(LocalDate.now()));
                }

            }
        });
        this.add(this.today_checkBox);
        this.todayCheckBox_label = new JLabel("Today");
        this.todayCheckBox_label.setBounds(this.today_checkBox.getX() + this.today_checkBox.getWidth() + 5, this.today_checkBox.getY(), 200 - this.today_checkBox.getWidth(), 18);
        this.add(this.todayCheckBox_label);
        this.note_label = new JLabel("NOTE");
        this.note_label.setBounds(this.dateBox_label.getX(), this.dateBox_label.getY() + 80, 200, 24);
        this.add(this.note_label);
        this.note_textArea = new JTextArea();
        this.note_textArea.setBounds(0, 0, 400, 60);
        this.note_textArea.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent var1) {
                if (NewRecord.this.note_textArea.getText().length() < 256) {
                    NewRecord.this.logNote = NewRecord.this.note_textArea.getText();
                    NewRecord.this.noteRemainderCharacter_label.setText("Limited to 255 characters (Remainder : " + (255 - NewRecord.this.logNote.length()) + " )");
                    NewRecord.this.noteRemainderCharacter_label.setForeground(new Color(0, 190, 0));
                } else {
                    NewRecord.this.note_textArea.setText(NewRecord.this.logNote);
                    NewRecord.this.noteRemainderCharacter_label.setForeground(new Color(190, 0, 0));
                }

            }
        });
        this.note_scroll = new JScrollPane(this.note_textArea);
        this.note_scroll.setBounds(this.note_label.getX(), this.note_label.getY() + this.note_label.getHeight(), 400, 60);
        this.add(this.note_scroll);
        this.noteRemainderCharacter_label = new JLabel("Limited to 255 characters (Remainder : )");
        this.noteRemainderCharacter_label.setFont(new Font("Dialog", 2, 9));
        this.noteRemainderCharacter_label.setForeground(new Color(0, 190, 0));
        this.noteRemainderCharacter_label.setBounds(this.note_scroll.getX(), this.note_scroll.getY() + this.note_scroll.getHeight(), 200, 24);
        this.add(this.noteRemainderCharacter_label);
        this.add_button = new JButton("Add");
        this.add_button.setFocusPainted(false);
        this.add_button.setEnabled(false);
        this.add_button.setBackground(Color.gray);
        this.add_button.setBounds(425, 95, 120, 30);
        this.add_button.addActionListener(this);
        this.add(this.add_button);
        this.remove_button = new JButton("Remove");
        this.remove_button.setFocusPainted(false);
        this.remove_button.setEnabled(false);
        this.remove_button.setBackground(Color.gray);
        this.remove_button.setBounds(425, this.add_button.getY() + 70, 120, 30);
        this.remove_button.addActionListener(this);
        this.add(this.remove_button);
        this.selectionSearchBox_text = new JTextField();
        this.selectionSearchBox_text.setBounds(85, 60, 200, 30);
        this.selectionSearchBox_text.addCaretListener(this);
        this.add(this.selectionSearchBox_text);
        this.selectedSearchBox_text = new JTextField();
        this.selectedSearchBox_text.setBounds(685, 60, 200, 30);
        this.selectedSearchBox_text.addCaretListener(this);
        this.add(this.selectedSearchBox_text);
        this.save_button = new JButton("SAVE");
        this.save_button.setBounds(this.note_scroll.getX() + 200 + 400, this.note_scroll.getY(), 200, this.note_scroll.getHeight() - 10);
        this.save_button.setFocusPainted(false);
        this.save_button.setBackground(Color.CYAN);
        this.save_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
                boolean var2 = false;

                try {
                    (new SimpleDateFormat("yyyy-MM-dd")).parse(NewRecord.this.dateBox_text.getText());
                    var2 = true;
                } catch (ParseException var15) {
                }

                if (NewRecord.this.selected_model.getSize() > 0 && NewRecord.this.employer_comboBox.getSelectedItem() != null) {
                    String var8 = "";

                    for(int var9 = 0; var9 < NewRecord.this.selected_model.getSize(); ++var9) {
                        var8 = var8 + (var9 + 1) + " - " + (String)NewRecord.this.selected_model.getElementAt(var9) + "\n";
                    }

                    JTextArea var3 = new JTextArea((String)NewRecord.this.employer_comboBox.getSelectedItem());
                    var3.setEditable(false);
                    JTextArea var4 = new JTextArea(var8);
                    var4.setEditable(false);
                    JTextArea var5 = new JTextArea(NewRecord.this.dateBox_text.getText());
                    var5.setEditable(false);
                    JTextArea var6 = new JTextArea(NewRecord.this.selected_model.getSize() + " Workers");
                    var6.setEditable(false);
                    JTextArea var7 = new JTextArea(NewRecord.this.note_textArea.getText());
                    var7.setEditable(false);
                    JScrollPane var16 = new JScrollPane(var4) {
                        public Dimension getPreferredSize() {
                            return new Dimension(300, 200);
                        }
                    };
                    JScrollPane var10 = new JScrollPane(var7) {
                        public Dimension getPreferredSize() {
                            return new Dimension(300, 100);
                        }
                    };
                    if (var2) {
                        Object[] var11 = new Object[]{new JLabel("Employer"), var3, new JLabel("Workers"), var16, new JLabel("Date"), var5, new JLabel("Selected workers"), var6, new JLabel("Note"), var10};
                        int var12 = JOptionPane.showOptionDialog(NewRecord.this, var11, "DOCUMENT", 1, 1, new ImageIcon("src\\icons\\accounting_icon_1_32.png"), new Object[]{"SAVE", "CANCEL"}, "CANCEL");
                        if (var12 == 0) {
                            String[] var13 = new String[NewRecord.this.selected_model.getSize()];

                            int var14;
                            for(var14 = var13.length - 1; var14 >= 0; --var14) {
                                var13[var14] = NewRecord.this.getPersonId(NewRecord.this.workerData_arrayList, (String)NewRecord.this.selected_model.get(var14));
                            }

                            var14 = DataBase.addRecord(NewRecord.this.getPersonId(NewRecord.this.employerData_arrayList, var3.getText()), var5.getText(), var13, var7.getText());
                            if (var14 == 1) {
                                JOptionPane.showMessageDialog(NewRecord.this, "SAVED", "SUCCESSFUL", 1);
                                NewRecord.this.clearPanel();
                            } else {
                                JOptionPane.showMessageDialog(NewRecord.this, "NOT SAVED" + (var14 == 0 ? "" : "only " + var14 + " added") + "\nUnsaved, in selected box", "DATABASE ERROR", 0);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(NewRecord.this, "Please check the date field", "DATE", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(NewRecord.this, "Please fill in the blanks", "NULL", 0);
                }

            }
        });
        this.add(this.save_button);
    }

    public DefaultListModel<String> searchBoxSort(JTextField var1) {
        DefaultListModel var2 = null;
        DefaultListModel var3 = new DefaultListModel();
        if (var1 == this.selectionSearchBox_text) {
            var2 = this.selection_model;
        } else if (var1 == this.selectedSearchBox_text) {
            var2 = this.selected_model;
        }

        if (!var1.getText().equals("")) {
            if (var2 != null) {
                String var4 = var1.getText().toUpperCase();

                for(int var5 = 0; var5 < var2.getSize(); ++var5) {
                    if (((String)var2.get(var5)).contains(var4)) {
                        var3.addElement((String)var2.get(var5));
                    }
                }
            }
        } else {
            var3 = var2;
        }

        return var3;
    }

    public void actionPerformed(ActionEvent var1) {
        String var2;
        if (var1.getSource() == this.add_button && this.selectionBox_list.getSelectedValue() != null) {
            var2 = (String)this.selectionBox_list.getSelectedValue();
            this.selection_model.removeElement(var2);
            this.selected_model.addElement(var2);
            this.selectionSearchBox_text.setText("");
            this.add_button.setBackground(Color.gray);
            this.add_button.setEnabled(false);
        } else if (var1.getSource() == this.remove_button && this.selectedBox_list.getSelectedValue() != null) {
            var2 = (String)this.selectedBox_list.getSelectedValue();
            this.selected_model.removeElement(var2);
            this.selection_model.addElement(var2);
            this.selectedSearchBox_text.setText("");
            this.remove_button.setBackground(Color.gray);
            this.remove_button.setEnabled(false);
        }

        this.countText_label.setText("Selected : " + this.selected_model.getSize());
    }

    public void caretUpdate(CaretEvent var1) {
        if (var1.getSource() == this.selectionSearchBox_text) {
            this.selectionBox_list.setModel(this.searchBoxSort(this.selectionSearchBox_text));
        } else if (var1.getSource() == this.selectedSearchBox_text) {
            this.selectedBox_list.setModel(this.searchBoxSort(this.selectedSearchBox_text));
        }

    }

    public void valueChanged(ListSelectionEvent var1) {
        if (var1.getSource() == this.selectionBox_list && this.selectionBox_list.getSelectedValue() != null) {
            this.remove_button.setBackground(Color.gray);
            this.remove_button.setEnabled(false);
            this.add_button.setBackground(Color.green);
            this.add_button.setEnabled(true);
            this.selectedBox_list.clearSelection();
            this.selectedSearchBox_text.setText("");
        } else if (var1.getSource() == this.selectedBox_list && this.selectedBox_list.getSelectedValue() != null) {
            this.add_button.setBackground(Color.gray);
            this.add_button.setEnabled(false);
            this.remove_button.setBackground(Color.red);
            this.remove_button.setEnabled(true);
            this.selectionBox_list.clearSelection();
            this.selectionSearchBox_text.setText("");
        }

    }

    private String getPersonId(ArrayList<String[]> var1, String var2) {
        Iterator var3 = var1.iterator();

        String[] var4;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            var4 = (String[])var3.next();
        } while(!var2.equalsIgnoreCase(var4[1] + " " + var4[2]));

        return var4[0];
    }

    private void clearPanel() {
        while(this.selected_model.size() > 0) {
            this.selection_model.addElement((String)this.selected_model.remove(this.selected_model.size() - 1));
        }

        this.employer_comboBox.setSelectedIndex(-1);
        this.dateBox_text.setText("");
        this.today_checkBox.setSelected(false);
        this.selectedEmployer_label.setText("");
        this.selectedDate_label.setText("");
        this.note_textArea.setText("");
    }

    public String toString() {
        return "New Record";
    }
}
