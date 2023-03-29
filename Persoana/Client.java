package Persoana;
import Produse.*;

import java.util.Objects;
import java.util.Scanner;

public class Client extends Persoana{
    private Produse[] prod;
    private String nrContact;

    public Client(){
        super();
        this.prod = new Produse[]{};
        this.nrContact = "";
    }
    public Client(String nume, String mail, int varsta, Produse[] prod, String nrContact) {
        super(nume, mail, varsta);
        this.prod = prod;
        this.nrContact = nrContact;
    }

    public Client(Persoana p, Produse[] prod, String nrContact) {
        super(p);
        this.prod = prod;
        this.nrContact = nrContact;
    }


    public Produse[] getProd() {
        return prod;
    }

    public void setProd(Produse[] prod) {
        this.prod = prod;
    }

    public String getNrContact() {
        return nrContact;
    }

    public void setNrContact(String nrContact) {
        this.nrContact = nrContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return prod.equals(client.prod) && nrContact.equals(client.nrContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prod, nrContact);
    }

    @Override
    public String toString() {
        StringBuilder prodBuffer = new StringBuilder("");
        for(int i=0; i < prod.length; i++){
            prodBuffer.append(prod[i].toString()).append("\n");
        }
        return "Client{" +
                "prod=" + prodBuffer +
                ", nrContact='" + nrContact + '\'' +
                ", nume='" + nume + '\'' +
                ", mail='" + mail + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    @Override
    public int ReducerePentruAngajat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Doriti sa acordati acestui client reducere? " +
                "\n 1-da" +
                "\n 2-nu");
        int ok = scanner.nextInt();
        if(ok==1) {
            return scanner.nextInt();
        }else return 0;
    }
}
