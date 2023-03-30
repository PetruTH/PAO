package Persoana;

import Produse.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceClient implements ClientInterface{
    private List<Client> clienti = new ArrayList<>();
    private static ServiceClient instance;
    Scanner scanner = new Scanner(System.in);
    public ServiceClient() {

    }
    public static ServiceClient getInstance(){
        if(instance == null){
            instance = new ServiceClient();
        }
        return instance;
    }

    @Override
    public List<Client> getClienti() {
        return this.clienti;
    }

    @Override
    public Client afiseazaClientDupaNrContact(String nr) {
        for(int i=0; i < clienti.size(); i++){
            if(clienti.get(i).getNrContact().equals(nr)){
                return clienti.get(i);
            }
        }
        return null;
    }

    @Override
    public void stergeClientDupaNrContact(String nr) {
        for(int i=0; i < clienti.size(); i++){
            if(clienti.get(i).getNrContact().equals(nr)){
                clienti.remove(i);
            }
        }
    }

    @Override
    public void adaugaProdusPentruClient(String nr, Produse produs) {
        Produse[] prod = new Produse[]{};
        Client cl = new Client();
        for(int i=0; i < clienti.size(); i++){
            if(clienti.get(i).getNrContact().equals(nr)){
                prod = clienti.get(i).getProd();
                cl = clienti.get(i);
            }
        }
        Produse[] prodNou = new Produse[prod.length + 1];
        for(int i=0; i<prod.length; i++){
            prodNou[i] = prod[i];
        }
        prodNou[prod.length] = produs;
        cl.setProd(prodNou);
    }

    @Override
    public Client citesteClient() {
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

        System.out.println("Introduceti numarul de telefon: ");
        clientNou.setNrContact(scanner.next());

        System.out.println("Introduceti numarul de produse pe care le-a achizitionat: ");
        Produse[] produse = new Produse[]{};
        clientNou.setProd(produse);

        return clientNou;
    }
    public void atribuieProduseClientDupaNrContact(String nr){
        System.out.println("Introduceti numarul de produse pe care le-a achizitionat: ");
        int nrProduse = scanner.nextInt();
        Client cl = new Client();
        for(int i=0; i < clienti.size(); i++){
            if(clienti.get(i).getNrContact().equals(nr)){
                cl = clienti.get(i);
            }
        }
        if(cl.getNrContact() != "") {
            Produse[] produse = new Produse[nrProduse];
            for (int i = 0; i < nrProduse; i++) {
                Produse prod = ServiceProdus.getInstance().citesteProdusInFunctieDeOpt();
                produse[i] = prod;
            }
            cl.setProd(produse);
        }else System.out.println("Nu exista clientul cu acest numar de contact!");
    }

}
