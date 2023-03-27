package laborator3;
import laborator3.Lindt;
public class testLindt {
    public static void main(String[] str) {
        CandyBox lindt1 = new Lindt();
        lindt1.flavor = "dada";
        lindt1.origin = "nunu";
        CandyBox lindt2 = new Lindt("dada", "nunu", 1, 2,3);
        System.out.println(lindt2);
        System.out.println(lindt2.getVolume());
        CandyBox lindt3 = lindt1;

        System.out.println(lindt1.equals(lindt2));
        System.out.println(lindt2.equals(lindt3));
        System.out.println(lindt3.equals(lindt1));
    }
}
