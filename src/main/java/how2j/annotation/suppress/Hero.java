package how2j.annotation.suppress;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unused" })

public class Hero {
    String name;
    @SuppressWarnings({ "rawtypes", "unused" })
    public static void main(String[] args) {
        List heros = new ArrayList();
    }

}