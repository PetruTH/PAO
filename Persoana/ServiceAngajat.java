package Persoana;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Repos.*;

public class ServiceAngajat implements AngajatInterface{
    private List<Angajat> angajati = new ArrayList<>();

    private final angajatRepo angajatRepovar = angajatRepo.getInit();
    Scanner scanner = new Scanner(System.in);

    @Override
    public List<Angajat> getAngajati() {
        return angajatRepovar.findall();
    }

    @Override
    public Angajat getAngajatByID(int idAngajat) throws SQLException {
        return angajatRepovar.findOneAngajat(idAngajat);
    }

    @Override
    public void deleteAngajatByID(int idAngajat) {
        angajatRepovar.delete(idAngajat);
    }

    @Override
    public Angajat citesteAngajat() {
        Angajat angajatNou = new Angajat();
//        nume mail varsta salariu pozitie
        System.out.println("Introduceti id-ul: ");
        angajatNou.setId(scanner.nextInt());

        System.out.println("Introduceti numele: ");
        angajatNou.setNume(scanner.next());

        System.out.println("Introduceti mailul: ");
        angajatNou.setMail(scanner.next());

        System.out.println("Introduceti pozitia ocupata de noul angajat in firma: ");
        angajatNou.setPozitie(scanner.next());

        System.out.println("Introduceti varsta: ");
        int varsta = 0;
        int ok = 0;
        while(ok == 0){
            varsta = scanner.nextInt();
            if(varsta < 18){
                System.out.println("Nu puteti angaja o persoana minora!");
            }else if(varsta > 65){
                System.out.println("Nu puteti angaja o persoana cu o varsta mai mare de 64 de ani!");
            }else{
                ok = 1;
            }
        }
        angajatNou.setVarsta(varsta);

        System.out.println("Introduceti ID-ul dealershipului pentru care lucreaza acest angajat: ");
        int id_DS = scanner.nextInt();
        angajatNou.setId_dealership(id_DS);

        System.out.println("Introduceti salariul: ");
        angajatNou.setSalariu(scanner.nextInt());

        angajatRepovar.save(angajatNou);
        return angajatNou;
    }
}
