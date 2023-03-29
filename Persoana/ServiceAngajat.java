package Persoana;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ServiceAngajat implements AngajatInterface{
    private List<Angajat> angajati = new ArrayList<>();
    private static ServiceAngajat instance;
    Scanner scanner = new Scanner(System.in);
    public ServiceAngajat() {

    }
    public static ServiceAngajat getInstance(){
        if(instance == null){
            instance = new ServiceAngajat();
        }
        return instance;
    }
    @Override
    public List<Angajat> getAngajati() {
        return this.angajati;
    }

    @Override
    public Angajat getAngajatByID(int idAngajat) {
        for(int i=0; i < angajati.size(); i++){
            if(i+1==idAngajat){
                return this.angajati.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteAngajatByID(int idAngajat) {
        for(int i=0; i<this.angajati.size(); i++){
            if(i+1 == idAngajat){
                this.angajati.remove(i);
            }
        }
    }

    @Override
    public Angajat citesteAngajat() {
        Angajat angajatNou = new Angajat();
//        nume mail varsta salariu pozitie
        System.out.println("Introduceti numele: ");
        angajatNou.setNume(scanner.nextLine());

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

        System.out.println("Introduceti salariul: ");
        angajatNou.setSalariu(scanner.nextInt());

        
        return angajatNou;
    }
}
