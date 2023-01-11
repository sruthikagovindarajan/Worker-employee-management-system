//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel backgroundImage;

    public HomePage() {
        this.setLayout((LayoutManager)null);
        this.backgroundImage = new JLabel();
        this.backgroundImage.setBounds(0, 0, AdminPanel.W_FRAME - AdminPanel.INSETS.left - AdminPanel.INSETS.right, AdminPanel.H_FRAME - AdminPanel.INSETS.bottom - AdminPanel.INSETS.top);
        this.backgroundImage.setIcon(new ImageIcon("src\\icons\\background_image.jpg"));
        this.add(this.backgroundImage);
    }

    public String toString() {
        return "Home Page";
    }
}
