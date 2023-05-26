import Persoana.*;
import Produse.*;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import Sediu.*;
import FirmaDealerShip.*;
public class MainService {
    private ServiceAngajat AngajatService = new ServiceAngajat();
    private ServiceClient ClientService = new ServiceClient();
    private ServiceProdus ProdusService = new ServiceProdus();
    private ServiceDS DSservice = new ServiceDS();
    private ServiceSediu SediuService = new ServiceSediu();
    private Scanner scanner = new Scanner(System.in);
    private CSVService csvService = CSVService.getInstance();

    private static MainService instance;

    private MainService(){}

    public static MainService getInstance(){
        if(instance == null){
            instance = new MainService();
        }
        return instance;
    }

    public void printMenuPersoane(){
        System.out.println(" 0 - Angajat");
        System.out.println(" 1 - Client");
        System.out.println(" 2 - Exit");
    }

    public void MeniuPersoane() throws SQLException {
        while(true){
            printMenuPersoane();
            int opt;
            while(true){
                String line = scanner.nextLine();
                try {
                    opt = Integer.parseInt(line);
                    if(opt >= 0 && opt <=2) {
                        break;
                    } else {
                        System.out.println("Enter a number between 0 and 2");
                    }
                } catch (Exception e){
                    System.out.println("Enter a number between 0 and 2");
                }
            }
            if (opt == 0) {
                meniuAngajat();
            } else if (opt == 1) {
                MeniuClient();
            } else if (opt == 2) {
                break;
            }
        }
    }
    public void printMeniuAngajat(){
        System.out.println(" 0 - Afiseaza angajati");
        System.out.println(" 1 - Afiseaza un angajat identificat prin ID");
        System.out.println(" 2 - Citeste un angajat si insereaza-l");
        System.out.println(" 3 - Sterge un angajat");
        System.out.println(" 4 - Exit");
    }
    public void meniuAngajat(){
        while(true){
            printMeniuAngajat();
            int opt;
            while(true){
                String line = scanner.nextLine();
                try {
                    opt = Integer.parseInt(line);
                    if(opt >= 0 && opt <=4) {
                        break;
                    } else {
                        System.out.println("Enter a number between 0 and 4");
                    }
                } catch (Exception e){
                    System.out.println("Enter a number between 0 and 4");
                }
            }
            if (opt == 0) {
                if (AngajatService.getAngajati().size() == 0){
                    System.out.println("Nu exista niciun angajat momentan!");
                }else{
                    for(int i=0; i < AngajatService.getAngajati().size(); i++){
                        System.out.println(AngajatService.getAngajati().get(i));
                    }
                }
            } else if (opt == 1) {
                System.out.println("Introduceti ID-ul pe care il cautati: ");
                int idCautat = scanner.nextInt();
                if (idCautat < 0){
                    System.out.println("Acest id nu este valid");
                }else if(idCautat > AngajatService.getAngajati().size()){
                    System.out.println("Ati introdus un id prea mare");
                }else {
//                    if (AngajatService.getAngajatByID(idCautat) != null)
//                        System.out.println(AngajatService.getAngajatByID(idCautat));
//                    else System.out.println("Angajatul cu ID ul furnizat nu exista!");
//                }
                    System.out.println("de fixat");
                }
            }else if (opt == 2) {
                AngajatService.getAngajati().add(AngajatService.citesteAngajat());
            }else if (opt == 3) {
                System.out.println("Introduceti ID-ul angajatului pe care doriti sa-l stergeti: ");
                int idCautat = scanner.nextInt();
                if (idCautat < 0){
                    System.out.println("Acest id nu este valid!");
                }else if(idCautat > AngajatService.getAngajati().size()){
                    System.out.println("Ati introdus un id prea mare!");
                }else{
                    AngajatService.deleteAngajatByID(idCautat);
                    System.out.println("Ati sters angajatul cu ID: " + idCautat);
                }
            } else if (opt == 4) {
                break;
            }
        }
    }

