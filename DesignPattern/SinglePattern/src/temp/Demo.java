package temp;

public class Demo {
    public static void main(String[] args) {
        Enumtest.C.setId("aaa");
        Enumtest A= Enumtest.C;
        System.out.println(A.getId());
        System.out.println(A.hashCode());
        System.out.println(Enumtest.C.hashCode());
    }
}
