package how2j.swing.component.checkbox;

import javax.swing.*;
import java.awt.*;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class TestGUI {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
        JCheckBox bCheckBox = new JCheckBox("物理英雄");
        //设置 为 默认被选中
        bCheckBox.setSelected(true);
        bCheckBox.setBounds(50, 50, 130, 30);
        JCheckBox bCheckBox2 = new JCheckBox("魔法 英雄");
        bCheckBox2.setBounds(50, 100, 130, 30);
        //判断 是否 被 选中
        System.out.println(bCheckBox2.isSelected());

        f.add(bCheckBox);
        f.add(bCheckBox2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}