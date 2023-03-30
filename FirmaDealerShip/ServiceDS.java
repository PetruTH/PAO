package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ServiceDS implements dsInterface{
    private List<DealerShip> dealerships = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private static ServiceDS instance = null;
    private ServiceDS() {
    }
    public static ServiceDS getInstance() {
        if (instance == null) {
            instance = new ServiceDS();
        }
        return instance;
    }
    @Override
    public DealerShip citesteDealerShip() {
        ServiceProdus prodService = ServiceProdus.getInstance();
        ServiceAngajat angService = ServiceAngajat.getInstance();
        ServiceClient clientService = ServiceClient.getInstance();
        ServiceSediu sediuService = ServiceSediu.getInstance();

        System.out.println("Introduceti numele dealerShip-ului: ");
        String nume = scanner.next();
        System.out.println("Introduceti numarul de angajati: ");
        int nrAngajati = scanner.nextInt();

        List<Angajat> angajati = new ArrayList<>();
        for (int i = 0; i < nrAngajati; i++) {
            angajati.add(angService.citesteAngajat());
        }

        System.out.println("Introduceti numarul de produse: ");
        int nrProduse = scanner.nextInt();
        List<Produse> produse = new ArrayList<>();
        for (int i = 0; i < nrProduse; i++) {
            produse.add(prodService.citesteProdusInFunctieDeOpt());
        }

        List<Client> clienti = new ArrayList<>();
        DealerShip ds = new DealerShip();
        ds.setNume(nume);
        ds.setAngajati(angajati);
        ds.setProduses(produse);
        ds.setClienti(clienti);
        ds.setSediu(sediuService.citesteSediu());
        return ds;
    }

    public void citesteDealerShipClienti(int id) throws Exception {
        int ok=1;
        ServiceClient clientService = ServiceClient.getInstance();
        if(getDealerShipsDupaId(id) == null) {
            System.out.println("Nu exista dealerShip cu id-ul respectiv");
            ok=0;
        }else {
            List<Client> clienti = getDealerShipsDupaId(id).getClienti();
            System.out.println("Introduceti numarul de clienti: ");
            int nrClienti = scanner.nextInt();
            for (int i = 0; i < nrClienti; i++) {
                Client newClient = clientService.citesteClient();
                int nrProduse = scanner.nextInt();
                Produse[] produse = new Produse[nrProduse];
                for(int j=0; j < nrProduse; j++) {
                    System.out.println("Introduceti seria produsului: ");
                    String serie = scanner.next();
                    int produsAdaugat = 0;
                    List<Produse> prodDeVerificat = new ArrayList<>();
                    prodDeVerificat = getDealerShipsDupaId(id).getProduses();
                    for (int k = 0; k < prodDeVerificat.size(); k++) {
                        if(prodDeVerificat.get(k).getSerieFabricatie().equals(serie)) {
                            produse[j] = prodDeVerificat.get(k);
                            produsAdaugat = 1;
                        }
                    }
                    if(produsAdaugat == 0){
                        System.out.println("Nu exista produsul cu seria introdusa");
                        j-=1;
                    }else
                        System.out.println("Produsul a fost adaugat in cosul clientului");
                }
                newClient.setProd(produse);
                clienti.add(newClient);

            }
            getDealerShipsDupaId(id).setClienti(clienti);
        }
        if(ok==0){
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        }else {
            System.out.println("Clientii au fost adaugati in dealerShip-ul cu id-ul " + id);
        }
    }

    @Override
    public List<DealerShip> getDealerShips() {
        return this.dealerships;
    }

    @Override
    public void stergeDealerShipDupaId(int id) throws Exception {
        int ok=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                dealerships.remove(i);
                ok=1;
            }
        }
        if(ok==0){
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        }else {
            System.out.println("DealerShip-ul cu id-ul " + id + " a fost sters");
        }
    }

    @Override
    public DealerShip getDealerShipsDupaId(int id) {
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                return (dealerships.get(i));
            }
        }
        return null;
    }

    @Override
    public void afiseazaDealerShipsClientiDupaId(int id) throws Exception {
        int ok=0;
        int okClienti=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                for(int j=0; j<dealerships.get(i).getClienti().size(); j++){
                    okClienti=1;
                    System.out.println(dealerships.get(i).getClienti().get(j).toString());
                }
                ok=1;
            }
        }
        if(ok==0){
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        }else if(okClienti==0){
            throw new Exception("Nu exista clienti in dealerShip-ul cu id-ul " + id);
        }
    }

    @Override
    public void afiseazaDealerShipsAngajatiDupaId(int id) throws Exception {
        int ok=0;
        int okAngajati=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                for(int j=0; j<dealerships.get(i).getAngajati().size(); j++){
                    okAngajati=1;
                    System.out.println(dealerships.get(i).getAngajati().get(j).toString());
                }
                ok=1;
            }
        }
        if (ok == 0) {
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        } else if (okAngajati == 0) {
            throw new Exception("Nu exista angajati in dealerShip-ul cu id-ul " + id);
        }
    }

    @Override
    public void adaugaAngajatDealershipsDupaId(int id) throws Exception {
        int ok=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                dealerships.get(i).getAngajati().add(ServiceAngajat.getInstance().citesteAngajat());
                dealerships.get(i).getAngajati().sort(Comparator.comparing(Angajat::getSalariu));
                ok=1;
            }
            }
        if (ok==0){
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        }else{
            System.out.println("Angajatul a fost adaugat in dealerShip-ul cu id-ul " + id);
        }
    }

    @Override
    public void adaugaProduseDealershipsDupaId(int id) throws Exception {
        int ok=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                if(dealerships.get(i).getProduses().size() < dealerships.get(i).getSediu().getNrStocuri()){
                    dealerships.get(i).getProduses().add(ServiceProdus.getInstance().citesteProdusInFunctieDeOpt());
                }else{
                    throw new Exception("Nu mai exista spatiu in stoc");
                }
            }
            ok=1;
        }
        if (ok==0){
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        }else{
            System.out.println("Produsul a fost adaugat in dealerShip-ul cu id-ul " + id);
        }
    }

    @Override
    public void afiseazaProduseDealershipsDupaId(int id) throws Exception {
        int ok=0;
        int okProduse=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                for(int j=0; j<dealerships.get(i).getProduses().size(); j++){
                    okProduse=1;
                    System.out.println(dealerships.get(i).getProduses().get(j).toString());
                }
                ok=1;
            }
        }
        if (ok == 0) {
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        } else if (okProduse == 0) {
            throw new Exception("Nu exista produse in dealerShip-ul cu id-ul " + id);
        }
    }

    @Override
    public void modificaNrStocuriDealershipsDupaId(int id) throws Exception {
        int ok=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                System.out.println("Introduceti numarul de stocuri dorit");
                int nrStocuri = scanner.nextInt();
                dealerships.get(i).getSediu().setNrStocuri(nrStocuri);
                ok=1;
            }
        }
        if (ok==0){
            throw new Exception("Nu exista dealerShip cu id-ul " + id);
        }else{
            System.out.println("Numarul de stocuri a fost modificat in dealerShip-ul cu id-ul " + id);
        }
    }
}
