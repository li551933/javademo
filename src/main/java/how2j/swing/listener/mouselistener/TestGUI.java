package how2j.swing.listener.mouselistener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestGUI {
    public static void main(String[] args) {

        final JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("D:/IntellijIdeaWorkspace/how2j/resource/shana_heiheihei.png");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());

        f.add(l);

        l.addMouseListener(new MouseListener() {

            // 释放鼠标
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            // 按下鼠标
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            // 鼠标退出
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            // 鼠标进入
            public void mouseEntered(MouseEvent e) {

                Random r = new Random();

                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());

                l.setLocation(x, y);

            }

            // 按下释放组合动作为点击鼠标
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}