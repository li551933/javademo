package how2j.swing.container.jdialog;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);

        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态
        d.setModal(true);

        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
        d.add(b);

        f.setVisible(true);
        d.setVisible(true);

    }
}