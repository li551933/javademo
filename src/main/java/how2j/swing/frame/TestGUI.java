package how2j.swing.frame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGUI {
    public static void main(String[] args) {
        // 主窗体
        JFrame f = new JFrame("LoL");

        // 主窗体设置大小
        f.setSize(400, 800);

        // 主窗体设置位置
        f.setLocation(0, 0);

        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);

        // 按钮组件
        JButton b = new JButton("如履平地");

        // 同时设置组件的大小和位置
        b.setBounds(150, 150, 80, 300);

        // 把按钮加入到主窗体中
        f.add(b);

        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);

    }
}