    public void printMeniuClient(){
        System.out.println(" 0 - Afiseaza clienti");
        System.out.println(" 1 - Afiseaza un client identificat prin numarul de telefon");
        System.out.println(" 2 - Citeste un client si insereaza-l");
        System.out.println(" 3 - Sterge un client");
        System.out.println(" 4 - Adauga un produs pt un client identificat prin numarul de telefon");
        System.out.println(" 5 - Adauga mai multe produse pt un client identificat prin numarul de telefon");
        System.out.println(" 6 - Exit");
    }
    public void MeniuClient() throws SQLException {
        while(true){
            printMeniuClient();
            int opt;
            while(true){
                String line = scanner.nextLine();
                try {
                    opt = Integer.parseInt(line);
                    if(opt >= 0 && opt <=6) {
                        break;
                    } else {
                        System.out.println("Enter a number between 0 and 6");
                    }
                } catch (Exception e){
                    System.out.println("Enter a number between 0 and 6");
                }
            }
            if (opt == 0) {
                if (ClientService.getClienti().size() == 0){
                    System.out.println("Nu exista niciun angajat momentan!");
                }else{
                    for(int i=0; i < ClientService.getClienti().size(); i++){
                        System.out.println(ClientService.getClienti().get(i));
                    }
                }
            } else if (opt == 1) {
                System.out.println("Introduceti numarul de telefon al clientului pe care il cautati: ");
                String nrCautat = scanner.next();

//                if (ClientService.afiseazaClientDupaNrContact(nrCautat) != null)
//                    System.out.println(ClientService.afiseazaClientDupaNrContact(nrCautat));
//                else
//                    System.out.println("Angajatul cu numarul ul furnizat nu exista!");
            }else if (opt == 2) {
                ClientService.getClienti().add(ClientService.citesteClient());
            }else if (opt == 3) {
                System.out.println("Introduceti numarul angajatului pe care doriti sa-l stergeti: ");

                String nrCautat = scanner.next();
//                if(ClientService.afiseazaClientDupaNrContact(nrCautat) != null){
//                    ClientService.stergeClientDupaNrContact(nrCautat);
//                    System.out.println("Ati sters angajatul cu numarul: " + nrCautat);
//                }else
//                    System.out.println("Angajatul cu numarul ul furnizat nu exista!");
            } else if (opt == 4) {
                System.out.println("Introduceti numarul de telefon al clientului caruia doriti sa-i adaugati un produs: ");
                String nrCautat = scanner.next();
//                ClientService.adaugaProdusPentruClient(nrCautat, ProdusService.citesteProdusInFunctieDeOpt());
            }else if(opt==5){
                System.out.println("Introduceti ID-ului clientului caruia doriti sa-i setati produse: ");
                int nrCautat = scanner.nextInt();
                System.out.println("Introduceti noile produse: ");
                String prod = scanner.next();
                ClientService.seteazaProduseClientuluiDupaID(nrCautat, prod);
            }else if(opt==6)
                break;
        }
    }

    public void printMenuProdus(){
        System.out.println(" 0 - Afiseaza produse");
        System.out.println(" 1 - Afiseaza un produs identificat prin serie");
        System.out.println(" 2 - Citeste un produs si insereaza-l");
        System.out.println(" 3 - Sterge un produs");
        System.out.println(" 4 - Updateaza un produs");
        System.out.println(" 5 - Exit");
    }
    public void MeniuProdus() throws SQLException {
        while (true) {
            printMenuProdus();
            int opt;
            while (true) {
                opt = scanner.nextInt();
                if (opt >= 0 && opt <= 5) {
                    break;
                } else {
                    System.out.println("Enter a number between 0 and 5");
                }
            }
            if (opt == 0) {
                if (ProdusService.getProduse().size() == 0){
                    System.out.println("Nu exista niciun angajat momentan!");
                }else{
                    for(int i=0; i < ProdusService.getProduse().size(); i++){
                        System.out.println((ProdusService.getProduse().get(i)));
                    }
                }
            } else if (opt == 1) {
                System.out.println("Introduceti seria de fabricatie a produsului pe care doriti sa-l cautati: ");
                int seriedeFabricatie = scanner.nextInt();
//                System.out.println(ProdusService.getProdusBySeriedeFabricatie(seriedeFabricatie));
            } else if (opt == 2) {
                ProdusService.getProduse().add(ProdusService.citesteProdusInFunctieDeOpt());
            } else if (opt == 3) {
                System.out.println("Introduceti seria de fabricatie a produsului pe care doriti sa-l stergeti: ");
                int seriedeFabricatie = scanner.nextInt();
                ProdusService.deleteProdusBySeriedeFabricatie(seriedeFabricatie);
            } else if (opt == 4) {
                System.out.println("Introduceti seria de fabricatie a produsului pe care doriti sa-l modificati: ");
                int seriedeFabricatie = scanner.nextInt();
                ProdusService.updateProdusBySeriedeFabricatie(seriedeFabricatie);
            } else if (opt == 5) {
                break;
            }
        }
    }


