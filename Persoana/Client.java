package Persoana;
import Produse.*;

import java.util.Objects;
import java.util.Scanner;

public class Client extends Persoana{
    private String prod;
//    produse devine list de integer si tine id uri de produse pe care le iei cu get prod by id

    public Client(){
        super();
        this.prod = "";
        this.id = 0;
    }
    public Client(int id, String nume, String mail, int varsta, int id_dealership, String prod) {
        super(id, nume, mail, varsta, id_dealership);
        this.prod = prod;
    }

    public Client(Persoana p, String prod, int nrContact) {
        super(p);
        this.prod = prod;
    }


    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return prod.equals(client.prod) && id==(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prod, id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "prod=" + prod +
                ", nrContact='" + id + '\'' +
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
