package FirmaDealerShip;
import Persoana.*;
import Sediu.*;
import Produse.*;

import java.util.ArrayList;
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

        return new DealerShip(nume, clienti, angajati, sediuService.citesteSediu(), produse);
    }

    public void citesteDealerShipClienti(int id) {
        List<Client> clienti = new ArrayList<>();
        ServiceClient clientService = ServiceClient.getInstance();
        if(getDealerShipsDupaId(id) == null) {
            System.out.println("Nu exista dealerShip cu id-ul respectiv");
            return;
        }else {
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
//                citesti produse, verifici daca s in stoc apoi atribui unu cate unu in array
//                dupa dai set la newclient si adaugi clientu in lista pt ds
                clienti.add(newClient);

            }
            getDealerShipsDupaId(id).setClienti(clienti);
        }
    }

    @Override
    public List<DealerShip> getDealerShips() {
        return this.dealerships;
    }

    @Override
    public void stergeDealerShipDupaId(int id) {
        int ok=0;
        for (int i = 0; i < dealerships.size(); i++) {
            if (dealerships.get(i).getID() == id) {
                dealerships.remove(i);
                ok=1;
            }
        }
        if(ok==0){
            System.out.println("Nu exista dealerShip cu id-ul " + id);
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
}
