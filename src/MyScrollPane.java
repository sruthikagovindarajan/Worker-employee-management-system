//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollPane extends JScrollPane {
    public MyScrollPane(Component var1, int var2, int var3) {
        super(var1, 21, 31);
        this.getVerticalScrollBar().setOpaque(false);
        this.setLayout(new ScrollPaneLayout() {
            public void layoutContainer(Container var1) {
                JScrollPane var2 = (JScrollPane)var1;
                Rectangle var3 = var2.getBounds();
                var3.x = var3.y = 0;
                Insets var4 = var1.getInsets();
                var3.x = var4.left;
                var3.y = var4.top;
                var3.width -= var4.left + var4.right;
                var3.height -= var4.top + var4.bottom;
                Rectangle var5 = new Rectangle();
                var5.width = 12;
                var5.height = var3.height;
                var5.x = var3.x + var3.width - var5.width;
                var5.y = var3.y;
                if (this.viewport != null) {
                    this.viewport.setBounds(var3);
                }

                if (this.vsb != null) {
                    this.vsb.setVisible(true);
                    this.vsb.setBounds(var5);
                }

            }
        });
        this.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            private final Dimension d = new Dimension();

            protected JButton createDecreaseButton(int var1) {
                return new JButton() {
                    public Dimension getPreferredSize() {
                        return d;
                    }
                };
            }

            protected JButton createIncreaseButton(int var1) {
                return new JButton() {
                    public Dimension getPreferredSize() {
                        return d;
                    }
                };
            }

            protected void paintTrack(Graphics var1, JComponent var2, Rectangle var3) {
            }

            protected void paintThumb(Graphics var1, JComponent var2, Rectangle var3) {
                Graphics2D var4 = (Graphics2D)var1.create();
                var4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color var5 = null;
                JScrollBar var6 = (JScrollBar)var2;
                if (var6.isEnabled() && var3.width <= var3.height) {
                    if (this.isDragging) {
                        var5 = new Color(200, 200, 100, 220);
                    } else if (this.isThumbRollover()) {
                        var5 = new Color(255, 255, 100, 220);
                    } else {
                        var5 = new Color(220, 220, 200, 220);
                    }

                    var4.setPaint(var5);
                    var4.fillRoundRect(var3.x, var3.y, var3.width, var3.height, 10, 10);
                    var4.setPaint(Color.WHITE);
                    var4.drawRoundRect(var3.x, var3.y, var3.width, var3.height, 10, 10);
                    var4.dispose();
                }
            }

            protected void setThumbBounds(int var1, int var2, int var3, int var4) {
                super.setThumbBounds(var1, var2, var3, var4);
                this.scrollbar.repaint();
            }
        });
    }

    public MyScrollPane(Component var1) {
        this(var1, 0, 1);
    }
}
