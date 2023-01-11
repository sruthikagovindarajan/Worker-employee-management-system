//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminPanel extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    public static final short WAGE = 100;
    public static final String NAME = "Registration System";
    public static int W_FRAME = 960;
    public static int H_FRAME;
    public static Insets INSETS;
    private JMenuBar menuBar_menubar;
    private JMenu homePage_menu;
    private JMenu record_menu;
    private JMenu view_menu;
    private JMenu bill_menu;
    private JMenu system_menu;
    private JMenuItem addEmployer_item;
    private JMenuItem addWorker_item;
    private JMenuItem addRecord_item;
    private JMenuItem viewRecord_item;
    private JMenuItem billEmployer_item;
    private JMenuItem billWorker_item;
    private JMenuItem settings_item;
    private JMenuItem reset_item;
    private JMenuItem logout_item;
    private HomePage homePage;
    private ArrayList<JPanel> components;
    private int currentComponent;

    public AdminPanel() {
        this(0);
    }

    public AdminPanel(int var1) {
        super("Registration System");
        this.components = new ArrayList();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\icons\\admin_user.png"));
        this.setSize(W_FRAME, H_FRAME);
        this.setResizable(false);
        this.setLayout((LayoutManager)null);
        this.setLocationRelativeTo((Component)null);
        this.setLocation(this.getX() - 40, this.getY() - 20);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.currentComponent = var1;
        INSETS = this.getInsets();
        this.GUI();
    }

    private void GUI() {
        this.createMenus();
        this.createComponents();
        this.init();
    }

    private void createMenus() {
        this.menuBar_menubar = new JMenuBar();
        this.homePage_menu = new JMenu("Home page");
        this.homePage_menu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent var1) {
                AdminPanel.this.currentComponent = 0;
                AdminPanel.this.init();
            }
        });
        this.record_menu = new JMenu("Record");
        this.view_menu = new JMenu("View");
        this.bill_menu = new JMenu("Bill");
        this.system_menu = new JMenu("System");
        this.addWorker_item = new JMenuItem("New worker");
        this.record_menu.add(this.addWorker_item);
        this.addWorker_item.addActionListener(this);
        this.addRecord_item = new JMenuItem("New record");
        this.record_menu.add(this.addRecord_item);
        this.addRecord_item.addActionListener(this);
        this.addEmployer_item = new JMenuItem("New employer");
        this.record_menu.add(this.addEmployer_item);
        this.addEmployer_item.addActionListener(this);
        this.viewRecord_item = new JMenuItem("View record");
        this.view_menu.add(this.viewRecord_item);
        this.viewRecord_item.addActionListener(this);
        this.billWorker_item = new JMenuItem("Worker payment");
        this.bill_menu.add(this.billWorker_item);
        this.billWorker_item.addActionListener(this);
        this.billEmployer_item = new JMenuItem("Employer payment");
        this.bill_menu.add(this.billEmployer_item);
        this.billEmployer_item.addActionListener(this);
        this.settings_item = new JMenuItem("Settings");
        this.system_menu.add(this.settings_item);
        this.settings_item.addActionListener(this);
        this.reset_item = new JMenuItem("Reset");
        this.system_menu.add(this.reset_item);
        this.reset_item.addActionListener(this);
        this.logout_item = new JMenuItem("Logout");
        this.system_menu.add(this.logout_item);
        this.logout_item.addActionListener(this);
        this.menuBar_menubar.add(this.homePage_menu);
        this.menuBar_menubar.add(this.record_menu);
        this.menuBar_menubar.add(this.view_menu);
        this.menuBar_menubar.add(this.bill_menu);
        this.menuBar_menubar.add(this.system_menu);
        this.setJMenuBar(this.menuBar_menubar);
    }

    private void createComponents() {
        this.components.add(new HomePage());
        this.components.add(new NewWorker());
        this.components.add(new NewRecord());
        this.components.add(new NewEmployer());
        this.components.add(new ViewRecord());
        this.components.add(new WorkerPayment());
        this.components.add(new EmployerPayment());
    }

    private void init() {
        this.setContentPane((Container)this.components.get(this.currentComponent));
        this.setTitle("Registration System - " + ((JPanel)this.components.get(this.currentComponent)).toString());
        this.revalidate();
        this.repaint();
    }

    public void actionPerformed(ActionEvent var1) {
        if (((JMenuItem)var1.getSource()).getText().equals(this.addWorker_item.getText())) {
            if (this.currentComponent == 1) {
                this.components.set(this.currentComponent, new NewWorker());
            } else {
                this.currentComponent = 1;
            }

            this.init();
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.addRecord_item.getText())) {
            if (this.currentComponent == 2) {
                this.components.set(this.currentComponent, new NewRecord());
            } else {
                this.currentComponent = 2;
            }

            this.init();
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.addEmployer_item.getText())) {
            if (this.currentComponent == 3) {
                this.components.set(this.currentComponent, new NewEmployer());
            } else {
                this.currentComponent = 3;
            }

            this.init();
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.viewRecord_item.getText())) {
            if (this.currentComponent == 4) {
                this.components.set(this.currentComponent, new ViewRecord());
            } else {
                this.currentComponent = 4;
            }

            this.init();
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.billWorker_item.getText())) {
            if (this.currentComponent == 5) {
                this.components.set(this.currentComponent, new WorkerPayment());
            } else {
                this.currentComponent = 5;
            }

            this.init();
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.billEmployer_item.getText())) {
            if (this.currentComponent == 6) {
                this.components.set(this.currentComponent, new EmployerPayment());
            } else {
                this.currentComponent = 6;
            }

            this.init();
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.settings_item.getText())) {
            JOptionPane.showMessageDialog(this, "Not available");
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.reset_item.getText())) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    AdminPanel.this.dispose();

                    try {
                        Thread.sleep(350L);
                    } catch (InterruptedException var2) {
                        var2.printStackTrace();
                    }

                    new AdminPanel(AdminPanel.this.currentComponent);
                }
            });
        } else if (((JMenuItem)var1.getSource()).getText().equals(this.logout_item.getText())) {
            this.dispose();
        }

    }

    static {
        H_FRAME = 2 * W_FRAME / 3;
    }
}