    public void printMeniuSediu(){
        System.out.println(" 0 - Afiseaza sedii");
        System.out.println(" 1 - Afiseaza un sediu identificat prin locatie");
        System.out.println(" 2 - Citeste un sediu si insereaza-l");
        System.out.println(" 3 - Sterge un sediu");
        System.out.println(" 4 - Exit");
    }

//    public void meniuSediu(){
//        while(true) {
//            printMeniuSediu();
//            int opt;
//            while (true) {
//                String line = scanner.nextLine();
//                try {
//                    opt = Integer.parseInt(line);
//                    if (opt >= 0 && opt <= 5) {
//                        break;
//                    } else {
//                        System.out.println("Enter a number between 0 and 5");
//                    }
//                } catch (Exception e) {
//                    System.out.println("Enter a number between 0 and 5");
//                }
//            }
//            if (opt == 0) {
//                int ok = 0;
//                for (Map.Entry<String, Integer> entry : SediuService.getSedii().entrySet()) {
//                    String key = entry.getKey();
//                    int value = entry.getValue();
//                    System.out.println(key + ": " + value);
//                    ok=+1;
//                }
//                if (ok == 0){
//                    System.out.println("Nu exista niciun sediu momentan!");
//                }
//            } else if (opt == 1) {
//                System.out.println("Introduceti locatia sediului pe care doriti sa-l cautati: ");
//                String locatie = scanner.next();
//                if (SediuService.afiseazaSediuDupaLocatie(locatie) != null)
//                    System.out.println(SediuService.afiseazaSediuDupaLocatie(locatie));
//
//            } else if (opt == 2) {
//                Sediu newSediu = SediuService.citesteSediu();
//                SediuService.getSedii().put(newSediu.getLocatie(), newSediu.getNrStocuri());
//            } else if (opt == 3) {
//                System.out.println("Introduceti locatia sediului pe care doriti sa-l stergeti: ");
//                String locatie = scanner.next();
//                SediuService.stergeSediu(locatie);
//            } else if (opt == 4) {
//                break;
//            }
//        }
//    }
    //intai citesti produse, sediu si angajati
    //apoi incepi sa adaugi clienti (nu au voie sa aiba produse care nu s in lista de produse din dealership)
    //apoi crdu pe lista de dealershipuri
    public void printMeniuDS(){
        System.out.println(" 0 - Afiseaza dealershipuri");
        System.out.println(" 1 - Afiseaza un dealership identificat prin ID");
        System.out.println(" 2 - Citeste un dealership si insereaza-l");
        System.out.println(" 3 - Sterge un dealership");
        System.out.println(" 4 - Adauga clienti unui dealership");
        System.out.println(" 5 - Afiseaza clientii unui dealership identificat prin id");
        System.out.println(" 6 - Adauga un angajat unui dealership identificat prin id");
        System.out.println(" 7 - Afiseaza angajatii unui dealership identificat prin id");
        System.out.println(" 8 - Adauga un produs unui dealership identificat prin id");
        System.out.println(" 9 - Afiseaza produsele unui dealership identificat prin id");
        System.out.println(" 10 - Sterge un produs identificat prin serie pentru dealership identificat prin id");
        System.out.println(" 11 - Modifica numarul de stocuri al unui sediu pentru dealership identificat prin id");
        System.out.println(" 12 - Sterge un angajat dealership identificat prin id");
        System.out.println(" 13 - Sterge un client dealership identificat prin id");
        System.out.println(" 14 - Exit");
    }

