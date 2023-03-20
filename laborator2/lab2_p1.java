package laborator2;

public class lab2_p1 {
    public static void main(String[] args){
        char c = 't';
        Character cc = c;
        Integer i1 = 4;
        Integer i2 = Integer.valueOf(4);
        Integer i3 = Integer.valueOf("4");

        System.out.println(i2==i3);

        Integer i4 = Integer.valueOf(128);
        Integer i5 = Integer.valueOf("128"); //pt nr in intervalul [-128, 127] face conversie

        System.out.println(i4 == i5);

        boolean b1 = Boolean.valueOf("true");
        System.out.println(b1);

        //      EROARE
//        Integer badInt = Integer.parseInt("fff");
//        System.out.println(badInt);

        // instanceof verifica daca tipul unui obiect este un subtip al altei clase
        System.out.println("instanceof: " + (i5 instanceof Number));
    }
}
