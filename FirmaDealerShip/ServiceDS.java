package FirmaDealerShip;
import Persoana.*;
import Repos.DealerShipRepo;
import Sediu.*;
import Produse.*;

import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceDS implements dsInterface{

    private DealerShipRepo dealerShipRepoVar = DealerShipRepo.getInit();
    private List<DealerShip> dealerships = new ArrayList<>();
    private ServiceProdus produseService = new ServiceProdus();
    private ServiceAngajat angajatiService = new ServiceAngajat();
    private ServiceClient clientiService = new ServiceClient();
    private ServiceSediu sediuService = new ServiceSediu();
    Scanner scanner = new Scanner(System.in);

    @Override
    public DealerShip citesteDealerShip() throws Exception {
        DealerShip ds = new DealerShip();

        System.out.println("Introduceti ID-ul dealerShip-ului: ");
        int id = scanner.nextInt();

        System.out.println("Introduceti numele dealerShip-ului: ");
        String nume = scanner.next();

        System.out.println("Introduceti angajatii (format ID_ANGAJAT,ID_ANGAJAT) sau 0 daca nu exista");
        String angajati = scanner.next();

        System.out.println("Introduceti clientii (format ID_ANGAJAT,ID_ANGAJAT) sau 0 daca nu exista");
        String clienti = scanner.next();

        System.out.println("Introduceti sediul (format ID_SEDIU) sau 0 daca nu exista");
        int sediu = scanner.nextInt();

        System.out.println("Introduceti produsele (format ID_PRODUS,ID_PRODUS) sau 0 daca nu exista");
        String produse = scanner.next();

        ds.setId(id);
        ds.setProduses(produse);
        ds.setSediu(sediu);
        ds.setNume(nume);
        ds.setAngajati(angajati);
        ds.setClienti(clienti);
        dealerShipRepoVar.add(ds);
        return ds;
    }

    @Override
    public List<DealerShip> getDealerShips() {
        return dealerShipRepoVar.findall();
    }

    @Override
    public void stergeDealerShipDupaId(int id) throws Exception {
        dealerShipRepoVar.delete(id);
    }

    @Override
    public DealerShip getDealerShipsDupaId(int id) throws SQLException {
        DealerShip d = dealerShipRepoVar.findOneDealerShip(id);
        if (d == null) {
            System.out.println("Nu exista dealerShip cu id-ul " + id);
            return null;
        }
        return d;
    }

    @Override
    public void afiseazaDealerShipsClientiDupaId(int id) throws Exception {
        if(dealerShipRepoVar.getClientiFromDealerShipByID(id).equals("0")){
            System.out.println("Nu exista clienti in dealerShip-ul cu id-ul " + id);
            return;
        }
        String[] parts = dealerShipRepoVar.getClientiFromDealerShipByID(id).split(",");
        for(int i=0; i<parts.length; i++){
            System.out.println(clientiService.afiseazaClientDupaID(Integer.parseInt(parts[i])));
        }
    }

    @Override
    public void afiseazaDealerShipsAngajatiDupaId(int id) throws Exception {
        if(dealerShipRepoVar.getAngajatiFromDealerShipByID(id).equals("0")){
            System.out.println("Nu exista angajati in dealerShip-ul cu id-ul " + id);
            return;
        }
        String[] parts = dealerShipRepoVar.getAngajatiFromDealerShipByID(id).split(",");
        for(int i=0; i<parts.length; i++){
            System.out.println(angajatiService.getAngajatByID(Integer.parseInt(parts[i])));
        }
    }

    public void adaugaClientDealershipsDupaId(int id) throws SQLException {
        int ok=0;
        String old_clienti = dealerShipRepoVar.getClientiFromDealerShipByID(id);

        System.out.println("Din acest dealership pot fi achizitonate urmatoarele produse: ");
        System.out.println(dealerShipRepoVar.getProduseFromDealerShipByID(id));

        Client newClient = clientiService.citesteClient();

        if (old_clienti.equals("0")) {
            dealerShipRepoVar.updateClientiFromDealerShipByID(id, String.valueOf(newClient.getId()));
        } else {
            dealerShipRepoVar.updateClientiFromDealerShipByID(id, old_clienti + "," + newClient.getId());
        }

    }

    @Override
    public void adaugaAngajatDealershipsDupaId(int id) throws Exception {
        int ok=0;
        String old_angajati = dealerShipRepoVar.getAngajatiFromDealerShipByID(id);

        Angajat newAngajat = angajatiService.citesteAngajat();


        if (old_angajati.equals("0")) {
            dealerShipRepoVar.updateAngajatiFromDealerShipByID(id, String.valueOf(newAngajat.getId()));
        } else {
            dealerShipRepoVar.updateAngajatiFromDealerShipByID(id, old_angajati + "," + newAngajat.getId());
        }
    }

    @Override
    public void adaugaProduseDealershipsDupaId(int id) throws Exception {
        int ok=0;
        String old_produse = dealerShipRepoVar.getProduseFromDealerShipByID(id);
        if (old_produse.split(",").length >= sediuService.afiseazaSediuDupaID(dealerShipRepoVar.getSediuFromDealerShipByID(id)).getNrStocuri()) {
            System.out.println("Nu se mai pot adauga produse");
            return;
        }

        Produse newProdus = produseService.citesteProdusInFunctieDeOpt();

        if (old_produse.equals("0")) {
            dealerShipRepoVar.updateProduseFromDealerShipByID(id, String.valueOf(newProdus.getSerieFabricatie()) + "[" + newProdus.getTip() + "]" );
        } else {
            dealerShipRepoVar.updateProduseFromDealerShipByID(id, old_produse + "," + String.valueOf(newProdus.getSerieFabricatie()) + "[" + newProdus.getTip() + "]" );
        }

    }

    @Override
    public void afiseazaProduseDealershipsDupaId(int id) throws Exception {
        List<Integer> integers = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(dealerShipRepoVar.getProduseFromDealerShipByID(id));

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            integers.add(number);
        }

        for(int i=0; i<integers.size(); i+=2){
            int idProdus = integers.get(i);
            int tipProdus = integers.get(i+1);
            System.out.println(produseService.getProdusBySeriedeFabricatie(idProdus, tipProdus));
        }
    }

    public void afiseazaSediuDealershipsDupaId(int id) throws Exception {
        System.out.println(sediuService.afiseazaSediuDupaID(dealerShipRepoVar.getSediuFromDealerShipByID(id)));
    }
    @Override
    public void modificaNrStocuriDealershipsDupaId(int id) throws Exception {
        int ok = 0;

        System.out.println("Introduceti noul numar de stocuri");
        int new_nr_stocuri = scanner.nextInt();
        int id_sediu = dealerShipRepoVar.getSediuFromDealerShipByID(id);

        sediuService.updateNrStocuriSediuByID(id_sediu, new_nr_stocuri);

    }

    @Override
    public void stergeProduseDealershipsDupaId(int id) throws Exception {
        int ok = 0;
        int okDeleted = 0;
        System.out.println("Introduceti ID-ul produsului pe care doriti sa il stergeti");
        int idToDelete = scanner.nextInt();

        System.out.println("Introduceti tipul produsului pe care doriti sa il stergeti");
        String tip_to_delete = scanner.next();

        String old_produse = dealerShipRepoVar.getProduseFromDealerShipByID(id);
        String[] parts = old_produse.split(",");
        for (int i = 0; i < parts.length; i++) {
            String for_delete = idToDelete + "[" + tip_to_delete + "]";
            if (parts[i].equals(for_delete)) {
                okDeleted = 1;
                parts[i] = "";
            }
        }

        if (okDeleted == 0) {
            throw new Exception("Produsul pe care doriti sa-l stergeti nu exista " + idToDelete);
        } else {
            String new_produse = "";
            if (parts[0].equals("") && parts.length==1) {
                new_produse = "0";
            } else {
                for (int i = 0; i < parts.length; i++) {
                    if (!parts[i].equals("")) {
                        if (new_produse.equals("")) {
                            new_produse = parts[i];
                        } else {
                            new_produse = new_produse + "," + parts[i];
                        }
                    }
                }
            }
            dealerShipRepoVar.updateProduseFromDealerShipByID(id, new_produse);
        }
    }

    @Override
    public void stergeClientDealershipsDupaId(int id) throws Exception {
        int ok = 0;
        int okDeleted = 0;
        System.out.println("Introduceti ID-ul clientului pe care doriti sa il stergeti");
        int idToDelete = scanner.nextInt();
        String old_clienti = dealerShipRepoVar.getClientiFromDealerShipByID(id);
        String[] parts = old_clienti.split(",");
        for (int i = 0; i < parts.length; i++) {
            if (Integer.parseInt(parts[i]) == idToDelete) {
                okDeleted = 1;
                parts[i] = "";
            }
        }

        if (okDeleted == 0) {
            throw new Exception("Nu exista angajat cu id-ul " + idToDelete);
        } else {
            String new_clienti = "";
            if (parts[0].equals("") && parts.length==1) {
                new_clienti = "0";
            }else {
                for (int i = 0; i < parts.length; i++) {
                    if (!parts[i].equals("")) {
                        new_clienti += parts[i] + ",";
                    }
                }
            }
            String new_clienti_added = new_clienti.substring(0, new_clienti.length() - 1);
            dealerShipRepoVar.updateClientiFromDealerShipByID(id, new_clienti_added);
        }
    }

    @Override
    public void stergeAngajatDealershipsDupaId(int id) throws Exception {
        int ok = 0;
        int okDeleted = 0;
        System.out.println("Introduceti ID-ul angajatului pe care doriti sa il stergeti");
        int idToDelete = scanner.nextInt();
        String old_angajati = dealerShipRepoVar.getAngajatiFromDealerShipByID(id);
        String[] parts = old_angajati.split(",");
        for (int i = 0; i < parts.length; i++) {
            if (Integer.parseInt(parts[i]) == idToDelete) {
                okDeleted = 1;
                parts[i] = "";
            }
        }

        if (okDeleted == 0) {
            throw new Exception("Nu exista angajat cu id-ul " + idToDelete);
        } else {
            String new_angajati = "";
            if (parts[0].equals("") && parts.length==1) {
                new_angajati = "0";
            }else {
                for (int i = 0; i < parts.length; i++) {
                    if (!parts[i].equals("")) {
                        new_angajati += parts[i] + ",";
                    }
                }
            }
            String new_angajati_added = new_angajati.substring(0, new_angajati.length() - 1);
            dealerShipRepoVar.updateAngajatiFromDealerShipByID(id, new_angajati_added);
        }
    }
}
