package laborator2;
import java.lang.System;
import java.util.Scanner;

public class lab2_p2 {
    //citit numele si varsta apoi afisati numele si daca varsta e impara afisati toate nr impare mai mici sau impare cu varsta
    //iar daca e para afisati nr pare
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();

        System.out.println("Introduceti varsta: ");
        Integer varsta = scanner.nextInt();

        if (varsta%2 == 0) {
            for (Integer i = 0; i < varsta; i+=2) {
                System.out.println(i);
            }
        }else{
            for(Integer i = 1; i<varsta; i+=2){
                System.out.println(i);
            }
        }

        scanner.close();

    }
}
