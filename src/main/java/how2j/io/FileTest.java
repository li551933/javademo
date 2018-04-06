package how2j.io;

import how2j.swing.frame.thread.TestGUI;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/hust/file.txt");
        try (FileInputStream fis = new FileInputStream(file); DataInputStream dis = new DataInputStream(fis);) {
            int x = dis.readInt();
            int y = dis.readInt();

        } catch (FileNotFoundException e) {
            //第一次运行，并没有生成位置文件，所以会出现FileNotFoundException
            System.out.println("第一次运行，并没有生成位置文件");
        }
    }
}
