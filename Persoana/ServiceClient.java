package Persoana;

import Produse.*;
import Repos.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceClient implements ClientInterface{

    private final DealerShipRepo dealerShipRepovar = DealerShipRepo.getInit();
    private final clientRepo clientRepovar = clientRepo.getInit();
    Scanner scanner = new Scanner(System.in);
    @Override
    public List<Client> getClienti() {
        return clientRepovar.findall();
    }

    @Override
    public Client afiseazaClientDupaID(int nr) throws SQLException {
        return clientRepovar.findOneClient(nr);
    }

    @Override
    public void stergeClientDupaID(int nr) {
        clientRepovar.delete(nr);
    }

    @Override
    public void seteazaProduseClientuluiDupaID(int nr, String produs) throws SQLException {
        clientRepovar.updateProduse(nr, produs);
    }
    public void printID_produse(){
        System.out.println("Format pt produse: ID_PRODUS[CATEGORIE_PRODUS]");
        System.out.println("Categorie masina combustibili fosili: 1");
        System.out.println("Categorie masina electrica: 2");
        System.out.println("Categorie masina hibrida: 3");
        System.out.println("Categorie ATV: 4");
        System.out.println("Categorie motocicleta: 5");
        System.out.println("Categorie bicicleta: 6");
    }
    @Override
    public Client citesteClient() throws SQLException {
        Client clientNou = new Client();

        System.out.println("Introduceti numele: ");
        clientNou.setNume(scanner.next());

        System.out.println("Introduceti mailul: ");
        clientNou.setMail(scanner.next());

        System.out.println("Introduceti varsta: ");
        int varsta = 0;
        int ok = 0;
        while(ok == 0) {
            varsta = scanner.nextInt();
            if (varsta < 18) {
                System.out.println("Nu puteti avea un client minor!");
            } else {
                clientNou.setVarsta(varsta);
                ok = 1;
            }
        }
        clientNou.setVarsta(varsta);

        System.out.println("Introduceti ID-ul dealershipului de la care cumpara acest client: ");
        int id_DS = scanner.nextInt();
        clientNou.setId_dealership(id_DS);

        System.out.println("Introduceti ID ul: ");
        clientNou.setId(scanner.nextInt());

        printID_produse();
        String produse_disponibile = dealerShipRepovar.getProduseFromDealerShipByID(id_DS);
        System.out.println("Produsele disponibile sunt: " + produse_disponibile);

        System.out.println("Introduceti numarul produselor pe care le cumpara clientul:");
        int nrProd = scanner.nextInt();
        while(nrProd > 0){
            System.out.println("Introduceti ID-ul si tipul produsului pe care il cumpara clientul: ");
            String produs = scanner.next();
            if (produse_disponibile.contains(produs) == false){
                System.out.println("Produsul nu este disponibil!");
                continue;
            }
            clientNou.setProd(produs);
            nrProd--;
        }

        clientRepovar.save(clientNou);
        return clientNou;
    }
}