    public void meniuDealerShip() throws Exception {
        this.csvService.addLine("Start app");
        while (true) {
            printMeniuDS();
            int opt;
            while (true) {
                String line = scanner.nextLine();
                try {
                    opt = Integer.parseInt(line);
                    if (opt >= 0 && opt <= 14) {
                        break;
                    } else {
                        System.out.println("Enter a number between 0 and 14");
                    }
                } catch (Exception e) {
                    System.out.println("Enter a number between 0 and 14");
                }
            }
            if (opt == 0) {
                int ok = 0;
                for (int i = 0; i < DSservice.getDealerShips().size(); i++) {
                    System.out.println(DSservice.getDealerShips().get(i));
                    ok = +1;
                }
                if (ok == 0) {
                    System.out.println("Nu exista niciun dealership momentan!");
                }
                this.csvService.addLine("Select all dealerships");

            } else if (opt == 1) {
                System.out.println("Introduceti id-ul dealershipului pe care doriti sa-l cautati: ");
                int id = scanner.nextInt();
                if(DSservice.getDealerShipsDupaId(id) == null){
                    System.out.println("Nu exista dealership cu acest id!");
                }else
                    if (DSservice.getDealerShipsDupaId(id) != null)
                        System.out.println(DSservice.getDealerShipsDupaId(id));
                    else {
                        System.out.println("Nu exista dealership cu acest id!");
                    }
                this.csvService.addLine("Select dealership by id: " + id);

            }else if(opt==2){
                DSservice.getDealerShips().add(DSservice.citesteDealerShip());
                this.csvService.addLine("Added new dealership");

            } else if (opt==3) {
                System.out.println("Introduceti id-ul dealershipului pe care doriti sa-l stergeti: ");
                int id = scanner.nextInt();
                try {
                    DSservice.stergeDealerShipDupaId(id);
                }catch (Exception e){
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Deleted dealerships with id: " + id);

            } else if (opt==4) {
                System.out.println("Introduceti id-ul dealershipului pe care doriti sa-i adaugati clienti: ");
                int id = scanner.nextInt();
                try {
                    DSservice.adaugaClientDealershipsDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Added clients to dealership with id: " + id);
            } else if (opt == 5) {
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try {
                    System.out.println("Clientii dealershipului cu id-ul " + id + " sunt: ");

                    DSservice.afiseazaDealerShipsClientiDupaId(id);
                } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Printed clients from dealership with id: " + id);

            }else if (opt == 7) {
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                System.out.println("Andajatii dealershipului cu id-ul " + id + " sunt: ");
                try {
                    DSservice.afiseazaDealerShipsAngajatiDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Printed employees from dealership with id: " + id);
            }else if (opt == 6) {
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try {
                    DSservice.adaugaAngajatDealershipsDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Added employee to dealership with id: " + id);
            }else if (opt == 8) {
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try{
                    DSservice.adaugaProduseDealershipsDupaId(id);
                }catch (Exception e){
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Added products to dealership with id: " + id);
            }else if(opt==9){
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try {
                    DSservice.afiseazaProduseDealershipsDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Printed products from dealership with id: " + id);
            }else if (opt == 11) {
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try {
                    DSservice.modificaNrStocuriDealershipsDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }

            }else if (opt == 10){
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try {
                    DSservice.stergeProduseDealershipsDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Deleted product from dealership with id: " + id);

            }else if (opt == 12) {
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try {
                    DSservice.stergeAngajatDealershipsDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Deleted employee from dealership with id: " + id);
            }else if (opt == 13) {
                int id=0;
                System.out.println("Introduceti id-ul dealershipului: ");
                id = scanner.nextInt();
                try {
                    DSservice.stergeClientDealershipsDupaId(id);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                this.csvService.addLine("Deleted client from dealership with id: " + id);
            }else if (opt == 14) {
                this.csvService.addLine("Exit from app");
                break;
            }
        }
    }
}
