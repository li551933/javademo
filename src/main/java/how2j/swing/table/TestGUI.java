package how2j.swing.table;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTable;

public class TestGUI {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        // 表格上的title
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        // 表格中的内容，是一个二维数组
        String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
        JTable t = new JTable(heros, columnNames);
        f.add(t, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}