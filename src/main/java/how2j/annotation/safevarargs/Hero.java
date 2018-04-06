package how2j.annotation.safevarargs;

public class Hero {
    String name;

    @SuppressWarnings({"rawtypes", "unused"})
//    @SafeVarargs
    public static <T> T getFirstOne(T... elements) {
        return elements.length > 0 ? elements[0] : null;
    }
}